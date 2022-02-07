import java.io.*;
import java.util.StringTokenizer;

public class ques03 {
    public static int insertionN = 0;
    public static int selectionN = 0;

    public static void main(String[] args) {
        QReader scanner = new QReader();
        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            int nums = scanner.nextInt();
            selectionN = 0;
            insertionN = 0;
            long[] arr1 = new long[nums];
            long[] arr2 = new long[nums];
            for (int i1 = 0; i1 < nums; i1++) {
                arr1[i1] = scanner.nextLong();
                arr2[i1] = arr1[i1];
            }
            insert(arr1);
            select(arr2);
            for (int i1 = 0; i1 < nums; i1++) {
                System.out.print(arr1[i1] + " ");
            }
            System.out.print("\n");
            if (selectionN > insertionN)
                System.out.println("Insertion Sort wins!");
            else System.out.println("Selection Sort wins!");
        }
    }

    static void insert(long[] arr) {
        int index;
        for (int i = 1; i < arr.length; i++) {
            index = i;
            while (index - 1 >= 0) {
                if (change1(arr, index - 1, index))
                    index--;
                else break;
            }
        }
    }

    static void select(long[] arr) {
        for (int index = 0; index < arr.length; index++) {
            int min = index;
            for (int i = index + 1; i < arr.length; i++) {
                selectionN++;
                if (arr[min] > arr[i])
                    min = i;
            }
            change2(arr, index, min);
        }
    }

    static boolean change1(long[] nums, int i, int j) {
        if (nums[i] > nums[j]) {
            long temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            insertionN += 2;
            return true;
        } else {
            insertionN++;
            return false;
        }
    }

    static void change2(long[] nums, int i, int j) {
        long temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        selectionN++;
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
