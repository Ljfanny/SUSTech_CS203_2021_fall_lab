import java.util.Scanner;

public class treeNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int i = 0; i < tests; i++) {
            String pre = scanner.next();
            String post = scanner.next();
            char[] fir = pre.toCharArray();
            char[] last = post.toCharArray();
            int p = pow(fir, last);
            System.out.println((int)Math.pow(2, p));
        }
    }

    public static int pow(char[] a, char[] b) {
        int count = 0;
        for (int j = 0; j < a.length; j++) {
            for (int k = 1; k < b.length; k++) {
                if (a[j] == b[k]){
                    if (j + 1 < a.length && a[j + 1] == b[k - 1])
                        count++;
                }
            }
        }
        return count;
    }
}
