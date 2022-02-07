import java.util.Scanner;

public class ques06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            String s = scanner.next();
            if (s.length() == 1) {
                if (s.equals("0"))
                    System.out.println("yes");
                else System.out.println("no");
            } else {
                boolean jud = false;
                String[] tmp = s.split("\\+");
                for (String tmd : tmp) {
                    if (tmd.charAt(0) != '0') {
                        System.out.println("no");
                        jud = true;
                        break;
                    }

                }
                if (!jud)
                    System.out.println("yes");

            }
        }

    }
}
