import java.util.*;
import java.lang.*;
import java.io.*;

public class  subsetSum {
	public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
		// code here
		ArrayList<Integer> result = new ArrayList<>();
		calculateSubsetSum(arr, N, 0, 0, result);
		return result;
	}
	public static void calculateSubsetSum(ArrayList<Integer> arr, int size, int sum, int currIdx, ArrayList<Integer> result) {

		int idx;
		for ( idx = currIdx; idx < size; idx++) {
			calculateSubsetSum(arr, size, sum + arr.get(idx), idx + 1, result);
		}
		if (idx >= size || currIdx >= size) {
			result.add(sum);

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
		int size = Integer.parseInt(sc.nextLine());
		int i = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (i < size) {
			list.add(sc.nextInt());
			i++;
		}
		System.out.println(subsetSums(list, size));
	}
}