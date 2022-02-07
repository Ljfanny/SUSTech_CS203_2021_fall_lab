//import java.io.*;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//public class q1342 {
//    public static void main(String[] args) throws IOException {
//        QReader scanner = new QReader();
//        QWriter out = new QWriter();
//        while (scanner.hasNext()) {
//            int len = scanner.nextInt();
//            Query[] arr = new Query[len + 1];
//            for (int i = 1; i <= len; i++) {
//                arr[i] = new Query();
//            }
//            int cases = scanner.nextInt();
//            for (int i = 0; i < cases; i++) {
//                int type = scanner.nextInt();
//                if (type == 1) {
//                    int u = scanner.nextInt();
//                    int w = scanner.nextInt();
//                    int val = scanner.nextInt();
//                    arr[u].push(w, val);
//                } else if (type == 2) {
//                    int u = scanner.nextInt();
//                    int w = scanner.nextInt();
//                    out.println(arr[u].pop(w));
//                } else {
//                    int u = scanner.nextInt();
//                    int v = scanner.nextInt();
//                    int w = scanner.nextInt();
//                    connect(arr[u], arr[v], w);
//                }
//            }
//        }
//        out.close();
//    }
//
//    static class Query {
//        protected int[] orders;
//        protected int front;
//        protected int rear;
//        protected int nums = 0;
//
//        public Query() {
//            this.orders = new int[100];
//            this.front = 49;
//            this.rear = 50;
//        }
//
//        public int pop(int w) {
//
//            if (w == 0) {
//                if (1+front > rear - 1)
//                    return -1;
//                else {
//                    this.nums--;
//                    return orders[++front];
//                }
//            } else {
//                if (rear-1 < front + 1)
//                    return -1;
//                else {
//                    this.nums--;
//                    return orders[--rear];
//                }
//            }
//        }
//
//        public void push(int w, int val) {
//            this.nums++;
//            if (w == 0) {
//                this.orders[front--] = val;
//            } else {
//                this.orders[rear++] = val;
//            }
//        }
//
//        public int peek(int w) {
//            if (w == 0) {
//                return orders[front + 1];
//            } else {
//                return orders[rear - 1];
//            }
//        }
//
//        public boolean isEmpty() {
//            return this.nums == 0;
//        }
//    }
//
//    public static void connect(Query u, Query v, int w) {
//        if (w == 1) {
//            while (!v.isEmpty())
//                u.push(1, v.pop(w));
//
//        } else {
//            while (!v.isEmpty())
//                u.push(1, v.pop(w));
//        }
//    }
//
//    static class QWriter implements Closeable {
//        private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        QWriter() throws FileNotFoundException {
//        }
//
//        public void print(Object object) {
//            try {
//                writer.write(object.toString());
//            } catch (IOException e) {
//                return;
//            }
//        }
//
//        public void println(Object object) {
//            try {
//                writer.write(object.toString());
//                writer.write("\n");
//            } catch (IOException e) {
//                return;
//            }
//        }
//
//        @Override
//        public void close() {
//            try {
//                writer.close();
//            } catch (IOException e) {
//                return;
//            }
//        }
//    }
//
//    static class QReader {
//        private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        private StringTokenizer tokenizer = new StringTokenizer("");
//
//        QReader() throws FileNotFoundException {
//        }
//
//        private String innerNextLine() {
//            try {
//                return reader.readLine();
//            } catch (IOException e) {
//                return null;
//            }
//        }
//
//        public boolean hasNext() {
//            while (!tokenizer.hasMoreTokens()) {
//                String nextLine = innerNextLine();
//                if (nextLine == null) {
//                    return false;
//                }
//                tokenizer = new StringTokenizer(nextLine);
//            }
//            return true;
//        }
//
//        public String nextLine() {
//            tokenizer = new StringTokenizer("");
//            return innerNextLine();
//        }
//
//        public String next() {
//            hasNext();
//            return tokenizer.nextToken();
//        }
//
//        public int nextInt() {
//            return Integer.parseInt(next());
//        }
//
//        public long nextLong() {
//            return Long.parseLong(next());
//        }
//    }
//}
