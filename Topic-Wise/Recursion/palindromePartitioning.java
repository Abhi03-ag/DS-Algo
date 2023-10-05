import java.util.*;
import java.lang.*;
import java.io.*;
/*
	Problem Link: https://leetcode.com/problems/palindrome-partitioning/description/
	Time Complexity : O(N*2^N) In worst case at max we can have 2^N substring as palindrome and N is the recursion cost of reaching the last level.
	Space Complexity: O(N) recursive stack space,2^N*K for final result
*/
public class palindromePartitioning {
	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		findPartitionList(s, 0, 1, new ArrayList<>(), result, s.length());
		return result;
	}

	public static void findPartitionList(String s, int startIdx, int endIdx, List<String> currList, List<List<String>> result, int len) {

		//base case
		if (endIdx > len) {
			if (startIdx == len) {

				result.add(new ArrayList<>(currList));
			}
			return;
		}
		//recursive case
		String firstPart = s.substring(startIdx, endIdx);

		if (isPalindrome(firstPart, 0)) {
			currList.add(firstPart);
			findPartitionList(s, endIdx, endIdx + 1, currList, result, len);
			currList.remove(currList.size() - 1);
		}
		findPartitionList(s, startIdx, endIdx + 1, currList, result, len);
	}
	public void findPartitionList(String s, int currIdx, List<String> currList, List<List<String>> result) {
		if (currIdx == s.length()) {
			result.add(new ArrayList<>(currList));
			return;
		}

		for (int idx = currIdx; idx < s.length(); idx++) {
			String firstPart = s.substring(currIdx, idx + 1);
			if (isPalindrome(firstPart, 0)) {
				currList.add(firstPart);
				findPartitionList(s, idx + 1, currList, result);
				currList.remove(currList.size() - 1);
			}
		}
	}
	public static boolean isPalindrome(String input, int index) {
		if (index == input.length() / 2) {
			return true;
		}
		if (input.charAt(index) != input.charAt(input.length() - 1 - index))
			return false;
		return isPalindrome(input, index + 1);
	}
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("../Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("../Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println(partition(input));
	}
}