import java.io.*;
import java.util.StringTokenizer;

public class q1450 {
    public static void main(String[] args) throws IOException {
        QReader scanner = new QReader();
        QWriter out = new QWriter();
        String str = scanner.next();
        if (str.length() < 2) {
            out.println(1);
            out.close();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append('*');
            stringBuilder.append(str.charAt(i));
        }
        stringBuilder.append('*');
        str = stringBuilder.toString();
        char[] chars = str.toCharArray();
        int[] sub = new int[chars.length];
        int max = 1;
        int mid = 0;
        int center = 0;
        int right = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i < right) {
                int tem = center - (i - center);
                sub[i] = Math.min(sub[tem], right - i);
            }
            trans(sub, i, chars);
            if (max < sub[i]) {
                max = sub[i];
                mid = i;
            }
            if (i + sub[i] > right) {
                right = i + sub[i];
                center = i;
            }
        }
        if (chars[mid] == '*')
            out.println(max / 2 * 2);
        else out.println((max - 1) / 2 * 2 + 1);
        out.close();
    }

    static void trans(int[] sub, int i, char[] chs) {
        int left = i - sub[i] - 1;
        int right = i + sub[i] + 1;
        while (left >= 0 && right < sub.length && chs[left] == chs[right]) {
            left--;
            right++;
            sub[i]++;
        }
    }
}

class QWriter implements Closeable {
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(Object object) {
        try {
            writer.write(object.toString());
        } catch (IOException e) {
            return;
        }
    }

    public void println(Object object) {
        try {
            writer.write(object.toString());
            writer.write("\n");
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            return;
        }
    }
}

class QReader {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = new StringTokenizer("");

    QReader() throws FileNotFoundException {
    }

    private String innerNextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return false;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
        return true;
    }

    public String nextLine() {
        tokenizer = new StringTokenizer("");
        return innerNextLine();
    }

    public String next() {
        hasNext();
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}
