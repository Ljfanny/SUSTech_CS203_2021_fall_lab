import java.util.Scanner;

public class ques05 {
    static long res=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        long [] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i]=in.nextLong();
        }
        long [] tem = new long[n];
        sort(arr,0,n-1,tem);
        System.out.println(res);
    }

    static void sort(long[] nums, int le, int ri, long[] te) {
        int mid = (ri - le) / 2 + le;
        if (le < ri) {
            sort(nums, le, mid, te);
            sort(nums, mid + 1, ri, te);
            merge(nums, le, mid, ri, te);
        }
    }

    static void merge(long[] nums, int le, int mi, int ri, long[] te) {
        int p1 = le;
        int p2 = mi + 1;
        int tm = le;
        while (p1 <= mi || p2 <= ri) {
            if (p1 <= mi && p2 <= ri) {
                if (nums[p1] <= nums[p2]) {
                    te[tm++] = nums[p1];
                    p1++;
                } else {
                    res += nums[p2]*(mi - p1 + 1);
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
}
