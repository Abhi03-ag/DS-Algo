import java.util.*;
import java.lang.*;
import java.io.*;

public class LexicographicallySortedPermutations {
	public static void findLexicographicallySortedPermutations(String input) {
		printLexicographicallySortedPermutations(input, new StringBuilder(), 0);
	}
	public static void printLexicographicallySortedPermutations(String input, StringBuilder currString, int flag) {
		if (currString.length() == input.length()) {
			System.out.println(currString);
			return;
		}
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if ((flag & (1 << i)) == 0) {
				if (!set.contains(ch)) {
					set.add(ch);
					currString.append(ch);
					printLexicographicallySortedPermutations(input, currString, (flag | (1 << i)));
					currString.deleteCharAt(currString.length() - 1);
				}
			}

		}
	}
	public static String getPermutation(int n, int k) {
		findKthPermutation(n, k, 0, new StringBuilder(), 0);
		return "";
	}
	public static  void findKthPermutation(int n, int k, int seqNo, StringBuilder temp, int flag) {
		if (temp.length() == n) {
			System.out.println("Printing " + temp.toString() + " " + seqNo + " " + k);
			seqNo++;
			if (seqNo == k) {
				System.out.println(temp.toString());
			}

			return;
		}
		for (int i = 1; i <= n; i++) {
			char ch = (char)(i + 48);
			if ((flag & (1 << (i - 1))) == 0) {
				temp.append(ch);
				findKthPermutation(n, k, seqNo, temp, (flag | (1 << (i - 1))));
				temp.deleteCharAt(temp.length() - 1);
			}
		}
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
		//findLexicographicallySortedPermutations(input);
		getPermutation(3, 1);
	}
}