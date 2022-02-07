//import java.io.*;
//import java.util.Arrays;
//
//public class q1438 {
//    public static void main(String[] args) throws IOException {
//        Reader scanner = new Reader(System.in);
//        QWriter out = new QWriter();
//        int n = scanner.nextInt();
//        Node[] arr1 = new Node[n];
//        Node[] arr2 = new Node[n];
//        for (int i = 0; i < n; i++)
//            arr1[i] = new Node(scanner.nextLong(), i);
//        System.arraycopy(arr1, 0, arr2, 0, n);
//        Arrays.sort(arr2);
//        int index = 0;
//        Node head = new Node();
//        Node now;
//        now = head;
//        for (int i = 0; i < n; i++) {
//            now.next = arr2[i];
//            now = now.next;
//            if (i - 1 >= 0)
//                now.prev = arr2[i - 1];
//        }
//        Node present;
//        while (index < n - 1) {
//            present = arr1[index];
//            if (present.prev != null && present.next != null) {
//                out.print(Math.min(Math.abs(present.prev.value - present.value), Math.abs(present.next.value - present.value)));
//                present.prev.next = present.next;
//                present.next.prev = present.prev;
//
//            } else if (present.prev != null) {
//                out.print(Math.abs(present.prev.value - present.value));
//                present.prev.next = null;
//            } else {
//                out.print(Math.abs(present.next.value - present.value));
//                present.next.prev = head;
//                head.next = present.next;
//            }
//            present.prev=null;
//            present.next=null;
//            if (index!=n-2)
//                out.print(" ");
//            index++;
//        }
//        out.close();
//    }
//
//    static class Node implements Comparable<Node> {
//        protected long value;
//        protected int ind;
//        protected Node next;
//        protected Node prev;
//
//        public Node() {
//            this.prev = null;
//            this.next = null;
//            this.value = 0;
//            this.ind = -1;
//        }
//
//        public Node(long a, int ind) {
//            this.next = null;
//            this.prev = null;
//            this.value = a;
//            this.ind = ind;
//        }
//
//        @Override
//        public int compareTo(Node o) {
//            return (int)(this.value - o.value);
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