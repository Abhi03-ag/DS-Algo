import java.util.*;
import java.io.*;

class leet154 {
    public static  int findMin(int[] num) {
        int lo = 0;
        int hi = num.length - 1;
        int mid = 0;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;

            if (num[mid] > num[hi]) {
                lo = mid + 1;
            } else if (num[mid] < num[hi]) {
                hi = mid;
            } else { // when num[mid] and num[hi] are same
                if (num[hi - 1] > num[hi]) {
                    lo = hi;
                    break;
                }
                hi--;
            }
        }
        return lo;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int arr[]  = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        System.out.println(findMin(arr));
    }
}