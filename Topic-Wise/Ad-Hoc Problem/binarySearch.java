import java.util.*;
import java.lang.*;
import java.io.*;

public class binarySearch {
	public static int binarySearch(int[] row) {
		int low = 0;
		int high = row.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (row[mid] == 1) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("../Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("../Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		for (int num : set) {
			System.out.println(num);
		}
	}
}