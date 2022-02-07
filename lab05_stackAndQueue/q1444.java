//import java.io.*;
//import java.io.Closeable;
//import java.io.OutputStreamWriter;
//import java.util.StringTokenizer;
//
//public class q1444 {
//    public static void main(String[] args) throws IOException {
//        QReader scanner = new QReader();
//        QWriter out = new QWriter();
//        int pairs = scanner.nextInt();
//        int[] pair = new int[pairs + 1];
//        for (int i = 1; i <= pairs; i++) {
//            pair[i] = 0;
//        }
//        int p_len = scanner.nextInt();
//        int q_len = scanner.nextInt();
//        Queue p = new Queue(p_len);
//        Queue q = new Queue(q_len);
//        for (int i = 0; i < p_len; i++) {
//            p.push(scanner.nextInt());
//        }
//        for (int i = 0; i < q_len; i++) {
//            q.push(scanner.nextInt());
//        }
//        int p_p = 0;
//        int p_q = 0;
//        int time = 1;
//        while (p_p < p_len && p_q < q_len) {
//            pair[q.peek()] = time;
//            pair[p.peek()] = time;
//            p.pop();
//            q.pop();
//            p_p++;
//            p_q++;
//            time++;
//            while (!p.isEmpty()) {
//                if (pair[p.peek()] != 0) {
//                    p.pop();
//                    p_p++;
//                } else {
//                    break;
//                }
//            }
//            while (!q.isEmpty()) {
//                if (pair[q.peek()] != 0) {
//                    q.pop();
//                    p_q++;
//                } else {
//                    break;
//                }
//            }
//        }
//        while (p_p < p_len) {
//            pair[p.peek()] = time;
//            p.pop();
//            p_p++;
//            time++;
//
//            while (!p.isEmpty()) {
//                if (pair[p.peek()] != 0) {
//                    p.pop();
//                    p_p++;
//                } else {
//                    break;
//                }
//            }
//
//        }
//        while (p_q < q_len) {
//            pair[q.peek()] = time;
//            q.pop();
//            p_q++;
//            time++;
//            while (!q.isEmpty()) {
//                if (pair[q.peek()] != 0) {
//                    q.pop();
//                    p_q++;
//                } else {
//                    break;
//                }
//            }
//        }
//        for (int i = 1; i <= pairs; i++) {
//            out.print(pair[i] + " ");
//        }
//        out.close();
//    }
//
//    static class Queue {
//        protected int front = 0;
//        protected int rear = 0;
//        protected int[] stu;
//
//        public Queue(int len) {
//            this.stu = new int[len];
//        }
//
//        public void pop() {
//            this.front++;
//        }
//
//        public int peek() {
//            return stu[front];
//        }
//
//        public void push(int item) {
//            stu[rear++] = item;
//        }
//
//        public boolean isEmpty() {
//            return this.rear == this.front;
//        }
//
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
//class QReader {
//    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    private StringTokenizer tokenizer = new StringTokenizer("");
//
//    QReader() throws FileNotFoundException {
//    }
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
