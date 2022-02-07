//import java.io.*;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
///*
//3 3
//1 2 2
//2 3 1
//1 3 1
// */
//public class qa {
//    public static void main(String[] args) throws IOException {
//        QReader qReader = new QReader();
//        QWriter out = new QWriter();
//        int n = qReader.nextInt();
//        int m = qReader.nextInt();
//        Node[] nodes = new Node[n + 1];
//        Heap heap = new Heap(n);
//        for (int i = 1; i <= n; i++) {
//            nodes[i] = new Node(i, n + 1);
//        }
//        for (int i = 0; i < m; i++) {
//            int u = qReader.nextInt();
//            int v = qReader.nextInt();
//            long w = qReader.nextInt();
//            nodes[u].child.add(nodes[v]);
//            nodes[u].toChWei.add(w);
//        }
//        nodes[1].noVal = 0;
//        heap.insert(nodes[1]);
//        while (!heap.isEmpty()) {
//            Node now;
//            now = heap.deleteMin();
//            if(now.isVisited)
//                continue;
//            now.isVisited = true;
//            int size = now.child.size();
//            for (int i = 0; i < size; i++) {
//                Node ch = now.child.get(i);
//                if (!ch.isVisited) {
//                    if (ch.noVal > now.toChWei.get(i) + now.noVal)
//                        ch.noVal = now.toChWei.get(i) + now.noVal;
//                    heap.insert(ch);
//                }
//            }
//        }
//        if (nodes[n].noVal == Long.MAX_VALUE)
//            out.println(-1);
//        else out.println(nodes[n].noVal);
//        out.close();
//    }
//
//    public static class Node {
//        int val;
//        long noVal;
//        ArrayList<Long> toChWei;
//        boolean isVisited;
//        ArrayList<Node> child;
//
//        Node(int val,int n) {
//            this.val = val;
//            this.noVal = Long.MAX_VALUE;
//            this.toChWei = new ArrayList<>();
//            this.isVisited = false;
//            this.child = new ArrayList<>();
//        }
//    }
//
//    static class Heap {
//        Node[] nodes;
//        int index;
//
//        Heap(int n) {
//            this.nodes = new Node[n + 1];
//            this.index = 1;
//        }
//
//        public void insert(Node node) {
//            this.nodes[index] = node;
//            int d = index;
//            while (d != 1 && nodes[d / 2].noVal > nodes[d].noVal) {
//                Node tem = nodes[d / 2];
//                nodes[d / 2] = nodes[d];
//                nodes[d] = tem;
//                d /= 2;
//            }
//            index++;
//        }
//
//        public Node deleteMin() {
//            Node res = nodes[1];
//            nodes[1] = nodes[index - 1];
//            index--;
//            int d = 1;
//            while (d < index && ((2 * d < index && nodes[2 * d].noVal < nodes[d].noVal)
//                    || (2 * d + 1 < index && nodes[2 * d + 1].noVal < nodes[d].noVal))) {
//                Node t;
//                if (nodes[2 * d].noVal < nodes[2 * d + 1].noVal) {
//                    t = nodes[2 * d];
//                    nodes[2 * d] = nodes[d];
//                    nodes[d] = t;
//                    d *= 2;
//                } else {
//                    t = nodes[2 * d + 1];
//                    nodes[2 * d + 1] = nodes[d];
//                    nodes[d] = t;
//                    d = 2 * d + 1;
//                }
//
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