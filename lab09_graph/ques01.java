//import java.io.*;
//import java.util.StringTokenizer;
//
//public class ques01 {
//    public static void main(String[] args) throws IOException {
//        QReader scanner = new QReader();
//        QWriter out = new QWriter();
//        int cases = scanner.nextInt();
//        for (int i = 0; i < cases; i++) {
//            int n = scanner.nextInt();
//            int m = scanner.nextInt();
//            int[][] graph = new int[n][n];
//            for (int i1 = 0; i1 < m; i1++) {
//                int x = scanner.nextInt();
//                int y = scanner.nextInt();
//                graph[x-1][y-1]++;
//            }
//            for (int i1 = 0; i1 < n; i1++) {
//                for (int i2 = 0; i2 < n; i2++) {
//                    out.print(graph[i1][i2] + " ");
//                }
//                out.println("");
//            }
//        }
//        out.close();
//    }
//}
//
//
