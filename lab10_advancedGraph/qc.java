//import java.io.*;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
///*
//4 4
//1 2 1
//2 3 1
//3 4 2
//1 4 8
// */
//
//public class qc {
//    public static void main(String[] args) throws IOException {
//        QReader qReader = new QReader();
//        QWriter out = new QWriter();
//        int n = qReader.nextInt();
//        int m = qReader.nextInt();
//        Node[] cit = new Node[n + 1];
//        Heap heap = new Heap(m * 3);
//        Edge min = new Edge();
//        long sum = 0;
//        for (int i = 1; i <= n; i++) {
//            cit[i] = new Node(i);
//        }
//        for (int i = 0; i < m; i++) {
//            int u = qReader.nextInt();
//            int v = qReader.nextInt();
//            long w = qReader.nextLong();
//            cit[u].child.add(cit[v]);
//            cit[v].child.add(cit[u]);
//            cit[u].childWeight.add(w);
//            cit[v].childWeight.add(w);
//            if (i == 0) {
//                min.p1 = cit[u];
//                min.p2 = cit[v];
//                min.wei = w;
//            }else {
//                if (w < min.wei) {
//                    min.p1 = cit[u];
//                    min.p2 = cit[v];
//                    min.wei = w;
//                }
//            }
//        }
//        heap.insert(min);
//        while (!heap.isEmpty()){
//            Edge now = heap.deleteMin();
//            if (now.p1.isVisited && now.p2.isVisited)
//                continue;
//            now.p1.isVisited = true;
//            now.p2.isVisited = true;
//            sum += now.wei;
//            int size1 = now.p1.child.size();
//            int size2 = now.p2.child.size();
//            for (int i = 0; i < size1; i++) {
//                if (!now.p1.child.get(i).isVisited){
//                    heap.insert(new Edge(now.p1.childWeight.get(i),now.p1, now.p1.child.get(i)));
//                }
//            }
//            for (int i = 0; i < size2; i++) {
//                if (!now.p2.child.get(i).isVisited){
//                    heap.insert(new Edge(now.p2.childWeight.get(i),now.p2, now.p2.child.get(i)));
//                }
//            }
//        }
//        out.println(sum);
//        out.close();
//    }
//
//    public static class Node {
//        int val;
//        ArrayList<Long> childWeight;
//        boolean isVisited;
//        ArrayList<Node> child;
//
//        Node(int val) {
//            this.val = val;
//            this.childWeight = new ArrayList<>();
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
//        Edge(){
//            this.p1 = null;
//            this.p2 = null;
//            this.wei = -1;
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