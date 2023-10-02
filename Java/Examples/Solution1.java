import java.util.*;
public class Solution1
{
    public static int count( int S[], int m, int n )
    {
        int table[] = new int[n + 1];
        table[0] = 1;
        for(int i = 0; i < m; i++)
            for(int j = S[i]; j <= n; j++)
                table[j] += table[j - S[i]];
        return table[n];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        System.out.println(count(arr, n, m));
    }
}