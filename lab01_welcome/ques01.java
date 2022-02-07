import java.util.Scanner;

public class ques01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len01 = scanner.nextInt();
        int[] a = new int[len01];
        for (int i = 0; i < len01; i++) {
            a[i] = scanner.nextInt();
        }

        int len02 = scanner.nextInt();
        int[] b = new int[len02];
        for (int i = 0; i < len02; i++) {
            b[i] = scanner.nextInt();
        }
        for (int tem : b) {
            boolean judge = false;
            for (int i = 0; i < a.length; i++) {
                if (a[i] == tem) {
                    System.out.println("yes");
                    judge = true;
                    break;
                }
            }
            if (!judge)
                System.out.println("no");
        }
    }
}
