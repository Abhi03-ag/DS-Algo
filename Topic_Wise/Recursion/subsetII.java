import java.util.*;
import java.lang.*;
import java.io.*;

/*
	Problem Link: https://leetcode.com/problems/subsets-ii/description/
	Time Complexity = O(2^N*K); where 2^N is the number of calls for finding all the valid subsets and K is the average length of subset for which adding it to the final list takes time.
	Space Complexity = O(2^N * K) Total Space for the final list
	Auxillary Stack Space = O(N) Maximum length of one of the subset.
*/
public class subsetII {
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		findSubsetWithoutDuplicates(nums, 0, new ArrayList<>(), result);
		return result;
	}
	public static void findSubsetWithoutDuplicates(int[] nums, int currIdx, List<Integer> currSet, List<List<Integer>> result) {
		System.out.println("Final Set -> " + currSet);
		result.add(new ArrayList<>(currSet));

		System.out.println("New Call");
		Set<Integer> set = new HashSet<Integer>();
		int idx;
		for ( idx = currIdx; idx < nums.length; idx++) {
			System.out.println("HashSet -> " + set);
			System.out.println(currSet);

			int element = nums[idx];
			System.out.println(element);
			if (!set.contains(element)) {
				set.add(element);
				currSet.add(element);
				System.out.println("Curr Set ->" + currSet);
				findSubsetWithoutDuplicates(nums, idx + 1, currSet, result);
				currSet.remove(currSet.size() - 1);
			}


		}
	}
	// public void findSubsetWithoutDuplicates(int[] nums, int currIdx, List<Integer> currSet, List<List<Integer>> result) {
	// 	//base condition
	// 	if (currIdx == nums.length) {
	// 		result.add(new ArrayList<>(currSet));
	// 		return;
	// 	}
	// 	//recursive condition
	// 	int element = nums[currIdx];
	// 	//Picking the element
	// 	currSet.add(element);
	// 	findSubsetWithoutDuplicates(nums, currIdx + 1, currSet, result);
	// 	currSet.remove(currSet.size() - 1);

	// 	//Skipping the duplicate number for a particular level
	// 	while (currIdx + 1 < nums.length && element == nums[currIdx + 1])
	// 		currIdx++;
	// 	findSubsetWithoutDuplicates(nums, currIdx + 1, currSet, result);
	// }
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("../Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("../Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[] {1, 2, 3};
		System.out.println(subsetsWithDup(nums));
	}
}