//import java.io.*;
//
//import java.util.StringTokenizer;
//
//public class q1435 {
//
//    public static void main(String[] args) {
//        QReader scanner = new QReader();
//        QWriter out = new QWriter();
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        Node headn = new Node();
//        Node headm = new Node();
//        Node headres = new Node();
//        Node now = new Node();
//        now = headres;
//        Node pervn = new Node();
//        Node pervm = new Node();
//        pervn = headn;
//        pervm = headm;
//        for (int i = 1; i <= n; i++) {
//            Node node = new Node(scanner.nextInt(), scanner.nextInt());
//            pervn.next = node;
//            pervn = node;
//        }
//
//        for (int i = 1; i <= m; i++) {
//            Node node = new Node(scanner.nextInt(), scanner.nextInt());
//            pervm.next = node;
//            pervm = node;
//        }
//
//        pervn = headn.next;
//        pervm = headm.next;
//        int count1 = 0;
//        int count2 = 0;
//        int count = 0;
//        while (count1 < n && count2 < m) {
//            if (pervn.poly > pervm.poly) {
//                now.next = new Node(pervn.value, pervn.poly);
//                now = now.next;
//                pervn = pervn.next;
//                count1++;
//                count++;
//            } else if (pervn.poly < pervm.poly) {
//                now.next = new Node(pervm.value, pervm.poly);
//                now = now.next;
//                pervm = pervm.next;
//                count2++;
//                count++;
//            } else {
//                now.next = new Node(pervm.value + pervn.value, pervm.poly);
//                now = now.next;
//                pervm = pervm.next;
//                pervn = pervn.next;
//                count1++;
//                count2++;
//                count++;
//            }
//        }
//
//        while (count1 < n) {
//            now.next = new Node(pervn.value, pervn.poly);
//            now = now.next;
//            pervn = pervn.next;
//            count++;
//            count1++;
//        }
//        while (count2 < m) {
//            now.next = new Node(pervm.value, pervm.poly);
//            now = now.next;
//            pervm = pervm.next;
//            count++;
//            count2++;
//        }
//
//        out.println(count);
//        while (headres.next != null) {
//            out.println(headres.next.value +" "+ headres.next.poly);
//            headres = headres.next;
//        }
//        out.close();
//    }
//
//    static class Node {
//        protected int value;
//        protected int poly;
//        protected Node next;
//
//        public Node() {
//            this.next = null;
//            this.value = 0;
//            this.poly = 0;
//        }
//
//        public Node(int a, int b) {
//            this.next = null;
//            this.value = a;
//            this.poly = b;
//        }
//    }
//}
//
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
