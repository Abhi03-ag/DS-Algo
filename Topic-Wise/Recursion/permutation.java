import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;
import java.io.*;
/*
Problem Link - https://leetcode.com/problems/permutations/
Time Complexity - (N!*N) Total number of permuations is N! and for each permutation it would take O(N) to add it to our list.
Space Complexity - O(N!*N)
*/
public class  permutation {
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		findPermutations(nums, result, 0);
		return result;
	}
	// public void findPermutations(int[] nums, List<Integer> currList, List<List<Integer>> result, int flag ) {
	// 	if (currList.size() == nums.length) {
	// 		result.add(new ArrayList<>(currList));
	// 		return;
	// 	}
	// 	for (int i = 0; i < nums.length; i++) {
	// 		int element = nums[i];
	// 		if ((flag & (1 << i)) == 0) {
	// 			int updatedFlag = (flag | (1 << i));
	// 			currList.add(element);
	// 			findPermutations(nums, currList, result, updatedFlag);
	// 			currList.remove(currList.size() - 1);
	// 		}
	// 	}
	// }
	public static void findPermutations(int[] nums, List<List<Integer>> result, int index ) {
		if (index == nums.length) {
			List<Integer> currList = Arrays.stream(nums).boxed().collect(Collectors.toList());
			result.add(new ArrayList<>(currList));
			return;
		}
		for (int i = index; i < nums.length; i++) {
			int element = nums[i];
			swap(nums, i, index);
			findPermutations(nums, result, index + 1);
			swap(nums, i, index);
		}
	}
	public static void swap(int[] arr, int firstIdx, int secondIdx) {
		int temp = arr[firstIdx];
		arr[firstIdx] = arr[secondIdx];
		arr[secondIdx] = temp;
	}
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("../Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("../Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		int nums[] = new int[] {1, 2, 3};
		System.out.println(permute(nums));

	}
}