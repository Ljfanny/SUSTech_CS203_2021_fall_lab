import java.util.Scanner;
public class ques02 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int len01 = scn.nextInt();
        int[] a = new int[len01];
        for (int i = 0; i < len01; i++) {
            a[i] = scn.nextInt();
        }
        int len02 = scn.nextInt();
        int max = 0;
        for (int i = 0; i < len01; i++) {
            if (max <= a[i])
                max = a[i];
        }
        boolean[] judge = new boolean[max + 1];
        for (int tmp : a) {
            judge[tmp] = true;
        }
        for (int i = 0; i < judge.length; i++) {
            if (!judge[i])
                judge[i] = false;
        }
        for (int i = 0; i < len02; i++) {
            if (judge[scn.nextInt()])
                System.out.println("yes\n");
            else System.out.println("no\n");
        }
    }
}
