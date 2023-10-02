import java.util.*;
import java.lang.*;
import java.io.*;

public class  LCS {
	public static int[] findLCS(String x, String y) {
		int m = x.length();
		int n = y.length();

		int dp[][] = new int[m + 1][n + 1];

		for (int rows[] : dp) {
			Arrays.fill(rows, 0);
		}
		int firstIndex = -1;
		int lastIndex = -1;
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					continue;
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					if (firstIndex == -1) {
						firstIndex = lastIndex = j - 1;
					} else {
						lastIndex = j - 1;
					}
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return new int[] {firstIndex, lastIndex, dp[m][n]};
	}
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("../Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("../Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		String y = sc.nextLine();
		String z = new StringBuilder(y).reverse().toString();
		String a = new StringBuilder(x).reverse().toString();

		int max = 0;
		int[] output = findLCS(x, z);


	}
}