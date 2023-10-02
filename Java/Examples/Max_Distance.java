import java.util.*;
import java.lang.*;
import java.io.*;

public class Max_Distance
{
    public static  int maxDistance(int[] nums1, int[] nums2)
    {
        int curr_distance = 0;
        int max_distance = 0;
        for(int s = 0; s < nums1.length; s++)
        {
            int index = BinarySearch(nums2, s, nums2.length - 1, nums1[s]);
            if(index >= s && nums2[index] >= nums1[s])
            {
                curr_distance = index - s;
            }
            if(curr_distance > max_distance)
                max_distance = curr_distance;
        }
        return max_distance;
    }

    public static int BinarySearch(int arr[], int start, int end, int target)
    {

        int mid = 0;
        while(end >= start)
        {
            mid = start + (end - start) / 2;
            if(arr[mid] == target)
            {
                if(mid + 1 < arr.length && arr[mid + 1] < target)
                    return mid;
                start = mid + 1;
            }
            else if(arr[mid] < target)
            {
                if(mid > start && arr[mid - 1] >= target)
                    return mid - 1;
                end = mid - 1;
            }
            else
            {
                if(mid + 1 < arr.length && arr[mid + 1] < target)
                    return mid;
                start = mid + 1;
            }
        }
        return mid;
    }
    public static void main(String[] args)
    {
        try
        {
            System.setIn(new FileInputStream("Input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("Output.txt")));
        }
        catch(Exception e)
        {
            System.err.println("Error");
        }
        Scanner sc = new Scanner(System.in);
        int nums1[] = {55, 30, 5, 4, 2};
        int nums2[] = {100, 20, 10, 10, 5};
        System.out.println(maxDistance(nums1, nums2));
    }
}
