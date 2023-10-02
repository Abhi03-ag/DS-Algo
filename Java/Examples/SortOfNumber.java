import java.io.*;
import java.util.*;

public class SortOfNumber
{
    static void Sorting(int a[], int arr_size)
    {
        int low = 0;
        int high = arr_size - 1;
        int mid = 0, temp = 0;
        while (mid <= high)
        {
            switch (a[mid])
            {
            case 0:
            {
                mid++;
                break;
            }
            case 1:
            {
                temp = a[low];
                a[low] = a[mid];
                a[mid] = temp;
                low++;
                mid++;
                break;
            }
            case 2:
            {
                temp = a[mid];
                a[mid] = a[high];
                a[high] = temp;
                high--;
                break;
            }
            }
        }
    }
    static void print(int arr[], int arr_size)
    {
        int i;
        for (i = 0; i < arr_size; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int arr_size = sc.nextInt();
        int arr[] = new int[arr_size];
        for (int i = 0; i < arr_size; i++)
        {
            arr[i] = sc.nextInt();
        }
        Sorting(arr, arr_size);
        print(arr, arr_size);
    }
}