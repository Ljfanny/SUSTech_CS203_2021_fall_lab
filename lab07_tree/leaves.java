import java.util.Scanner;

public class leaves {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodes = scanner.nextInt();
        int[] arr = new int[nodes + 1];
        for (int i = 0; i < nodes - 1; i++) {
            arr[scanner.nextInt()]++;
            arr[scanner.nextInt()]++;
        }
        for (int i = 2; i <= nodes; i++) {
            if (arr[i] == 1)
                System.out.print(i + " ");
        }
    }
}
