import java.io.*;
import java.util.StringTokenizer;

public class ques01 {
    public static void main(String[] args) {
        QReader scanner =new QReader();
        QWriter out = new QWriter();
        int cas = scanner.nextInt();

        for (int i = 0; i < cas; i++) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            long[] arr = new long[num1 + num2];
            long[] temp = new long[num1 + num2];
            for (int j = 0; j < num1 + num2; j++) {
                arr[j] = scanner.nextLong();
            }
            long n = merge(arr, num1 - 1, num1 + num2 - 1, temp);
            out.println(n);
            for (long l : temp) {
                out.print(l + " ");
            }
            out.print("\n");
        }
        out.close();
    }

    static long merge(long[] nums, int mi, int ri, long[] te) {
        int p1 = 0;
        int p2 = mi + 1;
        int tm = 0;
        long res = 0;
        while (p1 <= mi || p2 <= ri) {
            if (p1 <= mi && p2 <= ri) {
                if (nums[p1] <= nums[p2]) {
                    te[tm++] = nums[p1];
                    p1++;
                } else {
                    te[tm++] = nums[p2];
                    p2++;
                    res += mi - p1 + 1;
                }
            } else if (p1 <= mi) {
                te[tm++] = nums[p1];
                p1++;
            } else {
                te[tm++] = nums[p2];
                p2++;
            }
        }
        for (int i = 0; i <= ri; i++) {
            nums[i] = te[i];
        }
        return res;
    }

    static class QReader {
        private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer tokenizer = new StringTokenizer("");

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

     static class QWriter implements Closeable {
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
}
