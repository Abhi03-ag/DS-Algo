import java.util.*;
import java.lang.*;
import java.io.*;

/*
Note:
If the input space only contains the positive element then we can add only those elements to our list which are less than the given sum.
Since the subsequence depends on the order of elements, we cannot sort the input space to trim it elements which can potentially belong to our result set.*/

public class printAllSubsequenceWithSumEqualToK {


	public static void printAllSubsequenceWithAGivenSum(List<Integer> list, int targetSum, int currIdx, List<Integer> currList) {

		if (currIdx >= list.size()) {
			if (targetSum == 0) {
				System.out.println(currList);
			}
			return;
		}
		int element = list.get(currIdx);
		currList.add(element);
		printAllSubsequenceWithAGivenSum(list, targetSum - element, currIdx + 1, currList);
		currList.remove(currList.size() - 1);
		printAllSubsequenceWithAGivenSum(list, targetSum, currIdx + 1, currList);
	}
	public static boolean  printAnySubsequenceWithAGivenSum(List<Integer> list, int targetSum, int currIdx, List<Integer> currList) {

		if (currIdx >= list.size()) {
			if (targetSum == 0) {
				System.out.println(currList);
				return true;
			}
			return false;
		}
		int element = list.get(currIdx);
		currList.add(element);
		if (printAnySubsequenceWithAGivenSum(list, targetSum - element, currIdx + 1, currList))
			return true;
		currList.remove(currList.size() - 1);
		if (printAnySubsequenceWithAGivenSum(list, targetSum, currIdx + 1, currList))
			return true;

		return false;
	}
	public static int countAllSubsequenceWithAGivenSum(List<Integer> list, int targetSum, int currIdx, List<Integer> currList) {

		if (currIdx >= list.size()) {
			if (targetSum == 0) {
				return 1;
			}
			return 0;
		}
		int element = list.get(currIdx);
		currList.add(element);
		int count1 = countAllSubsequenceWithAGivenSum(list, targetSum - element, currIdx + 1, currList);
		currList.remove(currList.size() - 1);
		int count2 = countAllSubsequenceWithAGivenSum(list, targetSum, currIdx + 1, currList);
		return count1 + count2;
	}
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("../Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("../Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		System.out.println(printAnySubsequenceWithAGivenSum(List.of(1, 3, 2), 3, 0, new ArrayList<>()));

	}
}