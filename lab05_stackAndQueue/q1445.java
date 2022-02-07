//import java.io.*;
//import java.util.StringTokenizer;
//
//public class q1445 {
//    public static void main(String[] args) throws IOException {
//        QReader scanner = new QReader();
//        QWriter out = new QWriter();
//        String str = scanner.nextLine();
//        char[] tem = str.toCharArray();
//        Stack stack = new Stack(tem.length);
//        long answer = 0L;
//        for (int i1 = 0; i1 < tem.length; i1++) {
//            if (tem[i1] == '(')
//                stack.push(tem[i1]);
//            else {
//                if (tem[i1] == ')') {
//                    if (stack.peek().score == 0) {
//                        stack.pop();
//                        if (!stack.isEmpty())
//                            stack.peek().score++;
//                        else answer++;
//                    } else {
//                        long score = (stack.peek().score % 514329L * 2) % 514329L;
//                        stack.pop();
//                        if (!stack.isEmpty()) {
//                            stack.peek().score = score + stack.peek().score % 514329L;
//                        }else {
//                            answer = (answer + score) % 514329L;
//                        }
//                    }
//                }
//            }
//        }
//        out.println(answer);
//        out.close();
//    }
//
//    static class Point {
//        protected long score;
//        protected char ch;
//
//        public Point(char ch) {
//            this.ch = ch;
//            this.score = 0;
//        }
//    }
//
//    static class Stack {
//        protected Point[] points;
//        protected int index;
//        static int cou = 0;
//
//        public Stack(int len) {
//            this.points = new Point[len];
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
//        public Point peek() {
//            return this.points[index];
//        }
//
//        public void push(char item) {
//            this.index++;
//            this.points[index] = new Point(item);
//            cou++;
//        }
//
//        public boolean isEmpty() {
//            return this.index == -1;
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
