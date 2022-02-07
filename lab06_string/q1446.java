//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Scanner;
//
//public class q1446 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.next();
//        char[] chs = str.toCharArray();
////        String[] res = new String[chs.length * chs.length];
//        ArrayList<String> res = new ArrayList<>();
//        for (int i = 0; i < chs.length; i++) {
//            StringBuilder s = new StringBuilder();
//            s.append(chs[i]);
//            res.add(s.toString());
//            for (int j = i + 1; j < chs.length; j++) {
//                s.append(chs[j]);
//                res.add(s.toString());
//            }
//        }
//        Collections.sort(res);
//        int p1 = 0;
//        int p2 = 1;
//        int count = 0;
//        while (p2 < res.size()){
//            if (!res.get(p1).equals(res.get(p2))){
//                p1 = p2;
//                p2++;
//                count++;
////                if (p2 == res.size())
////                    count++;
//            }
//            else {
//                p2++;
//            }
//        }
//        System.out.println(++count);
//    }
//}
