//import java.io.*;
//import java.nio.charset.StandardCharsets;
//import java.util.StringTokenizer;
//
//public class q1452 {
//    public static void main(String[] args) throws IOException {
//        QReader scanner = new QReader();
//        QWriter out = new QWriter();
//        char[] table = new char[123];
//        for (int i = 97; i < table.length; i++) {
//            table[i] = scanner.next().charAt(0);
//        }
//        String str = scanner.next();
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < str.length(); i++) {
//            stringBuilder.append(table[str.charAt(i)]);
//        }
//        String combine = str + stringBuilder.toString();
//        char[] chs = combine.toCharArray();
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
//        out.println(str.length() - next[chs.length - 1]);
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