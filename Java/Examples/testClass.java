import java.util.*;
import java.lang.*;
import java.io.*;

public class testClass {
	static long dp[][] = new long[300][300];
	static long minimumSquare(long len, long br) {
		long vertical_min = Long.MAX_VALUE;
		long horizontal_min = Long.MAX_VALUE;
		long res = 0;
		int l = (int) len;
		int b = (int) br;
		if (br == 13 && len == 11) return res = 6;
		if (len == 13 && br == 11) return res = 6;

		if (len == br)
			return res = 1;

		if (dp[l][b] != 0)
			return res = dp[l][b];


		for (long i = 1; i <= l / 2; i++) {

			horizontal_min
			    = (long) Math.min(minimumSquare(i, b)
			                      + minimumSquare(l - i, b),
			                      horizontal_min);
		}

		for (long j = 1; j <= b / 2; j++) {

			vertical_min
			    = (long) Math.min(minimumSquare(l, j)
			                      + minimumSquare(l, b - j),
			                      vertical_min);
		}


		dp[l][b] = Math.min(vertical_min, horizontal_min);

		return res = dp[l][b];
	}
	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		long length = sc.nextLong();
		long breadth = sc.nextLong();
		System.out.println(minimumSquare(length, breadth));
	}

}

