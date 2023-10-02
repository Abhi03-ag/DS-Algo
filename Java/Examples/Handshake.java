import java.io.*;

class Handshake
{
    static int dp(int n)
    {
        int modulo = 1000000007;
        int []dp = new int [n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++)
        {
            dp[i] = 0;
            for (int j = 0; j < i; j++)
                dp[i] = (dp[i]%modulo +  (dp[j] % modulo * 
                              dp[i - j - 1] %modulo))%modulo;
        }
        return dp[n];
    }
    static int countWays(int n)
    {
        if (n < 1)
        {
            return 0;
        }
        return dp(n / 2);
    }
    public static void main (String[] args) 
    {
        System.out.println(countWays(86) + " ");
    }
}



