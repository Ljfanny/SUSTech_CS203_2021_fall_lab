//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//
//public class q1440 {
//    public static void main(String[] args) throws IOException {
//        QReader scanner = new QReader();
//        QWriter out = new QWriter();
//        String str = scanner.next();
//        int loop = (int) Math.sqrt(str.length()) + 1;
//        Node head = new Node();
//        Node node = head;
//        for (int i = 0; i < loop; ++i) {
//            node.next = new Node(2 * loop);
//            node = node.next;
//        }
//        node = head.next;
//        int temp = 0;
//        for (int i = 0; i < loop; ++i) {
//            for (int i1 = i * loop; i1 < i * loop + loop; ++i1) {
//                if (i1 < str.length())
//                    node.arrayList.add(new Point(str.charAt(i1)));
//                else break;
//            }
//            node = node.next;
//        }
//
//        int cases = scanner.nextInt();
//        for (int i = 0; i < cases; ++i) {
//            int index = scanner.nextInt();
//            if (index == 1) {
//                char cha = scanner.next().charAt(0);
//                int con = scanner.nextInt();
//                insertion(head, cha, con);
//            } else if (index == 2) {
//                int con = scanner.nextInt();
//                out.println(finder(head, con));
//            } else {
//                int con1 = scanner.nextInt();
//                int con2 = scanner.nextInt();
//                transform(head, con1, con2);
//            }
//        }
//        out.close();
//    }
//
//    static void insertion(Node head, char goal, int index) {
//        int count = 0;
//        Node now = head;
//        while (count < index) {
//            now = now.next;
//            count += now.arrayList.size();
//        }
//        ArrayList<Point> arr = new ArrayList<>();
//        for (int i = 0; i < now.arrayList.size(); ++i) {
//            arr.add(new Point(now.arrayList.get(i).value,now.arrayList.get(i).isMark,now.arrayList.get(i).count));
//        }
//        boolean isAdd = false;
//        for (int i = 0; i < arr.size(); ++i) {
//            if (i == arr.size() - (count - index) - 1) {
//                now.arrayList.get(i).value = goal;
//                if (i + 1 < arr.size()) {
//                    now.arrayList.get(i + 1).count = arr.get(i).count;
//                    now.arrayList.get(i + 1).isMark = arr.get(i).isMark;
//                    now.arrayList.get(i + 1).value = arr.get(i).value;
//                } else now.arrayList.add(arr.get(i));
//                isAdd = true;
//                continue;
//            }
//            if (!isAdd) {
//                now.arrayList.get(i).count = arr.get(i).count;
//                now.arrayList.get(i).isMark = arr.get(i).isMark;
//                now.arrayList.get(i).value = arr.get(i).value;
//            } else {
//                if (i + 1 >= arr.size())
//                    now.arrayList.add(arr.get(i));
//                else {
//                    now.arrayList.get(i + 1).count = arr.get(i).count;
//                    now.arrayList.get(i + 1).isMark = arr.get(i).isMark;
//                    now.arrayList.get(i + 1).value = arr.get(i).value;
//                }
//            }
//        }
//    }
//
//    static char finder(Node head, int index) {
//        int count = 0;
//        Node now = head;
//        while (count < index) {
//            now = now.next;
//            count += now.arrayList.size();
//        }
//        return (now.arrayList.get(now.arrayList.size() - (count - index) - 1).isMark || now.isMarked) ? ((now.arrayList.get(now.arrayList.size() - (count - index) - 1).count + now.nums)% 2 == 0 ? now.arrayList.get(now.arrayList.size() - (count - index) - 1).value : (char) ('a' + 'z' - now.arrayList.get(now.arrayList.size() - (count - index) - 1).value)) : now.arrayList.get(now.arrayList.size() - (count - index) - 1).value;
//    }
//
//    static void transform(Node head, int l, int r) {
//        Node left = head;
//        int lo = 0;
//        while (lo < l) {
//            left = left.next;
//            lo += left.arrayList.size();
//        }
//        Node right = left;
//        int hi = 0;
//        if (lo < r) {
//            while (hi < r) {
//                right = right.next;
//                hi += right.arrayList.size();
//            }
//            hi = right.arrayList.size() - (hi - r);
//        } else {
//            hi = right.arrayList.size() - (lo - r);
//
//        }
//        lo = left.arrayList.size() - (lo - l) - 1; // i = lo;
//        //<hi
//        boolean isFir = true;
//        while (left != right) {
//            if (isFir) {
//                for (int i = lo; i < left.arrayList.size(); ++i) {
//                    left.arrayList.get(i).isMark = true;
//                    left.arrayList.get(i).count++;
//                }
//                isFir = false;
//            } else {
//                left.isMarked = true;
//                left.nums++;
//            }
//            left = left.next;
//        }
//        if (isFir) {
//            for (int i = lo; i < hi; ++i) {
//                left.arrayList.get(i).isMark = true;
//                left.arrayList.get(i).count++;
//            }
//        } else {
//            for (int i = 0; i < hi; ++i) {
//                left.arrayList.get(i).isMark = true;
//                left.arrayList.get(i).count++;
//            }
//        }
//    }
//
//    static class Point {
//        protected char value;
//        protected boolean isMark;
//        protected int count;
//
//        public Point(char value) {
//            this.value = value;
//            this.isMark = false;
//            this.count = 0;
//        }
//
//        public Point(char value, boolean is, int count) {
//            this.value = value;
//            this.isMark = is;
//            this.count = count;
//        }
//    }
//
//    static class Node {
//        protected Node next;
//        protected int nums;
//        protected boolean isMarked;
//        protected ArrayList<Point> arrayList;
//
//        public Node() {
//            this.next = null;
//            this.arrayList = new ArrayList<>();
//            this.isMarked = false;
//            this.nums = 0;
//        }
//
//        public Node(int len) {
//            this.next = null;
//            this.arrayList = new ArrayList<>(len);
//            this.isMarked = false;
//            this.nums = 0;
//        }
//    }
//
//}
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
//    private BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("q4t3.in")));
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
//
