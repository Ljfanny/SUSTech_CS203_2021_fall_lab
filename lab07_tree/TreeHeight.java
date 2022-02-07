import java.util.Scanner;
public class TreeHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int i = 0; i < tests; i++)
            System.out.println((int) Math.ceil(Math.log(scanner.nextLong() + 1) / Math.log(2)));
    }
}
