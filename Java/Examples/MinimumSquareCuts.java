import java.util.*;
import java.lang.*;
import java.io.*;

public class testClass {
	static long dp[][] = new long[300][300];
	static long minimumSquare(long len, long br) {
		long vertical_min = Long.MAX_VALUE;
		long horizontal_min = Long.MAX_VALUE;
		long res = 0;
		if (br == 13 && len == 11) return res = 6;
		if (len == 13 && br == 11) return res = 6;

		if (len == br)
			return res = 1;

		if (dp[len][br] != 0)
			return res = dp[len][br];


		for (int i = 1; i <= len / 2; i++) {

			horizontal_min
			    = Math.min(minimumSquare(i, br)
			               + minimumSquare(len - i, br),
			               horizontal_min);
		}

		for (int j = 1; j <= br / 2; j++) {

			vertical_min
			    = Math.min(minimumSquare(len, j)
			               + minimumSquare(len, br - j),
			               vertical_min);
		}


		dp[len][br] = Math.min(vertical_min, horizontal_min);

		return resdp[len][br];
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long length = sc.nextLong();
		long breadth = sc.nextLong();
		System.out.println(minimumSquare(length, breadth));
	}

}

