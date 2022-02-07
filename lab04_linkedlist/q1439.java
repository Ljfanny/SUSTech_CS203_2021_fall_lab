//import java.io.*;
//import java.util.ArrayList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class q1439 {
//    public static void main(String[] args) throws IOException {
//        Reader scanner = new Reader(System.in);
////        Scanner scanner = new Scanner(new File("2.in"));
//        QWriter out = new QWriter();
//        int cases = scanner.nextInt();
//        for (int i = 0; i < cases; i++) {
//            ArrayList<Node> td = new ArrayList<>();
//            ArrayList<Node> dt = new ArrayList<>();
//            int nums = scanner.nextInt();
//            Node head = new Node();
//            Node temp = head;
//            for (int i1 = 0; i1 < nums; i1++) {
//                temp.next = new Node(scanner.nextInt());
//                temp.next.pr = temp;
//                temp.index = i1;
//                temp = temp.next;
//                td.add(temp);
//            }
//            temp.index=nums;
//            if (nums == 1) {
//                out.println(head.next.value);
//                continue;
//            }
//            while (true) {
//                Node node = head.next;
//                boolean isRight = false;
//                boolean isRight2 = false;
//                int ii = 0;
//                while (ii < td.size()) {
//                    node = td.get(ii);
//                    if (node.next != null) {
//                        while (node.next != null && node.value > node.next.value) {
//                            if (node.next.next == null) {
//                                node.pr.next = null;
//                                isRight = true;
//                                isRight2 = true;
//                                node.index=99999999;
//                                break;
//                            } else if (node.next.next.value >= node.next.value) {
//                                Node t = node.pr;
//                                t.next = node.next.next;
//                                node = node.next.next;
//                                node.pr = t;
//                            } else {
//                                Node t = node.pr;
//                                t.next = node.next;
//                                node = node.next;
//                                node.pr = t;
//                            }
//                            isRight = true;
//                            isRight2 = true;
//                        }
//                        Node prev = node.pr;
//                        if (isRight)
//                            dt.add(prev);
//                        while (ii < td.size() && td.get(ii).index <= node.index)
//                            ii++;
//                        isRight = false;
//                    }
//                    else break;
//                }
//                if (!isRight2)
//                    break;
//                else {
//                    td.clear();
//                    for (Node node1 : dt) {
//                        td.add(node1);
//                    }
//                    dt.clear();
//                }
//            }
//            if (head.next != null) {
//                head = head.next;
//                while (head.next != null) {
//                    out.print(head.value + " ");
//                    head = head.next;
//                }
//                out.print(head.value);
//            }
//            out.println("");
//        }
//        out.close();
//    }
//
//    static class Node {
//        protected int value;
//        protected Node next;
//        protected Node pr;
//        protected int index;
//
//        public Node() {
//            this.next = null;
//            this.value = 0;
//        }
//
//        public Node(int a) {
//            this.next = null;
//            this.value = a;
//        }
//    }
//
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
