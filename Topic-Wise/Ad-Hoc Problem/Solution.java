import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
	public static int[] countKCombos(int arr[], int k) {
		int size = arr.length;
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		findCombos(arr, 0, k, 0, minHeap);
		int[] result = new int[k];
		int i = k - 1;
		while (minHeap.size() > 0) {
			result[i--] = minHeap.poll();
		}
		return result;
	}
	public static void findCombos(int[] arr, int index, int k, int sum, PriorityQueue<Integer> minHeap) {
		if (index == arr.length) {
			minHeap.offer(sum);
			if (minHeap.size() > k)
				minHeap.poll();
			return;
		}
		int element = arr[index];
		findCombos(arr, index + 1, k, sum + element, minHeap);
		findCombos(arr, index + 1, k, sum, minHeap);

	}
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("../Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("../Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.println(Arrays.toString(countKCombos(arr, k)));
	}
}