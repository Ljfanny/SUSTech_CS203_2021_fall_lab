import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ques06 {
    public static void main(String[] args) throws IOException{
        QReader qReader = new QReader();
        QWriter out = new QWriter();
        int cases = qReader.nextInt();
        for (int i = 0; i < cases; i++) {
            int n = qReader.nextInt();
            int m = qReader.nextInt();
            long[] a = new long[n + 1];
            long[] b = new long[n + 1];
            long[] f = new long[n + 1];
            Node[] nodes = new Node[n + 1];
            for (int i1 = 1; i1 <= n; i1++) {
                a[i1] = qReader.nextInt();
                b[i1] = qReader.nextInt();
                nodes[i1] = new Node(i1);
                f[i1] = 0;
            }
            for (int i1 = 0; i1 < m; i1++) {
                int u = qReader.nextInt();
                int v = qReader.nextInt();
                nodes[u].child.add(nodes[v]);
                nodes[v].de++;
            }
            Queue<Node> queue = new LinkedList<Node>();
            for (int i1 = 1; i1 <= n; i1++) {
                if (nodes[i1].de == 0)
                    queue.add(nodes[i1]);
            }
            while (!queue.isEmpty()){
                Node now = queue.poll();
                int size = now.child.size();
                for (int i1 = 0; i1 < size; i1++) {
                    Node ch = now.child.get(i1);
                    ch.de--;
                    f[ch.val] = (f[ch.val] % 1000000007 + f[now.val] % 1000000007 + a[now.val] % 1000000007) % 1000000007;
                    if (ch.de == 0)
                        queue.add(ch);
                }
            }
            long sum = 0;
            for (int i1 = 1; i1 <= n; i1++) {
                f[i1] = ((f[i1] % 1000000007) * (b[i1] % 1000000007)) % 1000000007;
                sum = (sum % 1000000007 + f[i1] % 1000000007) % 1000000007;
            }
            out.println(sum);
        }
        out.close();
    }
    public static class Node{
        int val;
        int de;
        ArrayList<Node> child;
        Node(int val){
            this.val = val;
            this.de = 0;
            this.child = new ArrayList<>();
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