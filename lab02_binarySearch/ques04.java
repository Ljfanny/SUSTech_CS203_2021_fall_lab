import java.util.Arrays;
import java.util.Scanner;

public class ques04 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int num = sca.nextInt();
        long[] array = new long[num];
        long[] bis = new long[27];

        for (int i = 0; i < num; i++) {
            array[i] = sca.nextLong();
        }

        int[] res = new int[(int) Math.pow(2, 27) - (int) array[0] + 1];
        Arrays.fill(res, 0);

        for (int i = 0; i < 27; i++) {
            bis[i] = (long) Math.pow(2, i + 1);
        }
        int pri = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 27; j++) {
                if (bis[j] - array[i] > 0) {
                    pri += res[(int)bis[j] - (int)array[i]];
                }
            }
            res[(int)array[i]]++;
        }

        System.out.println(pri);

    }
}