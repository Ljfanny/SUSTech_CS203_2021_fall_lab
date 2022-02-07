import java.util.Scanner;

public class ques02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            long temp = scanner.nextLong();
            long part01 = temp * (temp + 1) * (2 * temp + 1) / 6;
            long part02 = temp * (temp + 1) / 2;
            System.out.println((part01 + part02)/2);
        }
    }
}


