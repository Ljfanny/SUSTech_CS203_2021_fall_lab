import java.io.*;
import java.util.StringTokenizer;

public class ques04 {
    public static void main(String[] args) {
        QReader scanner = new QReader();
        QWriter out = new QWriter();
        int nums = scanner.nextInt();
        long[] arr = new long[nums];
        for (int i = 0; i < nums; i++) {
            arr[i] = scanner.nextLong();
        }
        quickSorting(arr, 0, nums - 1);
        System.out.print(arr[0] + " ");
        for (int i = 1; i < nums - 1; i += 2) {
            change(arr, i, i + 1);
            System.out.print(arr[i] + " " + arr[i + 1] + " ");
        }
        if (nums % 2 == 0)
            System.out.print(arr[nums - 1]);


    }

    static void quickSorting(long[] nums, int lo, int hi) {
        if (lo < hi) {
            int goal = separate(nums, lo, hi);
            quickSorting(nums, goal + 1, hi);
            quickSorting(nums, lo, goal - 1);
        }
    }

    static int separate(long[] nums, int le, int ri) {
        int index = ri + 1;
        long goalNum = nums[le];
        for (int i = ri; i > le; --i) {
            if (nums[i] >= goalNum) {
                index--;
                change(nums, index, i);
            }
        }
        change(nums, le, --index);
        return index;
    }

    static void change(long[] nums, int i, int j) {
        long temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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
