//import java.io.*;
//
//public class q1437 {
//    public static void main(String[] args) throws IOException {
//        Reader scanner = new Reader(System.in);
//        QWriter out = new QWriter();
//        int n = scanner.nextInt();
//        int p = scanner.nextInt();
//        int q = scanner.nextInt();
//        Node[] arr = new Node[n + 1];
//        Node[] temp = new Node[n + 1];
//        for (int i = 1; i <= n; i++) {
//            arr[i] = new Node(scanner.nextInt());
//            arr[i].end = arr[i];
//            temp[i] = arr[i];
//        }
//        Node fir;
//        Node ne;
//        for (int i = 0; i < p; i++) {
//            fir = arr[scanner.nextInt()];
//            int idx = scanner.nextInt();
//            ne = arr[idx];
//            fir.end.next=ne;
//            fir.end = ne.end;
//
//            temp[idx] = null;
//        }
//        int ind = 1;
//        int count = 0;
//        Node tem;
//        while (ind <= n) {
//            tem = temp[ind];
//            if (tem != null) {
//                for (int i = 0; i < q - 1; i++) {
//                    if (tem.next != null) {
//                        tem = tem.next;
//                        count++;
//                    } else break;
//                }
//                if (count == q - 1) {
//                    out.print(tem.value + " ");
//                }
//                count = 0;
//            }
//            ind++;
//        }
//        out.close();
//    }
//
//    static class Node {
//        protected int value;
//        protected Node next;
//        protected Node end;
//
//        public Node() {
//            this.next = null;
//            this.end = null;
//            this.value = 0;
//        }
//
//        public Node(int value) {
//            this.next = null;
//            this.end = null;
//            this.value = value;
//        }
//    }
//}
//
//class Reader {
//    final private int BUFFER_SIZE = 1 << 16;
//    private DataInputStream din;
//    private byte[] buffer;
//    private int bufferPointer, bytesRead;
//
//    public Reader(InputStream in) {
//        din = new DataInputStream(System.in);
//        buffer = new byte[BUFFER_SIZE];
//        bufferPointer = bytesRead = 0;
//    }
//
//    public Reader(String file_name) throws IOException {
//        din = new DataInputStream(new FileInputStream(file_name));
//        buffer = new byte[BUFFER_SIZE];
//        bufferPointer = bytesRead = 0;
//    }
//
//    public String readLine() throws IOException {
//        byte[] buf = new byte[64]; // line length
//        int cnt = 0, c;
//        while ((c = read()) != -1) {
//            if (c == '\n')
//                break;
//            buf[cnt++] = (byte) c;
//        }
//        return new String(buf, 0, cnt);
//    }
//
//    public int nextInt() throws IOException {
//        int ret = 0;
//        byte c = read();
//        while (c <= ' ')
//            c = read();
//        boolean neg = (c == '-');
//        if (neg)
//            c = read();
//        do {
//            ret = ret * 10 + c - '0';
//        } while ((c = read()) >= '0' && c <= '9');
//
//        if (neg)
//            return -ret;
//        return ret;
//    }
//
//    public long nextLong() throws IOException {
//        long ret = 0;
//        byte c = read();
//        while (c <= ' ')
//            c = read();
//        boolean neg = (c == '-');
//        if (neg)
//            c = read();
//        do {
//            ret = ret * 10 + c - '0';
//        }
//        while ((c = read()) >= '0' && c <= '9');
//        if (neg)
//            return -ret;
//        return ret;
//    }
//
//    public double nextDouble() throws IOException {
//        double ret = 0, div = 1;
//        byte c = read();
//        while (c <= ' ')
//            c = read();
//        boolean neg = (c == '-');
//        if (neg)
//            c = read();
//
//        do {
//            ret = ret * 10 + c - '0';
//        }
//        while ((c = read()) >= '0' && c <= '9');
//
//        if (c == '.') {
//            while ((c = read()) >= '0' && c <= '9') {
//                ret += (c - '0') / (div *= 10);
//            }
//        }
//
//        if (neg)
//            return -ret;
//        return ret;
//    }
//
//    private void fillBuffer() throws IOException {
//        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
//        if (bytesRead == -1)
//            buffer[0] = -1;
//    }
//
//    private byte read() throws IOException {
//        if (bufferPointer == bytesRead)
//            fillBuffer();
//        return buffer[bufferPointer++];
//    }
//
//    public void close() throws IOException {
//        if (din == null)
//            return;
//        din.close();
//    }
//}
//
//class QWriter implements Closeable {
//    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//    public void print(Object object) {
//        try {
//            writer.write(object.toString());
//        } catch (IOException e) {
//            return;
//        }
//    }
//
//    public void println(Object object) {
//        try {
//            writer.write(object.toString());
//            writer.write("\n");
//        } catch (IOException e) {
//            return;
//        }
//    }
//
//    @Override
//    public void close() {
//        try {
//            writer.close();
//        } catch (IOException e) {
//            return;
//        }
//    }
//}
