import java.util.*;

public class ques05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Long> tmp = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("0");
        queue.add("00");
        queue.add("69");
        queue.add("96");
        queue.add("1");
        queue.add("8");
        queue.add("88");
        queue.add("11");
        String[] strings = new String[10];
        strings[0] = "1";
        strings[1] = "1";
        strings[2] = "0";
        strings[3] = "0";
        strings[4] = "8";
        strings[5] = "8";
        strings[6] = "6";
        strings[7] = "9";
        strings[8] = "9";
        strings[9] = "6";
        tmp.add(0L);
        while (queue.size() != 0) {
            String peek = queue.poll();
            if (peek.charAt(0) != '0')
                tmp.add(Long.parseLong(peek));
            for (int i = 0; i < strings.length - 1; i += 2) {
                if (peek.length() < 11) {
                    String temp = strings[i] + peek + strings[i + 1];
                    queue.add(temp);
                }
            }

        }
        Collections.sort(tmp);

        while (scanner.hasNext()) {
            long fir = scanner.nextLong();
            long las = scanner.nextLong();
            boolean f = false;
            boolean l = false;
            for (int i = 0; i < tmp.size(); i++) {
                if (tmp.get(i) >= fir && !f) {
                    f = true;
                    System.out.print(tmp.get(i));
                }
                if (tmp.get(i) > las && !l && las < 999999666666L && f) {
                    l = true;
                    System.out.println(" " + tmp.get(i - 1));
                }
                if (las >= 999999666666L && !l && f) {
                    l = true;
                    System.out.println(" " + 999999666666L);
                }

                if (f && l)
                    break;
            }
        }
    }
}
