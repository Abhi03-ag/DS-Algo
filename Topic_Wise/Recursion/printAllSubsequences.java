import java.util.*;
import java.lang.*;
import java.io.*;

public class  printAllSubsequences {
	//T.C. = O(2^n * n)
	//S.C. = O(2^n * n) if we store the subsequences
	//S.C. = O(n) if we print subsequence

	//Power Set Method
	public static ArrayList<String> iterativeSubsequences(String str) {
		//PowerSet Concept
		ArrayList<String> result = new ArrayList<>();
		for (int num = 0; num < (1 << str.length()); num++) {
			StringBuffer temp = new StringBuffer();
			for (int i = 0; i < str.length(); i++) {
				if ((num & (1 << i) ) != 0) {
					temp.append(str.charAt(i));
				}
			}
			result.add(temp.toString());
		}

		return result;

	}
	//Level wise picking At each level iterate through the available options
	public static void recuriveLevelWiseSubsequences(String input, int startIndex, List<String> result, StringBuilder ans) {
		result.add(ans.toString());
		for (int idx = startIndex; idx < input.length(); idx++) {
			char ch = input.charAt(idx);
			ans.append(ch);
			//calling the recursion
			recuriveLevelWiseSubsequences(input, idx + 1, result, ans);
			ans.deleteCharAt(ans.length() - 1);
		}
	}
	//Picking & Non Picking a element
	public static void recursiveSubsequences(String input, int startIndex, List<String> result, StringBuilder ans) {
		//Recursive Way
		if (startIndex >= input.length()) {
			result.add(ans.toString());
			return;
		}
		char ch = input.charAt(startIndex);
		recursiveSubsequences(input, startIndex + 1, result, ans.append(ch));
		ans.deleteCharAt(ans.length() - 1);
		recursiveSubsequences(input, startIndex + 1, result, ans);
	}
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("../Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("../Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		List<String> result = new ArrayList<>();
		recuriveLevelWiseSubsequences(input, 0, result, new StringBuilder());
		System.out.println(result);
	}
}