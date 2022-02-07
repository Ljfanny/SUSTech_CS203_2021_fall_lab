//import java.io.*;
//import java.util.*;
//
///*
//3
//4 4
//67 75 63 10
//29 29 92 14
//21 68 71 56
//8 67 91 25
//2 3
//87 70 85
//10 3 17
//3 3
//1 1 1
//1 99 1
//1 1 1
// */
//public class ques04 {
//    public static long maxRes = -10000000;
//    public static long maxNow = 0;
////    public static HashSet<Integer> set;
//
//    public static void main(String[] args) throws IOException {
//        QReader scanner = new QReader();
//        QWriter out = new QWriter();
//        int cases = scanner.nextInt();
//        for (int i = 0; i < cases; i++) {
//            maxRes = -10000000;
////            set = new HashSet<>();
//            int r = scanner.nextInt();
//            int c = scanner.nextInt();
//            boolean[][] isVisited = new boolean[r][c];
//            long[][] map = new long[r][c];
//            for (int i1 = 0; i1 < r; i1++) {
//                for (int i2 = 0; i2 < c; i2++) {
//                    map[i1][i2] = scanner.nextLong();
//                }
//            }
////            for (int i1 = 0; i1 < r; i1++) {
////                for (int i2 = 0; i2 < c; i2++) {
////                    maxNow = 0;
////                    set.add(c * i1 + i2);
////                    System.out.println(i1);
//            dfs(isVisited, map, 0, 0);
////                    System.out.println(i1);
////                }
////            }
//            out.println(maxRes);
//        }
//        out.close();
//    }
//
//    public static void dfs(boolean[][] isVisited, long[][] map, int i1, int i2) {
////        isVisited[i1][i2] = true;
////        boolean[] cha = new boolean[8];
//        if (i1 == map.length || i2 == map[0].length)
//            return;
//        if (!isVisited[i1][i2]) {
//            boolean canDFS = true;
//            if (i1 - 1 > -1 && i2 - 1 > -1 && isVisited[i1 - 1][i2 - 1])
//                canDFS = false;
//            if (i1 - 1 > -1 && isVisited[i1 - 1][i2])
//                canDFS = false;
//            if (i1 - 1 > -1 && i2 + 1 < map[0].length && isVisited[i1 - 1][i2 + 1])
//                canDFS = false;
//            if (i2 - 1 > -1 && isVisited[i1][i2 - 1])
//                canDFS = false;
//            if (i2 + 1 < map[0].length && isVisited[i1][i2 + 1])
//                canDFS = false;
//            if (i1 + 1 < map.length && i2 - 1 > -1 && isVisited[i1 + 1][i2 - 1])
//                canDFS = false;
//            if (i1 + 1 < map.length && isVisited[i1 + 1][i2])
//                canDFS = false;
//            if (i1 + 1 < map.length && i2 + 1 < map[0].length && isVisited[i1 + 1][i2 + 1])
//                canDFS = false;
//            if (canDFS) {
//                maxNow += map[i1][i2];
//                isVisited[i1][i2] = true;
//                maxRes = Math.max(maxNow, maxRes);
//                if (i2 + 1 >= map[0].length)
//                    dfs(isVisited, map, i1 + 1, 0);
//                else
//                    dfs(isVisited, map, i1, i2 + 1);
//                maxNow -= map[i1][i2];
//                isVisited[i1][i2] = false;
//            }
//            if (i2 + 1 >= map[0].length)
//                dfs(isVisited, map, i1 + 1, 0);
//            else
//                dfs(isVisited, map, i1, i2 + 1);
//
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