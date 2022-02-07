//import java.util.Scanner;
//
//public class d {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        Heap heap = new Heap(n);
//        for (int i = 0; i < n; i++) {
//            heap.insert(scanner.nextInt());
//        }
//        long res = 0;
//        for (int i = 0; i < n - 1; i++) {
//            long a = heap.deleteMin();
//            long b = heap.deleteMin();
//            res += a + b;
//            heap.insert(a + b);
//        }
//        System.out.println(res);
//    }
//
//    static class Heap {
//        long[] tree;
//        int index;
//
//        Heap(int n) {
//            this.tree = new long[n + 1];
//            this.index = 1;
//        }
//
//        public void insert(long a) {
//            this.tree[index] = a;
//            int d = index;
//            while (d != 1 && tree[d / 2] > tree[d]) {
//                long tem = tree[d / 2];
//                tree[d / 2] = tree[d];
//                tree[d] = tem;
//                d /= 2;
//            }
//            index++;
//        }
//
//        public long deleteMin() {
//            long res = tree[1];
//            tree[1] = tree[index - 1];
//            index--;
//            int d = 1;
//            while (d < index && ((2 * d < index && tree[2 * d] < tree[d]) || (2 * d + 1 < index &&
//                    tree[2 * d + 1] < tree[d]))) {
//                long t;
//                if (tree[2 * d] < tree[2 * d + 1]) {
//                    t = tree[2 * d];
//                    tree[2 * d] = tree[d];
//                    tree[d] = t;
//                    d *= 2;
//                } else {
//                    t = tree[2 * d + 1];
//                    tree[2 * d + 1] = tree[d];
//                    tree[d] = t;
//                    d = 2 * d + 1;
//                }
//
//            }
//            return res;
//        }
//    }
//}
