import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ques06 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("1.txt"));
        long tol = scanner.nextInt();
        long doubleH = scanner.nextInt();
        long equalHS = scanner.nextInt();
        long[][] arr = new long[3][(int) tol];

        map[] difference = new map[(int) tol];
        map[] temp1 = new map[(int) tol];

        for (int i = 0; i < tol; i++) {
            arr[0][i] = scanner.nextLong();
            arr[1][i] = scanner.nextLong();
        }
        if (equalHS==0){
            long ans=0;
            for (int i = 0; i < tol; i++) {
                ans+=arr[1][i];
            }
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < tol; i++) {
            arr[2][i] = Math.max(arr[0][i] - arr[1][i], 0);
            difference[i] = new map(i, arr[2][i]);
        }
        sort(difference, 0, (int) (tol - 1), temp1);
        int boundary = Math.max((int) (tol - equalHS),0);
        int ind = 0;
        int count = 0;
        long diffMax = 0;
        long Max = 0;

        long remain = difference[boundary].getNum();
        int co = 0;
        for (long l = boundary; l < tol; l++) {

            arr[1][difference[(int) l].getIndex()] = Math.max(arr[1][difference[(int) l].getIndex()], arr[0][difference[(int) l].getIndex()]);

        }
        long res;

        for (long l = 0; l < tol; l++) {
            if (l >= boundary) {
                if (diffMax < arr[0][difference[(int) l].getIndex()] * (1L << doubleH) - arr[1][difference[(int) l].getIndex()]) {
                    diffMax = arr[0][difference[(int) l].getIndex()] * (1L << doubleH) - arr[1][difference[(int) l].getIndex()];
                    Max = arr[0][difference[(int) l].getIndex()] * (1L << doubleH);
                    ind = (int) l;
                }
            } else {
                if (diffMax < arr[0][difference[(int) l].getIndex()] * (1L << doubleH) - arr[1][difference[(int) l].getIndex()] - remain) {
                    diffMax = arr[0][difference[(int) l].getIndex()] * (1L << doubleH) - arr[1][difference[(int) l].getIndex()] - remain;
                    Max = arr[0][difference[(int) l].getIndex()] * (1L << doubleH);
                    ind = (int) l;
                }
            }
        }
        if (Max > 0)
            arr[1][difference[ind].getIndex()] = 0;
        if (ind < boundary)
            count++;
        res = Max;
        if (count > 0)
            arr[1][difference[boundary].getIndex()] -= difference[boundary].getNum();
        for (int i = 0; i < tol; i++) {
            res += arr[1][i];
        }

        System.out.println(res);
    }

    static void sort(map[] nums, int le, int ri, map[] te) {
        int mid = (ri - le) / 2 + le;
        if (le < ri) {
            sort(nums, le, mid, te);
            sort(nums, mid + 1, ri, te);
            merge(nums, le, mid, ri, te);
        }
    }

    static void merge(map[] nums, int le, int mi, int ri, map[] te) {
        int p1 = le;
        int p2 = mi + 1;
        int tm = le;

        while (p1 <= mi || p2 <= ri) {
            if (p1 <= mi && p2 <= ri) {
                if (nums[p1].getNum() <= nums[p2].getNum()) {
                    te[tm++] = nums[p1];
                    p1++;
                } else {
                    te[tm++] = nums[p2];
                    p2++;
                }
            } else if (p1 <= mi) {
                te[tm++] = nums[p1];
                p1++;
            } else {
                te[tm++] = nums[p2];
                p2++;
            }
        }
        for (int i = le; i <= ri; i++) {
            nums[i] = te[i];
        }
    }

    static class map {
        public int index = 0;
        public long num = 0;

        public map(int index, long num) {
            this.index = index;
            this.num = num;
        }

        public int getIndex() {
            return index;
        }

        public long getNum() {
            return num;
        }
    }
}
