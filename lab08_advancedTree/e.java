//import java.util.Scanner;
//
//public class e {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        long[] res = new long[n];
//        Minheap minheap = new Minheap(n);
//        Maxheap maxheap = new Maxheap(n);
//        for (int i = 0; i < n; i++) {
//            long tem = scanner.nextLong();
//            if (i <= 1){
//                if (minheap.index == 1 && maxheap.index == 1) {
//                    maxheap.insert(tem);
//                } else if (minheap.index == 1 && maxheap.index == 2) {
//                    minheap.insert(tem);
//                    if (maxheap.getTop() > minheap.getTop()) {
//                        long t = maxheap.deleteMin();
//                        long p = minheap.deleteMin();
//                        minheap.insert(t);
//                        maxheap.insert(p);
//                    }
//                }
//            }
//            if (i > 1) {
//                if (maxheap.index == minheap.index) {
//                    maxheap.insert(tem);
//                    minheap.insert(maxheap.deleteMin());
//                } else if (minheap.index > maxheap.index) {
//                    minheap.insert(tem);
//                    maxheap.insert(minheap.deleteMin());
//                }
//            }
//
//            if (minheap.index > maxheap.index)
//                res[i] = minheap.getTop();
//            else res[i] = maxheap.getTop();
//        }
//        for (long e : res) {
//            System.out.print(e + " ");
//        }
//    }
//
//    static class Minheap {
//        long[] tree;
//        int index;
//
//        Minheap(int n) {
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
//
//        public long getTop() {
//            return tree[1];
//        }
//    }
//
//    static class Maxheap {
//        long[] tree;
//        int index;
//
//        Maxheap(int n) {
//            this.tree = new long[n + 1];
//            this.index = 1;
//        }
//
//        public void insert(long a) {
//            this.tree[index] = a;
//            int d = index;
//            while (d != 1 && tree[d / 2] < tree[d]) {
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
//            while (d < index && ((2 * d < index && tree[2 * d] > tree[d]) || (2 * d + 1 < index &&
//                    tree[2 * d + 1] > tree[d]))) {
//                long t;
//                if (tree[2 * d] > tree[2 * d + 1]) {
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
//
//        public long getTop() {
//            return tree[1];
//        }
//    }
//}
