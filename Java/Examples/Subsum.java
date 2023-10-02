import java.util.*;
class Subsum {
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // Your code here
        ArrayList<Integer> subarray = new ArrayList<>();
        int start = 0;
        int end = 1;
        int sum = arr[0];
        boolean f = false;
        while (end < n || start < n) {
            while (sum > s && start <= end - 1) {
                sum = sum - arr[start];
                System.out.println(sum + " " + start);
                start++;
            }
            if (sum == s) {
                subarray.add(start + 1);
                subarray.add(end);
                System.out.println("Abhi");
                f = true;
                break;
            } else if (sum < s) {
                sum = sum + arr[end];
                System.out.println(sum + " " + end);
                end++;
            }

        }
        if (!f)
            subarray.add(-1);

        return subarray;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = 42;
        int arr[] = {135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117 , 119 , 96 , 48 , 127 , 172 , 139 , 70 , 113 , 68 , 100 , 36 , 95, 104, 12, 123 , 134};
        int s = 468;
        ArrayList<Integer> res = subarraySum(arr, n, s);
        System.out.println(res.toString());
    }
}