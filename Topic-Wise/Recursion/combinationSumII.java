import java.util.*;
import java.lang.*;
import java.io.*;
/*
	Problem Link: https://leetcode.com/problems/combination-sum-ii/description/

	Input: candidates = [10,1,2,7,6,1,5], target = 8
	Output: [[1,1,6],[1,2,5],[1,7],[2,6]]

	Time Complexity : - O(2^N*N) In worst case it will exhaust all possible combinations for each combination adding the current combination to final list would cost of O(N).
	Space Complexity :  O(2^N * K) space for final List for average length of k for all 2^N combinations, O(N) for combination List, O(N) for recursion stack space so in total

*/

public class  combinationSumII {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> finalList = new ArrayList<>();
		Arrays.sort(candidates);
		findUniqueCombinations(candidates, target, 0, new ArrayList<>(), finalList);
		return finalList;
	}
	public void findUniqueCombinations(int[] candidates, int target, int currIdx, List<Integer> currList, List<List<Integer>> finalList) {
		if (target == 0) {
			if (!finalList.contains(currList)) {
				finalList.add(new ArrayList<>(currList));
			}
			return;
		}

		for (int idx = currIdx; idx < candidates.length; idx++) {
			int candidate = candidates[idx];
			//Using this to make sure at a current level only first occurence of a duplicate number is allowed only and rest are skipped.
			if (idx > currIdx && candidate == candidates[idx - 1])
				continue;
			/*
				Alternatively we could have used boolean visited array to check for a single number at a current level and all other are not included in that.
				if(!Visited[candidate])
				{
					visited[candidate] = true;
					thus at each level only the first occurence of duplicate number would be allowed.
				}
			*/
			if (candidate <= target) {
				currList.add(candidate);
				findUniqueCombinations(candidates, target - candidate, idx + 1, currList, finalList);
				currList.remove(currList.size() - 1);

			} else {
				//Saving from unfruitful iteration because the array is sorted and remaining all the elements won't be considered.
				break;
			}
		}

	}
	public static void findUniqueCombinationsUsingPickAndNonPickConcept(int[] candidates, int target, int currIdx, List<Integer> currList, List<List<Integer>> finalList) {

		if (target == 0) {
			finalList.add(new ArrayList<>(currList));
			return;
		}

		if (currIdx >= candidates.length)
			return;

		int candidate = candidates[currIdx];
		if (candidate <= target) {
			currList.add(candidate);
			findUniqueCombinations(candidates, target - candidate, currIdx + 1, currList, finalList);
			currList.remove(currList.size() - 1);
		} else {
			//Saving from unfruitful recursion because the array is sorted and remaining all the elements won't be considered.
			return;
		}
		//Skipping all the duplicates at this level to not get pick

		while (currIdx + 1 < candidates.length && candidates[currIdx + 1] == candidate)
			currIdx++;
		findUniqueCombinations(candidates, target, currIdx + 1, currList, finalList);
	}

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("../Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("../Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		int[] candidates = {};
		System.out.println(combinationSum2(candidates, target));
	}
}