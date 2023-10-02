import java.util.*;
import java.lang.*;
import java.io.*;

class FindClosestNumber
{
    public static int minimumTime(int A, int B, int[] P, int[] L)
    {
        Arrays.sort(P);
        Arrays.sort(L);
        int Total_time = 0;
        for (int i = 0; i < P.length; i++)
        {
            int A_distance = Integer.MAX_VALUE;
            int B_distance = Integer.MAX_VALUE;
            int position = P[i];
            int arr[] = findClosestNumbers(L, position);
            if (arr[0] == position)
                A_distance = 0;
            if (arr[0] != position)
            {
                B_distance = (position - arr[0]) * B;
            }
            if (arr[1] != 0)
            {
                A_distance = (arr[1] - position) * A;
            }
            Total_time = Math.max(Math.min(A_distance, B_distance), Total_time);
        }
        return Total_time;
    }
    public static int[] findClosestNumbers(int arr[], int target)
    {
        int n = arr.length;
        int result[] = new int[2];
        if (target <= arr[0])
        {
            result[0] = arr[0];
            return result;
        }
        if (target >= arr[n - 1])
        {
            result[0] = arr[n - 1];
            return result;
        }
        int i = 0, j = n, mid = 0;
        while (i < j)
        {
            mid = (i + j) / 2;
            if (arr[mid] == target)
            {
                result[0] = arr[mid];
                return result;
            }
            if (target < arr[mid])
            {
                if (mid > 0 && target > arr[mid - 1])
                {
                    result[0] = arr[mid - 1];
                    result[1] = arr[mid];
                    return result;
                }
                j = mid;
            }
            else
            {
                if (mid < n - 1 && target < arr[mid + 1])
                {
                    result[0] = arr[mid];
                    result[1] = arr[mid + 1];
                    return result;
                }
                i = mid + 1;
            }
        }
        result[0] = arr[mid];
        return result;
    }
    // Driver code
    public static void main(String[] args)
    {
        int arr[] = {1, 10, 20, 45};
        int arr1[] = {2, 4, 8, 9};
        System.out.println(minimumTime(4, 5, arr, arr1));
       
   }
}

