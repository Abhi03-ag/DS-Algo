

class Knapsack {

	// A utility function that returns
	// maximum of two integers
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// Prints the items which are put
	// in a knapsack of capacity W
	static void printknapSack(int W, int wt[],
	                          int val[], int n) {
		int i, w;
		int K[][] = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = Math.max(val[i - 1] +
					                   K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		// stores the result of Knapsack
		int res = K[n][W];
		System.out.println("Profit: " + res);

		w = W;
		for (i = n; i > 0 && res > 0; i--) {

			if (res == K[i - 1][w])
				continue;
			else {

				System.out.println("Advertisement " + i + " with duration " + wt[i - 1] + " seconds and charge $" + val[i - 1]);
				res = res - val[i - 1];
				w = w - wt[i - 1];
			}
		}
	}

	// Driver code
	public static void main(String arg[]) {
		int val[] = new int[] {150, 300, 400, 500, 600 };
		int wt[] = new int[] {60, 120, 360, 240, 180};
		int W = 480;
		int n = val.length;

		printknapSack(W, wt, val, n);
	}
}

// This code is contributed by Anant Agarwal.
