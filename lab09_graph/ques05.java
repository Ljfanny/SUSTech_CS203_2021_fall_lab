//import java.io.*;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
///*
//4 5
//1 2 1
//2 4 1
//2 3 2
//3 4 1
//1 3 1
// */
//public class ques05 {
//    public static void main(String[] args) throws IOException {
//        QReader scanner = new QReader();
//        QWriter out = new QWriter();
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        Node[] cities = new Node[n + m];
//
//        for (int i = 0; i < cities.length; i++) {
//            cities[i] = new Node(i + 1);
//        }
//
//        int cnt = n + 1;
//        for (int i = 0; i < m; i++) {
//            int fi = scanner.nextInt();
//            int la = scanner.nextInt();
//            int cost = scanner.nextInt();
//            if (cost == 1) {
//                cities[fi - 1].nodes.add(cities[la - 1]);
//            } else {
//                cities[fi - 1].nodes.add(cities[cnt - 1]);
//                cities[cnt - 1].nodes.add(cities[la - 1]);
//                cnt++;
//            }
//        }
//        Queue<Node> queue = new LinkedList<Node>();
//        cities[0].isVisited = true;
//        queue.add(cities[0]);
//
//        while (!queue.isEmpty()) {
//            Node pek = queue.poll();
//            assert pek != null;
//            int size = pek.nodes.size();
//            if (pek.val == n) {
//                queue.clear();
//                break;
//            }
//            for (int i = 0; i < size; i++) {
//                if (!pek.nodes.get(i).isVisited) {
//                    pek.nodes.get(i).isVisited = true;
//                    pek.nodes.get(i).time = pek.time + 1;
//                    queue.add(pek.nodes.get(i));
//                }
//            }
//        }
//
//        if (!cities[n - 1].isVisited)
//            out.println(-1);
//        else
//            out.println(cities[n - 1].time);
//        out.close();
//    }
//
//    static class TreeNode {
//        private int val;
//        private TreeNode fa;
//        private ArrayList<TreeNode> child;
//
//        TreeNode(int val) {
//            this.val = val;
//            this.child = new ArrayList<TreeNode>();
//            this.fa = null;
//        }
//
//    }
//
//    static class Node {
//        private ArrayList<Node> nodes;
//        private boolean isVisited;
//        private int val;
//        private int time;
//
//        Node(int val) {
//            this.time = 0;
//            this.val = val;
//            this.isVisited = false;
//            this.nodes = new ArrayList<Node>();
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
