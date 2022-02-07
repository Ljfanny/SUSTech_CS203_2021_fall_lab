import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DateriVisit {
    static StringBuilder stringBuilder = new StringBuilder();
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static int leaves = 0;
    static int steps = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Tree[] trees = new Tree[num + 1];
        Node[] nodes = new Node[num + 1];

        for (int i = 1; i <= num; i++) {
            trees[i] = new Tree(i);
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < num - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            trees[x].child.add(trees[y]);
            trees[y].child.add(trees[x]);
        }
        Tree[] queue = new Tree[num];
        int front = 0;
        int rear = 0;
        queue[rear++] = trees[1];
        trees[1].isVisited = true;
        leaves = 0;
        while (rear > front) {
            Tree father = queue[front++];
            nodes[father.index].depth = father.depth;
            if (father.child.size() == 1 && father.child.get(0).isVisited)
                leaves++;
            for (int k = 0; k < father.child.size(); k++) {
                if (!father.child.get(k).isVisited) {
                    queue[rear++] = father.child.get(k);
                    nodes[father.index].child.add(nodes[father.child.get(k).index]);
                    nodes[father.child.get(k).index].father = nodes[father.index];
                    father.child.get(k).isVisited = true;
                    father.child.get(k).depth = father.depth + 1;
                }
            }
        }
        for (int i = 0; i < leaves; i++) {
            int z = scanner.nextInt();
            arrayList.add(z);
        }
        steps = nodes[arrayList.get(0)].depth - 1;
        Stack<Integer> s = new Stack<>();
        Node fir = nodes[arrayList.get(0)];
        while (fir.father != null) {
            s.push(fir.index);
            fir = fir.father;
        }
        stringBuilder.append(1).append(" ");
        while (!s.isEmpty()) {
            stringBuilder.append(s.pop()).append(" ");
        }
        if (leaves == 1) {
            Node now = nodes[arrayList.get(0)];
            while (now.father != null) {
                now = now.father;
                stringBuilder.append(now.index).append(" ");
                steps++;
            }
        } else {
            for (int i = 1; i < arrayList.size(); i++) {
                fsa(nodes[arrayList.get(i - 1)], nodes[arrayList.get(i)]);
            }
            Node p = nodes[arrayList.get(arrayList.size() - 1)];
            while (p.father != null) {
                p = p.father;
                stringBuilder.append(p.index).append(" ");
                steps++;
            }
        }
        if (steps == 2 * num - 2)
            System.out.println(stringBuilder.toString());
        else System.out.println(-1);
    }

    public static void fsa(Node a, Node b) {
        Node t = a;
        Node m = b;
        Stack<Integer> stack = new Stack<>();
        while (t.depth > m.depth) {
            t = t.father;
            stringBuilder.append(t.index).append(" ");
            steps++;
        }
        while (t.depth < m.depth) {
            stack.push(m.index);
            m = m.father;
        }
        while (t.father != m.father) {
            stack.push(m.index);
            m = m.father;
            t = t.father;
            stringBuilder.append(t.index).append(" ");
            steps++;
        }
        stringBuilder.append(t.father.index).append(" ");
        steps++;
        stringBuilder.append(m.index).append(" ");
        steps++;
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop()).append(" ");
            steps++;
        }
    }

    static class Node {
        public int depth;
        public int index;
        public ArrayList<Node> child;
        public boolean isVisited;
        public Node father;

        Node(int a) {
            this.depth = 1;
            this.index = a;
            this.father = null;
            this.child = new ArrayList<Node>();
            this.isVisited = false;
        }
    }

    static class Tree {
        public int depth;
        public int index;
        public ArrayList<Tree> child;
        public boolean isVisited;

        Tree(int a) {
            this.index = a;
            this.depth = 1;
            this.child = new ArrayList<Tree>();
            this.isVisited = false;
        }
    }
}
