//import java.io.*;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//public class q1376 {
//    public static void main(String[] args) throws IOException {
//        QReader scanner = new QReader();
//        QWriter out = new QWriter();
//        long k = scanner.nextLong();
//        int len = scanner.nextInt();
//        long[] arr = new long[len];
//        if (len == 1)
//            out.println(scanner.nextLong());
//        else {
//            for (int i = 0; i < len; i++) {
//                arr[i] = scanner.nextLong();
//            }
//            int le = 0;
//            int ri = 0;
//            int bet = 0;
//            Queue max = new Queue(len);
//            Queue min = new Queue(len);
//            while (ri <= len - 1 && le <= len - 1) {
//                while (!min.isEmpty() && min.rear().val > arr[ri]) {
//                    min.popRear();
//                }
//                while (!max.isEmpty() && max.rear().val < arr[ri]) {
//                    max.popRear();
//                }
//                max.push(new Node(ri, arr[ri]));
//                min.push(new Node(ri, arr[ri]));
//                while (!min.isEmpty() && !max.isEmpty() && Math.abs(max.peek().val - min.peek().val) > k) {
//                    le++;
//                    while (!min.isEmpty() && min.peek().index < le) {
//                        min.pop();
//                    }
//                    while (!max.isEmpty() && max.peek().index < le) {
//                        max.pop();
//                    }
//                }
//                bet = Math.max(bet, ri - le + 1);
//                ri++;
//            }
//            out.println(bet);
//        }
//        out.close();
//    }
//
//    static class Queue {
//        protected int front = 0;
//        protected int rear = 0;
//        protected int n = 0;
//        protected Node[] nums;
//
//        public Queue(int len) {
//            this.nums = new Node[len];
//        }
//
//        public void pop() {
//            this.front++;
//            n--;
//        }
//
//        public void popRear() {
//            this.rear--;
//            n--;
//        }
//
//        public Node rear() {
//            return nums[rear - 1];
//        }
//
//        public Node peek() {
//            return nums[front];
//        }
//
//        public void push(Node item) {
//            nums[rear++] = item;
//            n++;
//        }
//
//        public boolean isEmpty() {
//            return this.n == 0;
//        }
//    }
//
//    static class Node {
//        protected int index;
//        protected long val;
//
//        public Node(int index, long val) {
//            this.index = index;
//            this.val = val;
//        }
//    }
//
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
//
//
