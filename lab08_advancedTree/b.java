//import java.util.Scanner;
//
//public class b {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        long[] tree = new long[n + 1];
//        long[] res = new long[n + 1];
//        for (int i = 1; i <= n; i++)
//            tree[i] = scanner.nextLong();
//
//        int countMax = 0;
//        int countMin = 0;
//        for (int i = 2; i <= n; i++) {
//            if (tree[i / 2] < tree[i])
//                countMin++;
//            else countMax++;
//        }
//        if (countMin == n - 1) {
//            System.out.println("Min");
//        }else if (countMax == n - 1)
//            System.out.println("Max");
//        else System.out.println("Neither");
//    }
//}
