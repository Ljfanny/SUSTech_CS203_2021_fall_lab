//import java.io.*;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
///*
//1
//2 2
//2 1 2
//2 2
// */
//public class qd {
//    public static void main(String[] args) throws IOException {
//        QReader qReader = new QReader();
//        QWriter out = new QWriter();
//        int n = qReader.nextInt();
//        int tot = 3 * n * n + 3 * n + 1;
//        Node[] nodes = new Node[tot + 1];
//        int line = 2 * n + 1;
//        Node[][] g = new Node[line + 1][line + 1];
//        int count = 1;
//        for (int i = 1; i <= line; i++) {
//            int nums = line - Math.abs(i - n - 1);
//            for (int i1 = 1; i1 <= nums; i1++) {
//                int w = qReader.nextInt();
//                nodes[count] = new Node(w, i, i1, count);
//                g[i][i1] = nodes[count];
//                count++;
//            }
//        }
//        Edge min = new Edge();
//        for (int i = 1; i <= n; i++) {
//            int tem1 = line - Math.abs(i - n - 1);
//            for (int i1 = 1; i1 <= tem1; i1++) {
//                if (g[i][i1 + 1] != null) {
//                    g[i][i1].child.add(g[i][i1 + 1]);
//                    g[i][i1 + 1].child.add(g[i][i1]);
//                    if (min.wei > (long) g[i][i1].val * (long) g[i][i1 + 1].val) {
//                        min.p1 = g[i][i1];
//                        min.p2 = g[i][i1 + 1];
//                        min.wei = (long) g[i][i1].val * (long) g[i][i1 + 1].val;
//                    }
//                }
//                if (g[i + 1][i1 + 1] != null) {
//                    g[i][i1].child.add(g[i + 1][i1 + 1]);
//                    g[i + 1][i1 + 1].child.add(g[i][i1]);
//                    if (min.wei > (long) g[i][i1].val * (long) g[i + 1][i1 + 1].val) {
//                        min.p1 = g[i][i1];
//                        min.p2 = g[i + 1][i1 + 1];
//                        min.wei = (long) g[i][i1].val * (long) g[i + 1][i1 + 1].val;
//                    }
//                }
//                if (g[i + 1][i1] != null) {
//                    g[i][i1].child.add(g[i + 1][i1]);
//                    g[i + 1][i1].child.add(g[i][i1]);
//                    if (min.wei > (long) g[i][i1].val * (long) g[i + 1][i1].val) {
//                        min.p1 = g[i][i1];
//                        min.p2 = g[i + 1][i1];
//                        min.wei = (long) g[i][i1].val * (long) g[i + 1][i1].val;
//                    }
//                }
//            }
//        }
//        for (int i = 2 * n + 1; i > n + 1; i--) {
//            int tem1 = line - Math.abs(i - n - 1);
//            for (int i1 = 1; i1 <= tem1; i1++) {
//                if (g[i - 1][i1 + 1] != null) {
//                    g[i][i1].child.add(g[i - 1][i1 + 1]);
//                    g[i - 1][i1 + 1].child.add(g[i][i1]);
//                    if (min.wei > (long) g[i][i1].val * (long) g[i - 1][i1 + 1].val) {
//                        min.p1 = g[i][i1];
//                        min.p2 = g[i - 1][i1 + 1];
//                        min.wei = (long) g[i][i1].val * (long) g[i - 1][i1 + 1].val;
//                    }
//                }
//                if (g[i][i1 + 1] != null) {
//                    g[i][i1].child.add(g[i][i1 + 1]);
//                    g[i][i1 + 1].child.add(g[i][i1]);
//                    if (min.wei > (long) g[i][i1].val * (long) g[i][i1 + 1].val) {
//                        min.p1 = g[i][i1];
//                        min.p2 = g[i][i1 + 1];
//                        min.wei = (long) g[i][i1].val * (long) g[i][i1 + 1].val;
//                    }
//                }
//                if (g[i - 1][i1] != null) {
//                    g[i - 1][i1].child.add(g[i][i1]);
//                    g[i][i1].child.add(g[i - 1][i1]);
//                    if (min.wei > (long) g[i][i1].val * (long) g[i - 1][i1].val) {
//                        min.p1 = g[i][i1];
//                        min.p2 = g[i - 1][i1];
//                        min.wei = (long) g[i][i1].val * (long) g[i - 1][i1].val;
//                    }
//                }
//            }
//        }
//        for (int i = 1; i <= line; i++) {
//            if (g[n + 1][i - 1] != null) {
//                g[n + 1][i].child.add(g[n + 1][i - 1]);
//                g[n + 1][i - 1].child.add(g[n + 1][i]);
//                if (min.wei > (long) g[n + 1][i].val * (long) g[n + 1][i - 1].val) {
//                    min.p1 = g[n + 1][i];
//                    min.p2 = g[n + 1][i - 1];
//                    min.wei = (long) g[n + 1][i].val * (long) g[n + 1][i - 1].val;
//                }
//            }
//            if (i+1 <= line && g[n + 1][i + 1] != null) {
//                g[n + 1][i].child.add(g[n + 1][i + 1]);
//                g[n + 1][i + 1].child.add(g[n + 1][i]);
//                if (min.wei > (long) g[n + 1][i].val * (long) g[n + 1][i + 1].val) {
//                    min.p1 = g[n + 1][i];
//                    min.p2 = g[n + 1][i + 1];
//                    min.wei = (long) g[n + 1][i].val * (long) g[n + 1][i + 1].val;
//                }
//            }
//        }
//        Heap heap = new Heap(500000);
//        heap.insert(min);
//        long sum = 0;
//        while (!heap.isEmpty()) {
//            Edge now = heap.deleteMin();
//            if (now.p1.isVisited && now.p2.isVisited)
//                continue;
//            now.p1.isVisited = true;
//            now.p2.isVisited = true;
//            sum += now.wei;
//            int size1 = now.p1.child.size();
//            int size2 = now.p2.child.size();
//            for (int i = 0; i < size1; i++) {
//                if (!now.p1.child.get(i).isVisited) {
//                    heap.insert(new Edge((long) now.p1.val * (long) now.p1.child.get(i).val, now.p1, now.p1.child.get(i)));
//                }
//            }
//            for (int i = 0; i < size2; i++) {
//                if (!now.p2.child.get(i).isVisited) {
//                    heap.insert(new Edge((long) now.p2.val * (long) now.p2.child.get(i).val, now.p2, now.p2.child.get(i)));
//                }
//            }
//        }
//        out.println(sum);
//        out.close();
//    }
//
//    public static class Node {
//        int val;
//        boolean isVisited;
//        ArrayList<Node> child;
//        int level;
//        int dir;
//        int id;
//
//        Node(int val, int level, int dir, int id) {
//            this.id = id;
//            this.val = val;
//            this.level = level;
//            this.dir = dir;
//            this.isVisited = false;
//            this.child = new ArrayList<>();
//        }
//    }
//
//    public static class Edge {
//        Node p1;
//        Node p2;
//        long wei;
//
//        Edge(long wei, Node p1, Node p2) {
//            this.p1 = p1;
//            this.p2 = p2;
//            this.wei = wei;
//        }
//
//        Edge() {
//            this.p1 = null;
//            this.p2 = null;
//            this.wei = Long.MAX_VALUE;
//        }
//    }
//
//    static class Heap {
//        Edge[] edges;
//        int index;
//
//        Heap(int n) {
//            this.edges = new Edge[n + 1];
//            this.index = 1;
//        }
//
//        public void insert(Edge node) {
//            this.edges[index] = node;
//            int d = index;
//            while (d != 1 && edges[d / 2].wei > edges[d].wei) {
//                Edge tem = edges[d / 2];
//                edges[d / 2] = edges[d];
//                edges[d] = tem;
//                d /= 2;
//            }
//            index++;
//        }
//
//        public Edge deleteMin() {
//            Edge res = edges[1];
//            edges[1] = edges[index - 1];
//            index--;
//            int d = 1;
//            while (d < index && ((2 * d < index && edges[2 * d].wei < edges[d].wei)
//                    || (2 * d + 1 < index && edges[2 * d + 1].wei < edges[d].wei))) {
//                Edge t;
//                if (edges[2 * d].wei < edges[2 * d + 1].wei) {
//                    t = edges[2 * d];
//                    edges[2 * d] = edges[d];
//                    edges[d] = t;
//                    d *= 2;
//                } else {
//                    t = edges[2 * d + 1];
//                    edges[2 * d + 1] = edges[d];
//                    edges[d] = t;
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
//    private BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("d_test_2")));
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