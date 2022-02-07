//import java.io.*;
//import java.util.StringTokenizer;
//
//public class q1443 {
//    public static void main(String[] args) throws IOException {
//        QReader scanner = new QReader();
//        QWriter out = new QWriter();
//        int T = scanner.nextInt();
//        Stack stack = new Stack(T);
//        Queue queue = new Queue(T * 1000);
//        for (int i = 0; i < T; i++) {
//            String what = scanner.next();
//            if (what.equals("NewComer")) {
//                String fav = scanner.next();
//                queue.push(fav);
//            } else if (what.equals("NewFood")) {
//                String food = scanner.next();
//                stack.push(food);
//            } else {
//                if (!stack.isEmpty() && !queue.isEmpty()){
//                    if (queue.peek().equals(stack.peek())) {
//                        queue.pop();
//                        stack.pop();
//                    } else {
//                        String m_stu = queue.peek();
//                        queue.pop();
//                        queue.push(m_stu);
//                    }
//                }
//            }
//        }
//
//        if (queue.isEmpty())
//            out.println("Qi Fei!");
//        else {
//            int len_q = queue.rear - queue.front;
//            int len_s = Stack.cou;
//            int count = 0;
//            while (!stack.isEmpty() && !queue.isEmpty() && count < len_q * len_s) {
//                if (queue.peek().equals(stack.peek())) {
//                    stack.pop();
//                    queue.pop();
//                } else {
//                    String m_stu = queue.peek();
//                    queue.pop();
//                    queue.push(m_stu);
//                }
//                count++;
//            }
//            if (queue.isEmpty())
//                out.println("Qi Fei!");
//            else
//                out.println(queue.rear - queue.front);
//        }
//        out.close();
//    }
//
//    static class Stack {
//        protected String[] orders;
//        protected int index;
//        static int cou = 0;
//
//        public Stack(int len) {
//            this.orders = new String[len];
//            this.index = -1;
//        }
//
//        public void pop() {
//            if (this.index >= 0) {
//                this.index--;
//                cou--;
//            }
//        }
//
//        public String peek() {
//            return this.orders[index];
//        }
//
//        public void push(String item) {
//            this.index++;
//            this.orders[index] = item;
//            cou++;
//        }
//
//        public boolean isEmpty() {
//            return this.index == -1;
//        }
//    }
//
//    static class Queue {
//        protected int front = 0;
//        protected int rear = 0;//多一个
//        static int nums = 0;
//        protected String[] stu;
//
//        public Queue(int len) {
//            this.stu = new String[len];
//        }
//        public void pop() {
//            this.front++;
//            nums--;
//        }
//
//        public String peek() {
//            return stu[front];
//        }
//
//        public void push(String item) {
//            stu[rear++] = item;
//            nums++;
//        }
//
//        public boolean isEmpty() {
//            return nums == 0;
//        }
//
//    }
//
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
