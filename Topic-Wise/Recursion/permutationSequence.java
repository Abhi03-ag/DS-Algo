import java.util.*;
import java.lang.*;
import java.io.*;

/*
	Link: https://leetcode.com/problems/permutation-sequence/description/
	Time Complexity : O(N2) N for finding the each digit and other N is for adjusting the list while finding the digit
	Space Complexity: O(N) N for both auxillary stack space and final ans.
	Brute Force Approach: Recursively finding all the permutations and stopping once we hit the sequence no. TC.(N!*N)
	Note: For large input we can precompute the factorial and store it in a list.
*/
public class permutationSequence {
	public static String getPermutation(int n, int k) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		return findKthPermutation(list, k - 1, new StringBuilder());
	}
	public static String findKthPermutation(List<Integer> list, int k, StringBuilder ans) {
		if (list.size() == 1) {
			char lastDigit = (char)(list.get(0) + 48);
			ans.append(lastDigit);
			return ans.toString();
		}
		int blockSize = getFactorial(list.size() - 1);
		int blockNumber = k / blockSize;
		char digit = (char)(list.get(blockNumber) + 48);
		ans.append(digit);
		list.remove(blockNumber);
		return findKthPermutation(list, k % blockSize, ans);
	}
	public static int getFactorial(int input) {
		int ans = 1;
		for (int i = 2; i <= input; i++)
			ans *= i;
		return ans;
	}
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("../Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("../Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
	}
}