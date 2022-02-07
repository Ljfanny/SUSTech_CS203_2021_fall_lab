import java.util.Scanner;

public class ques05 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int len = sca.nextInt();
        int num = sca.nextInt();
        long[] a = new long[len];
        long[] b = new long[len];

        for (int i = 0; i < len; i++) {
            a[i] = sca.nextLong();
        }
        for (int i = 0; i < len; i++) {
            b[i] = sca.nextLong();
        }
        for (int i = 0; i < num; i++) {
            int left = sca.nextInt();
            int right = sca.nextInt();
            int count = 0;
            if (right == left) {
                System.out.println(Math.min(a[right - 1], b[right - 1]));
                continue;
            }
            int total = right - left + 1;
            int half = (right - left+1) / 2;
            int le1 = left - 1;
            int le2 = left - 1;
            while (half != 0) {
                if (a[le1 + half - 1] <= b[le2 + half - 1]) {
                    le1 += half;
                } else {
                    le2 += half;
                }
                count += half;
                half = (total - count) / 2;
            }
            System.out.println(Math.min(a[le1], b[le2]));
        }
    }
}