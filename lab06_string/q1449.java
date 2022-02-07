//import java.io.*;
//import java.util.StringTokenizer;
//
//public class q1449 {
//    public static void main(String[] args) throws IOException {
//        QReader scanner = new QReader();
//        QWriter out = new QWriter();
//        String str = scanner.next();
//        String goal = scanner.next();
//        if (str.length() != goal.length()){
//            out.println("No");
//            out.close();
//            return;
//        }
//        char[] chs = goal.toCharArray();
//        int[] next = new int[chs.length];
//        next[0] = 0;
//        int p = 0;
//        for (int i = 1; i < chs.length; i++) {
//            while (true) {
//                if (p > 0 && chs[i] != chs[p]) {
//                    p = next[p - 1];
//                } else break;
//            }
//            if (chs[i] == chs[p])
//                p++;
//            next[i] = p;
//        }
//        char[] research = new char[str.length() * 2];
//        int times = 0;
//        int in = 0;
//        while (times < 2) {
//            for (int i = 0; i < str.length(); i++) {
//                research[in++] = str.charAt(i);
//            }
//            times++;
//        }
//
//        int index = 0;
//        for (char c : research) {//a
//            while (true) {
//                if (index > 0 && chs[index] != c) {
//                    index = next[index - 1];
//                } else break;
//            }
//            if (chs[index] == c)
//                index++;
////            else {
////                if (index > 0) {
////                    index -= index - next[index - 1];
////                    i--;
////                }
////            }
//            if (index == chs.length)
//                break;
//        }
//        if (index == chs.length)
//            out.println("Yes");
//        else out.println("No");
//        out.close();
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
