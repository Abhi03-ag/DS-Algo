import java.util.*;
import java.lang.*;
import java.io.*;

public class  RotateArray {
	public static void reverse(int arr[], int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
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
		int arr[][] = new int[][] {{1, 2}, {1, 2}, {1, 4}};
		System.out.println(Arrays.deepToString(arr));

	}
}