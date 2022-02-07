import java.util.Scanner;

public class ques03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int i = 0;
        while (i < num) {
            StringBuilder res = new StringBuilder();
            int tem = scanner.nextInt();
            int tem1 = tem;
            int tem2 = tem;

            int len = (int) Math.ceil(Math.log(2 * (double) tem / 3 + 1) / Math.log(3));

            int tmp = len - 1;
            for (int i1 = tmp; i1 > 0; i1--) {
                tem1 -= Math.pow(3, i1);
            }
//63 23 26 36 23 63 23 26 22
            int jud;
            for (int i1 = tmp; i1 > 0; i1--) {
                jud = (int) Math.ceil(tem1 / Math.pow(3, i1));
                tem1 -= (jud-1) * Math.pow(3, i1);

                if (jud == 1)
                    res.append("2");
                else if (jud == 2)
                    res.append("3");
                else if (jud == 3)
                    res.append("6");
            }

            int jud1 = tem % 3;
            if (jud1 == 1)
                res.append("2");
            else if (jud1 == 2)
                res.append("3");
            else if (jud1 == 0)
                res.append("6");
            System.out.println(res);
            i++;
        }
    }
}
