//import java.io.*;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//public class q1436 {
//    public static void main(String[] args) {
//        QWriter out = new QWriter();
//        QReader scanner = new QReader();
//        long n = scanner.nextLong();
//        int num = scanner.nextInt();
//        Node head = new Node();
//        Node now = new Node();
//        Node next = new Node();
//        now = head;
//        for (long i = 1; i <= n; i++) {
//            next = new Node(i);
//            now.next = next;
//            now = next;
//        }
//        int count = 0;
//        now = head.next;
//        Node prev = new Node();
//        prev = head;
//        while (count < n) {
//            out.print(now.value + " ");
//            count++;
//            prev.next = now.next;
//            for (int i = 0; i < num; i++) {
//                if (now.next == null) {
//                    prev = head;
//                    now = head.next;
//                    break;
//                }
//                prev = now;
//                now = now.next;
//            }
//        }
//        out.close();
//    }
//
//    static class Node {
//        protected long value;
//        protected Node next;
//
//        public Node() {
//            this.next = null;
//            this.value = 0;
//        }
//
//        public Node(long a) {
//            this.next = null;
//            this.value = a;
//
//        }
//
//        public Node(long a, Node b) {
//            this.next = b;
//            this.value = a;
//
//        }
//
//    }
//}
//class QReader {
//    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    private StringTokenizer tokenizer = new StringTokenizer("");
//
//    private String innerNextLine() {
//        try {
//            return reader.readLine();
//        } catch (IOException e) {
//            return null;
//        }
//    }
//
//    public boolean hasNext() {
//        while (!tokenizer.hasMoreTokens()) {
//            String nextLine = innerNextLine();
//            if (nextLine == null) {
//                return false;
//            }
//            tokenizer = new StringTokenizer(nextLine);
//        }
//        return true;
//    }
//
//    public String nextLine() {
//        tokenizer = new StringTokenizer("");
//        return innerNextLine();
//    }
//
//    public String next() {
//        hasNext();
//        return tokenizer.nextToken();
//    }
//
//    public int nextInt() {
//        return Integer.parseInt(next());
//    }
//
//    public long nextLong() {
//        return Long.parseLong(next());
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
//
//
//
