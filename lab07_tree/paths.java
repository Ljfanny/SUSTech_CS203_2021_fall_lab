import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class paths {
    public static void main(String[] args) throws FileNotFoundException {
        QReader scanner = new QReader();
        QWriter out = new QWriter();
        int nodes = scanner.nextInt();
        long target = scanner.nextLong();
        Tree[] nos = new Tree[nodes + 1];

        for (int i = 1; i <= nodes; i++) {
            nos[i] = new Tree();
        }
        for (int i = 0; i < nodes - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            nos[u].child.add(nos[v]);
            nos[v].child.add(nos[u]);
            nos[v].distance.add(w);
            nos[u].distance.add(w);
        }
        Tree[] queue = new Tree[nodes + 1];
        int front = 0;
        int rear = 0;
        int count = 0;
        queue[rear++] = nos[1];
        nos[1].isVisited = true;
        while (rear > front) {
            Tree fa = queue[front++];
            if (fa.child.size() == 1 && fa.child.get(0).isVisited)
                if (fa.weight == target)
                    count++;
            for (int i = 0; i < fa.child.size(); i++) {
                if (!fa.child.get(i).isVisited) {
                    queue[rear++] = fa.child.get(i);
                    fa.child.get(i).isVisited = true;
                    fa.child.get(i).weight = fa.weight + fa.distance.get(i);
                }
            }
        }
        out.println(count);
        out.close();
    }

    static class Tree {
        public long weight;
        public ArrayList<Tree> child;
        public ArrayList<Integer> distance;
        public boolean isVisited;

        Tree() {
            this.weight = 0;
            this.child = new ArrayList<Tree>();
            this.distance = new ArrayList<Integer>();
            this.isVisited = false;
        }
    }
    static class QWriter implements Closeable {
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

    static class QReader {
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

}
