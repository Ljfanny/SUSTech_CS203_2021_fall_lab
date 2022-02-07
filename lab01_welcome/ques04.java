import java.util.Arrays;
import java.util.Scanner;

public class ques04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        long max = scanner.nextLong();
        long min = (long) Math.pow(10, 9);
        long[] a = new long[len - 1];
        long[] b = new long[len - 1];
        long sumA = 0;
        long sumB = 0;

        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextLong();
            sumA += a[i];
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = scanner.nextLong();
            sumB += b[i];
        }
        Arrays.sort(a);
        Arrays.sort(b);
        long diff = sumB - sumA + a[a.length - 1] + a[0] - b[b.length - 1] - b[0] + 1;
        //a,b max
        if (sumB - sumA + a[0] - b[0] < 0) {
            if (a[a.length - 1] - max < min) {
                min = a[a.length - 1] - max;
            }
        }
        //a,b min
        if (sumB - sumA + a[a.length - 1] - b[b.length - 1] < 0) {
            if (1 - b[0] < min) {
                min = 1 - b[0];
            }
        }

        //a,b no
        if (diff >= 1L - max && diff <= max - 1L) {
            if (diff < min) {
                min = diff;
            }
        }

        //a min,b max
        if (sumB - sumA + a[a.length - 1] - b[0] < 0) {
            if (1 - max < min) {
                min = 1 - max;
            }
        }
        //a max,b min
        if (sumB - sumA + a[0] - b[b.length - 1] < 0) {
            if (a[a.length - 1] - b[0] < min) {
                min = a[a.length - 1] - b[0];
            }
        }
        //a no,b min
        if (diff + b[0] > a[0] && diff + b[0] < a[a.length - 1]) {
            if (diff < min) {
                min = diff;
            }
        }
        //a no,b max
        if (diff + b[b.length - 1] > a[0] && diff + b[b.length - 1] < a[a.length - 1]) {
            if (diff + b[b.length - 1] - max < min) {
                min = diff + b[b.length - 1] - max;
            }
        }
        //a min,b no
        if (-diff + a[0] > b[0] && -diff + a[0] < b[b.length - 1]) {
            if (1 + diff - a[0] < min) {
                min = 1 + diff - a[0];
            }
        }
        //a max,b no
        if (-diff + a[a.length - 1] > b[0] && -diff + a[a.length - 1] < b[b.length - 1]) {
            if (-a[a.length - 1] * 2 + diff < min) {
                min = -a[a.length - 1] * 2 + diff;
            }
        }
        if (min != Math.pow(10, 9))
            System.out.print(min);
        else System.out.print("IMPOSSIBLE");
    }
}
