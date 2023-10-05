import java.util.*;
import java.lang.*;
import java.io.*;
/*
	Problem Link :- https://leetcode.com/problems/combination-sum/description/

	Input : {2,3,6,7}
	Target : 7
	Output : {2,2,3},{7}

	2		3		6		7

	2^t1	2^t2	2^t3	2^t4 where t1 = target/candidate[index]
	for a particular candidate we can at max include it for target/candidate times that means we have two choices of either picking that element or not that many times.
	so for each element we have
	maximum no of combination are 2^t( where t = t1+t2+t3..+tn (ti = target/candidate[i]))
	If we are restricted to include the element at max once then t.c. would be 2^n;

	Time Complexity :- O(2^t * K) where K is the average length of all the combination.
	Space Complexity :- O(k*x) where k is the average length of all combinations and x is the number of combinations, space for final List
	Auxiallary Space/Stack Space = O(size of the longest combination) which is also equal to the maximum size of curr List.
*/
public class  combinationSum {
	public void combinationSumPickNonPickConcept(int[] candidates, int target, int currIdx, List<Integer> currList, List<List<Integer>> finalList) {
		if (target == 0) {
			finalList.add(new ArrayList<>(currList)); // It's not a constant operation depends upon the size of current combination
			return;
		}
		if (currIdx >= candidates.length) {
			return;
		}
		int currCandidate = candidates[currIdx];
		//Pick Condition
		if (currCandidate <= target) {
			currList.add(currCandidate);
			combinationSumPickNonPickConcept(candidates, target - currCandidate, currIdx, currList, finalList);
			//remove the lastly added candidate
			currList.remove(currList.size() - 1);
		}
		//Non-Pick Condition
		combinationSumPickNonPickConcept(candidates, target, currIdx + 1, currList, finalList);

	}
	public void combinationSumNOptionsAtEachLevelTechnique(int[] candidates, int target, int currIdx, List<Integer> currList, List<List<Integer>> finalList) {
		if (target == 0) {
			finalList.add(new ArrayList<>(currList));
			return;
		}

		for (int idx = currIdx; idx < candidates.length; idx++) {
			int currCandidate = candidates[idx];
			if (currCandidate <= target) {
				currList.add(currCandidate);
				combinationSumNOptionsAtEachLevelTechnique(candidates, target - currCandidate, idx, currList, finalList);
				currList.remove(currList.size() - 1);
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

	}
}