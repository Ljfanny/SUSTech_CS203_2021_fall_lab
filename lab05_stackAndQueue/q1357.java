//import java.io.*;
//import java.util.StringTokenizer;
//
//public class q1357 {
//    public static void main(String[] args) throws IOException {
//        QReader scanner = new QReader();
//        QWriter out = new QWriter();
//        int cases = scanner.nextInt();
//        for (int i = 0; i < cases; i++) {
//            int num = scanner.nextInt();
//            if (num % 2 != 0) {
//                out.println("NO");
//                scanner.nextLine();
//            } else {
//                Stack stack = new Stack(num);
//
//                String arr = scanner.nextLine();
//                char[] tem = arr.toCharArray();
//                for (int i1 = 0; i1 < num; i1++) {
//                    if (tem[i1] == '(' || tem[i1] == '{' || tem[i1] == '[')
//                        stack.push(tem[i1]);
//                    else {
//                        if (i1 == 0) {
//                            out.println("NO");
//                            break;
//                        }
//                        if (stack.peek() == '(' && tem[i1] == ')')
//                            stack.pop();
//                        else if (stack.peek() == '[' && tem[i1] == ']')
//                            stack.pop();
//                        else if (stack.peek() == '{' && tem[i1] == '}')
//                            stack.pop();
//                        else {
//                            stack.push(tem[i1]);
//                        }
//                    }
//                    if ( i1 == num - 1  && stack.isEmpty()) {
//                        out.println("YES");
//                        break;
//                    }
//                    if(i1 == num - 1 && !stack.isEmpty()) {
//                        out.println("NO");
//                    }
//
//                }
//            }
//        }
//        out.close();
//    }
//
//    static class Stack {
//        protected char[] chars;
//        protected int index;
//
//        public Stack(int len) {
//            this.chars = new char[len];
//            this.index = -1;
//        }
//
//        public void pop() {
//            if (this.index >= 0) {
//                this.index--;
//            }
//        }
//
//        public char peek() {
//            return this.chars[index];
//        }
//
//        public void push(char item) {
//            this.index++;
//            this.chars[index] = item;
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