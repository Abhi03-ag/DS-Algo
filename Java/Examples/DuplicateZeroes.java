import java.util.*;
import java.lang.*;
import java.io.*;

public class DuplicateZeroes {
	public static void duplicateZeros(int[] arr) {
		int countZero = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) countZero++;
		}
		int len = arr.length + countZero;
		//We just need O(1) space if we scan from back
		//i point to the original array, j point to the new location
		for (int i = arr.length - 1, j = len - 1; i < j; i--, j--) {
			if (arr[i] != 0) {
				if (j < arr.length) {
					arr[j] = arr[i];
				}
			} else {
				if (j < arr.length) {
					arr[j] = arr[i];
				}
				j--;
				if (j < arr.length) {
					arr[j] = arr[i];
				}


			}
		}
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
		duplicateZeros(arr);
		System.out.println(Arrays.toString(arr));

	}
}