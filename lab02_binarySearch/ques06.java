import java.util.Scanner;

public class ques06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        long mid;

        for (int i = 0; i < cases; i++) {
            long hi = 50000L * 50000L * 3L;
            long lo = -50000L * 50000L * 3L;
            int dim = scanner.nextInt();
            long rank = scanner.nextLong();
            while (lo <= hi) {
                mid = (hi - lo) / 2 + lo;
                long midCal = 0;
                for (int i1 = 1; i1 <= dim; i1++) {
                    midCal += dimCal(dim, i1, mid);
                }
                if (midCal > rank - 1) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            System.out.println(lo-1 );
        }

    }

    //i2+12345×i+j2−12345×j+i×j
    public static long dimCal(long dim, long j, long jud) {
        long left = 1;
        long right = dim;
        long mid = (right - left) / 2 + left;
        while (left <= right) {
            if (jud > j * j + mid * mid + 12345 * (mid - j) + mid * j) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (right - left) / 2 + left;
        }
        return left - 1;
    }
}
