//import java.io.*;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class ques02 {
//    public static void main(String[] args) throws IOException {
//        QReader scanner = new QReader();
//        QWriter out = new QWriter();
//        int[][] dir = new int[8][8];
//        dir[0][0] = 2;
//        dir[0][1] = 1;
//        dir[1][0] = 1;
//        dir[1][1] = 2;
//        dir[2][0] = -2;
//        dir[2][1] = -1;
//        dir[3][0] = -1;
//        dir[3][1] = -2;
//        dir[4][0] = -1;
//        dir[4][1] = 2;
//        dir[5][0] = -2;
//        dir[5][1] = 1;
//        dir[6][0] = 2;
//        dir[6][1] = -1;
//        dir[7][0] = 1;
//        dir[7][1] = -2;
//        int n = scanner.nextInt();
//        for (int i = 0; i < n; i++) {
//            String p1 = scanner.next();
//            String p2 = scanner.next();
////            boolean[] isVisited = new boolean[64];
////            int[] step = new int[64];
//            char[] ch1 = p1.toCharArray();
//            char[] ch2 = p2.toCharArray();
//            int row = ch1[0] - 'a';
//            int col = ch1[1] - '1';
//            int numStart = row * 8 + col;
//            int numEnd = (ch2[0] - 'a') * 8 + (ch2[1] - '1');
//            Queue<Integer> queue = new LinkedList<Integer>();
//            queue.add(numStart);
//            int step;
//            step = 0;
//            while (!queue.isEmpty()) {
//                int size = queue.size();
//                for (int i1 = 0; i1 < size; i1++) {
//                    int o = queue.poll();
//                    if (o == numEnd) {
//                        out.println(step);
//                        queue.clear();
//                        break;
//                    } else {
//                        for (int j = 0; j < 8; j++) {
//                            int tem = o + 8 * dir[j][0] + dir[j][1];
//                            if (o / 8 + dir[j][0] > -1 && o / 8 + dir[j][0] < 8 && o % 8 + dir[j][1] > -1 && o % 8 + dir[j][1] < 8 ) {
//                                queue.add(tem);
//                            }
//                        }
//                    }
//                }
//                step++;
//            }
//        }
//        out.close();
//    }
//}
//
