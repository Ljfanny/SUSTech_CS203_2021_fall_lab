//import java.io.*;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
////限制传送门数, 出堆才是最小距离 n[到达的点][经过几个传送门 p] val = 消耗; p <= k;
///*
//5 6 3 1
//1 3 4
//1 2 2
//3 5 6
//2 4 3
//3 4 1
//4 5 2
//2 3
//1 4
//1 2
//1 5
// */
//public class qe {
//    public static long[][] dp;
//
//    public static void main(String[] args) throws IOException {
//        QReader scanner = new QReader();
//        QWriter out = new QWriter();
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int p = scanner.nextInt();
//        int k = scanner.nextInt();
//        dp = new long[n + 1][k + 1];
//        Node[] cities = new Node[n + 1];
//        for (int i = 1; i <= n; i++) {
//            cities[i] = new Node(i);
//            for (int i1 = 0; i1 <= k; i1++) {
//                dp[i][i1] = Long.MAX_VALUE;
//            }
//        }
//        int u, v;
//        for (int i = 0; i < m; i++) {
//            u = scanner.nextInt();
//            v = scanner.nextInt();
//            int w = scanner.nextInt();
//            cities[u].child.add(cities[v]);
//            cities[u].toChWei.add((long) w);
//        }
//        for (int i = 0; i < p; i++) {
//            u = scanner.nextInt();
//            v = scanner.nextInt();
//            cities[u].child.add(cities[v]);
//            cities[u].toChWei.add(0L);
//        }
//        int begin = scanner.nextInt();
//        int end = scanner.nextInt();
//        dp[begin][0] = 0;
//        Heap heap = new Heap(550000);
//        heap.insert(new Temp(dp[begin][0], begin, 0));
//        while (!heap.isEmpty()) {
//            Temp now = heap.deleteMin();
//            int size = cities[now.cit].child.size();
//            for (int i = 0; i < size; i++) {
//                Node ch = cities[now.cit].child.get(i);
//                if (cities[now.cit].toChWei.get(i) == 0) {
//                    if (now.k + 1 <= k) {
//                        if (dp[ch.val][now.k + 1] > now.val) {
//                            dp[ch.val][now.k + 1] = now.val;
//                            heap.insert(new Temp(now.val, ch.val, now.k + 1));
//                        }
//                    }
//                } else {
//                    if (dp[ch.val][now.k] > now.val + cities[now.cit].toChWei.get(i)) {
//                        dp[ch.val][now.k] = now.val + cities[now.cit].toChWei.get(i);
//                        heap.insert(new Temp(dp[ch.val][now.k], ch.val, now.k));
//                    }
//                }
//            }
//        }
//        long sum = Long.MAX_VALUE;
//        for (int i = 0; i <= k; i++) {
//            sum = Math.min(sum, dp[end][i]);
//        }
//        out.println(sum);
//        out.close();
//    }
//
//    public static class Node {
//        int val;
//        ArrayList<Long> toChWei;
//        boolean isVisited;
//        ArrayList<Node> child;
//
//        Node(int val) {
//            this.val = val;
//            this.toChWei = new ArrayList<>();
//            this.isVisited = false;
//            this.child = new ArrayList<>();
//        }
//    }
//
//    static class Temp {
//        long val;
//        int cit;
//        int k;
//
//        Temp(long val, int cit, int k) {
//            this.cit = cit;
//            this.val = val;
//            this.k = k;
//        }
//    }
//
//    static class Heap {
//        Temp[] temps;
//        int index;
//
//        Heap(int n) {
//            this.temps = new Temp[n + 1];
//            this.index = 1;
//        }
//
//        public void insert(Temp temp) {
//            this.temps[index] = temp;
//            int d = index;
//            while (d != 1 && temps[d / 2].val > temps[d].val) {
//                Temp tem = temps[d / 2];
//                temps[d / 2] = temps[d];
//                temps[d] = tem;
//                d /= 2;
//            }
//            index++;
//        }
//
//        public Temp deleteMin() {
//            Temp res = temps[1];
//            temps[1] = temps[index - 1];
//            index--;
//            int d = 1;
//            while (d < index && ((2 * d < index && temps[2 * d].val < temps[d].val)
//                    || (2 * d + 1 < index && temps[2 * d + 1].val < temps[d].val))) {
//                Temp t;
//                if (temps[2 * d].val < temps[2 * d + 1].val) {
//                    t = temps[2 * d];
//                    temps[2 * d] = temps[d];
//                    temps[d] = t;
//                    d *= 2;
//                } else {
//                    t = temps[2 * d + 1];
//                    temps[2 * d + 1] = temps[d];
//                    temps[d] = t;
//                    d = 2 * d + 1;
//                }
//            }
//            return res;
//        }
//
//        public boolean isEmpty() {
//            return index == 1;
//        }
//    }
//}
//
//
//class QWriter implements Closeable {
//    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//    public void print(Object object) {
//        try {
//            writer.write(object.toString());
//        } catch (IOException e) {
//            return;
//        }
//    }
//
//    public void println(Object object) {
//        try {
//            writer.write(object.toString());
//            writer.write("\n");
//        } catch (IOException e) {
//            return;
//        }
//    }
//
//    @Override
//    public void close() {
//        try {
//            writer.close();
//        } catch (IOException e) {
//            return;
//        }
//    }
//}
//
//class QReader {
//    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    private StringTokenizer tokenizer = new StringTokenizer("");
//
//    QReader() throws FileNotFoundException {
//    }
//
//    private String innerNextLine() {
//        try {
//            return reader.readLine();
//        } catch (IOException e) {
//            return null;
//        }
//    }
//
//    public boolean hasNext() {
//        while (!tokenizer.hasMoreTokens()) {
//            String nextLine = innerNextLine();
//            if (nextLine == null) {
//                return false;
//            }
//            tokenizer = new StringTokenizer(nextLine);
//        }
//        return true;
//    }
//
//    public String nextLine() {
//        tokenizer = new StringTokenizer("");
//        return innerNextLine();
//    }
//
//    public String next() {
//        hasNext();
//        return tokenizer.nextToken();
//    }
//
//    public int nextInt() {
//        return Integer.parseInt(next());
//    }
//
//    public long nextLong() {
//        return Long.parseLong(next());
//    }
//}