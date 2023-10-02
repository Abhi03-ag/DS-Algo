import java.util.*;
import java.lang.*;
import java.io.*;

public class AmazonOA {
	public static void getMinimumCost(int k, int[] arr) {
		int cost[] = new int[arr.length];
		for (int i = 1; i < arr.length; i++) {
			int difference = Math.abs(arr[i] - arr[i - 1]);
			cost[i] = cost[i - 1] + difference;
		}
		System.out.println(Arrays.toString(cost));
		int minCost = Integer.MAX_VALUE;
		int start = -1;
		int leftCost = 0;
		int rightCost = 0;
		int currentCost = 0;
		for (int i = 0; i <= arr.length - k; i++) {
			leftCost = i > 0 ? cost[i - 1] : 0;
			rightCost = (i == (arr.length - k)) ? 0 : (cost[arr.length - 1] - cost[i + k]);
			currentCost = (i > 0 && i < arr.length - k) ? Math.abs(arr[i - 1] - arr[i + k]) : 0;
			if (leftCost + rightCost + currentCost < minCost) {
				start = i;
				minCost = leftCost + rightCost + currentCost;
			}
		}
		System.out.println(start);


	}
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("../Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("../Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		getMinimumCost(k, arr);
	}
}