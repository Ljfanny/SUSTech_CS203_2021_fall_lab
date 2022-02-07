import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class qb {
    public static void main(String[] args) throws IOException {
        QReader qReader = new QReader();
        QWriter out = new QWriter();
        int n = qReader.nextInt();
        int m = qReader.nextInt();
        if (m < n) {
            out.println(-1);
            out.close();
            return;
        }
        int[][] mp = new int[m][2];
        int[][] test = new int[2][n + 1];
        for (int i = 0; i < m; i++) {
            mp[i][0] = qReader.nextInt();
            mp[i][1] = qReader.nextInt();
            test[0][mp[i][0]]++;
            test[1][mp[i][1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (test[0][i] == 0 || test[1][i] == 0){
                out.println(-1);
                out.close();
                return;
            }
        }
        int left = 0;
        int right = m - 1;
        Stack<Node> s2 = new Stack<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> L = new Stack<>();
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }
        boolean can = false;
        boolean isFir = true;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            L.empty();
            if (!can && isFir) {
                isFir = false;
                for (int i = 0; i <= mid; i++) {
                    nodes[mp[i][0]].out.add(nodes[mp[i][1]]);
                    nodes[mp[i][1]].in.add(nodes[mp[i][0]]);
                }
            } else if (!can) {
                for (int i = 1; i <= n; i++) {
                    nodes[i].isVisited_negative = false;
                    nodes[i].isVisited_positive = false;
                }
                for (int i = right + 1; i > mid; i--) {
                    int siz1 = nodes[mp[i][0]].out.size();
                    int siz2 = nodes[mp[i][1]].in.size();
                    nodes[mp[i][0]].out.remove(siz1 - 1);
                    nodes[mp[i][1]].in.remove(siz2 - 1);
                }
            } else {
                for (int i = 1; i <= n; i++) {
                    nodes[i].isVisited_negative = false;
                    nodes[i].isVisited_positive = false;
                }
                for (int i = left; i <= mid; i++) {
                    nodes[mp[i][0]].out.add(nodes[mp[i][1]]);
                    nodes[mp[i][1]].in.add(nodes[mp[i][0]]);
                }
            }
            s2.push(nodes[1]);
            nodes[1].isVisited_negative = true;
            while (!s2.isEmpty()) {
                Node now = s2.peek();
                int size = now.in.size();
                int bef = s2.size();
                for (int i = 0; i < size; i++) {
                    if (!now.in.get(i).isVisited_negative) {
                        s2.add(now.in.get(i));
                        now.in.get(i).isVisited_negative = true;
                        break;
                    }
                }
                if (bef == s2.size()) {
                    s2.pop();
                    L.add(now);
                }
                if (s2.isEmpty()) {
                    for (int i = 1; i <= n; i++) {
                        if (!nodes[i].isVisited_negative) {
                            s2.add(nodes[i]);
                            nodes[i].isVisited_negative = true;
                            break;
                        }
                    }
                }
            }
            s1.add(nodes[L.peek().id]);
            nodes[L.peek().id].isVisited_positive = true;
            int total = 1;
            while (!s1.isEmpty()) {
                Node now = s1.peek();
                int size = now.out.size();
                int bef = s1.size();
                for (int i = 0; i < size; i++) {
                    if (!now.out.get(i).isVisited_positive) {
                        s1.add(now.out.get(i));
                        now.out.get(i).isVisited_positive = true;
                        total++;
                        break;
                    }
                }
                if (bef == s1.size()) {
                    s1.pop();
                }
            }
            if (total == n) {
                right = mid - 1;
                can = false;
            } else if (total < n) {
                left = mid + 1;
                can = true;
            }
        }
        if (left > m - 1) out.println(-1);
        else out.println(left + 1);
        out.close();
    }
    static class Node {
        int id;
        boolean isVisited_positive;
        boolean isVisited_negative;
        ArrayList<Node> in;
        int ins;
        ArrayList<Node> out;
        int outs;
        Node(int id) {
            this.ins = 0;
            this.outs = 0;
            this.in = new ArrayList<>();
            this.out = new ArrayList<>();
            this.isVisited_positive = false;
            this.isVisited_negative = false;
            this.id = id;
        }
    }
}

class QWriter implements Closeable {
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(Object object) {
        try {
            writer.write(object.toString());
        } catch (IOException e) {
            return;
        }
    }

    public void println(Object object) {
        try {
            writer.write(object.toString());
            writer.write("\n");
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            return;
        }
    }
}

class QReader {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = new StringTokenizer("");

    QReader() throws FileNotFoundException {
    }

    private String innerNextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return false;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
        return true;
    }

    public String nextLine() {
        tokenizer = new StringTokenizer("");
        return innerNextLine();
    }

    public String next() {
        hasNext();
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}