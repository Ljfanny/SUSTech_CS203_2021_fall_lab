//import java.io.*;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class ques03 {
//    static boolean flag = false;
//
//    public static void main(String[] args) throws IOException {
//        QReader scanner = new QReader();
//        QWriter out = new QWriter();
//        int n = scanner.nextInt();
//        int ros = scanner.nextInt();
//        Node[] nos = new Node[n + 1];
//        for (int i = 1; i <= n; i++) {
//            nos[i] = new Node(i);
//        }
//        for (int i = 0; i < ros; i++) {
//            int x = scanner.nextInt();
//            int y = scanner.nextInt();
//            nos[x].nodes.add(nos[y]);
//            nos[y].nodes.add(nos[x]);
//        }
//        Queue<Node> queue = new LinkedList<Node>();
//        dfs(nos[1], null);
//        for (int i = 1; i <= n; i++) {
//            if (!nos[i].isVisited)
//                dfs(nos[i], null);
//        }
//        if (flag)
//            out.println("Bad");
//        else out.println("Good");
//        out.close();
//    }
//
//    public static void dfs(Node node, Node pre) {
//        node.isVisited = true;
//        for (int i = 0; i < node.nodes.size(); i++) {
//            Node next = node.nodes.get(i);
//            if (!next.isVisited)
//                dfs(next, node);
//            else if (next != pre)
//                flag = true;
//        }
//    }
//
//    static class Node {
//        private ArrayList<Node> nodes;
//        private boolean isVisited;
//        private int val;
//
//        Node(int val) {
//            this.val = val;
//            this.isVisited = false;
//            this.nodes = new ArrayList<Node>();
//        }
//    }
//}
//
//
