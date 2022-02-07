//import java.util.Scanner;
//
//public class a {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        long[] nums = new long[n + 1];
//        long[] res = new long[n + 1];
//        long[] tree = new long[n + 1];
//        for (int i = 1; i <= n; i++)
//            nums[i] = scanner.nextLong();
//        for (int i = 1; i <= n; i++) {
//            int count = 0;
//            tree[i] = nums[i];
//            if (i == 1) {
//                res[i] = 0;
//            } else {
//                int d = i;
//                while (d != 1 && tree[d / 2] < tree[d]) {
//                    count++;
//                    long tem = tree[d / 2];
//                    tree[d / 2] = tree[d];
//                    tree[d] = tem;
//                    d /= 2;
//                }
//                res[i] = count;
//            }
//        }
//        for (int i = 1; i <= n; i++) {
//            System.out.print(res[i] + " ");
//        }
//
//    }
//}
