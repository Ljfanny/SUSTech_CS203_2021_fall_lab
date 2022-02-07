import java.util.Scanner;

public class ques03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            double temp = scanner.nextDouble();
            double res = 129 * Math.exp((double) 129 / 20);
            System.out.printf("%.10f\n", bi(temp, 0, 258, 0));
        }
    }

    public static double bi(double temp, double min, double max, double res) {
        double mid = (max+min) / 2;
        if (Math.abs(res - mid * Math.exp(mid / 20)) >= 0.00000000001) {
            if (mid * Math.exp(mid / 20) > temp)
               return bi(temp, min, mid, mid * Math.exp(mid / 20));
            if (mid * Math.exp(mid / 20) < temp)
               return bi(temp, mid, max, mid * Math.exp(mid / 20));
        }
        else
            return mid;
        return mid;
    }
}
