import java.util.*;
import java.lang.*;
import java.io.*;

public class NonDecreasingArray {
	public static void minOperations(int[] arr, int size) {
		int start_index = -1; int end_index = -1;
		int max = 0;
		for (int i = 1; i < size; i++) {
			System.out.println("End " + end_index + "Start " + start_index + "max " + max);
			if (arr[i] >= arr[i - 1]) {
				if (start_index == -1)
					start_index = i - 1;
				end_index = i;
			} else {
				max = Math.max(max, end_index - start_index + 1);
				start_index = -1;
				end_index = -1;

			}
		}
		max = Math.max(max, end_index - start_index + 1);
		System.out.println(max);
	}
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int arr[]  = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] =  sc.nextInt();
		}
		minOperations(arr, size);

	}
}