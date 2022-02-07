//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class MinimalTime {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cases = scanner.nextInt();
//        for (int i = 0; i < cases; i++) {
//            int cities = scanner.nextInt();
//            int people = scanner.nextInt();
//
//            Tree[] trees = new Tree[cities + 1];
//            for (int j = 1; j <= cities; j++) {
//                trees[j] = new Tree();
//            }
//            for (int j = 0; j < cities - 1; j++) {
//                int x = scanner.nextInt();
//                int y = scanner.nextInt();
//                trees[x].child.add(trees[y]);
//                trees[y].child.add(trees[x]);
//            }
//            int z = 0;
//            for (int j = 0; j < people; j++) {
//                z = scanner.nextInt();
//                trees[z].hasPerson = true;
//            }
//
//            if (people == 1 || cities == 1) {
//                System.out.println(0);
//                continue;
//            }
//            Tree[] queue = new Tree[cities + 1];
//            int front = 0;
//            int rear = 0;
//            queue[rear++] = trees[z];
//            trees[z].isVisitedFir = true;
//            int max = 0;
//            Tree sec = null;
//            while (rear > front) {
//                Tree father = queue[front++];
//                if (father.times > max && father.hasPerson) {
//                    max = father.times;
//                    sec = father;
//                }
//                for (int k = 0; k < father.child.size(); k++) {
//                    if (!father.child.get(k).isVisitedFir) {
//                        queue[rear++] = father.child.get(k);
//                        father.child.get(k).isVisitedFir = true;
//                        father.child.get(k).times = father.times + 1;
//                    }
//                }
//            }
//            Tree[] q = new Tree[cities + 1];
//            front = 0;
//            rear = 0;
//            q[rear++] = sec;
//            sec.times = 0;
//            sec.isVisitedSec = true;
//            while (rear > front) {
//                Tree father = q[front++];
//                if (father.times > max && father.hasPerson)
//                    max = father.times;
//                for (int k = 0; k < father.child.size(); k++) {
//                    if (!father.child.get(k).isVisitedSec) {
//                        q[rear++] = father.child.get(k);
//                        father.child.get(k).isVisitedSec = true;
//                        father.child.get(k).times = father.times + 1;
//                    }
//                }
//            }
//            System.out.println((max + 1) / 2);
//        }
//
//
//    }
//
//    static class Tree {
//        public int times;
//        public ArrayList<Tree> child;
//        public boolean isVisitedFir;
//        public boolean isVisitedSec;
//        public boolean hasPerson;
//
//        Tree() {
//            this.times = 0;
//            this.child = new ArrayList<Tree>();
//            this.isVisitedFir = false;
//            this.isVisitedSec = false;
//            this.hasPerson = false;
//        }
//    }
//}
