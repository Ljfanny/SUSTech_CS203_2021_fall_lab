import java.util.Scanner;

public class ques01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt();
        }
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            int temp = scanner.nextInt();
            System.out.println(bi(array, temp, 0, array.length - 1));
        }
    }

    public static String bi(int[] array, int temp, int left, int right) {
        int mid = (right - left) / 2 + left;
        while (left <= right) {
            if (temp > array[mid]) {
                left = mid + 1;
                mid = (right - left) / 2 + left;
            } else if (temp < array[mid]) {
                right = mid - 1;
                mid = (right - left) / 2 + left;
            } else if (temp == array[mid]) {
                return "YES";
            }
        }
        return "NO";
    }
}
