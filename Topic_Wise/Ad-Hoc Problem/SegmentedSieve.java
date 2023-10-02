import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[] ) throws Exception {
        int MAX = 1000001;
        boolean[] primes = new boolean[1000001];
        int i, j;
        primes[0] = primes[1] = false;
        for (i = 2; i < MAX; i++)
            primes[i] = true;
        for (i = 4; i < MAX; i += 2)
            primes[i] = false;
        for (i = 3; i * i < MAX; i += 2) {
            if (primes[i]) {
                for (j = i * i; j < MAX; j += 2 * i) {
                    primes[j] = false;
                }
            }
        }
        int[] pre = new int[1000001];
        pre[0] = pre[1] = 0;
        for (i = 2; i < MAX; i++) {
            pre[i] = pre[i - 1];
            if (primes[i])
                pre[i] = pre[i] + 1;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int A, B, K;
        int q = Integer.parseInt(line);
        for (i = 0; i < q; i++) {
            String[] s1 = br.readLine().split(" ");
            A = Integer.parseInt(s1[0]);
            B = Integer.parseInt(s1[1]);
            K = Integer.parseInt(s1[2]);
            int ans = -1, lo = A, mid, hi = B;
            while (lo <= hi) {
                mid = (lo + hi) >> 1;
                if (pre[mid] - pre[A - 1] >= K) {
                    ans = mid;
                    hi = mid - 1;
                } else
                    lo = mid + 1;
            }
            System.out.println(ans);
        }

    }
}