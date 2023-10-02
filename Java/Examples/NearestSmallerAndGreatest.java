import java.util.*;
import java.lang.*;
import java.io.*;

public class NearestSmallerAndGreatest {
	public static void calculateNearestSmallerAndGreatestElement(int[] arr, int size) {
		int result[] = new int[size];
		int nearest_smaller, nearest_greater;
		int left_pointer, right_pointer;
		for (int i = 0; i < size; i++) {
			nearest_smaller = 0;
			nearest_greater = Integer.MAX_VALUE;
			left_pointer = 0;
			right_pointer = size - 1;;
			while (left_pointer < i) {
				if (arr[left_pointer] < arr[i] && arr[left_pointer] > nearest_smaller) {
					nearest_smaller = arr[left_pointer];
				}
				if (arr[left_pointer] > arr[i] && arr[left_pointer] < nearest_greater)
					nearest_greater = arr[left_pointer];
				left_pointer++;
			}

			while (right_pointer > i) {
				if (arr[right_pointer] < arr[i] && arr[right_pointer] > nearest_smaller) {
					nearest_smaller = arr[right_pointer];
				}
				if (arr[right_pointer] > arr[i] && arr[right_pointer] < nearest_greater)
					nearest_greater = arr[right_pointer];
				right_pointer--;
			}
			if (nearest_greater == Integer.MAX_VALUE) {
				nearest_greater = 0;
			}
			result[i] = nearest_greater + nearest_smaller;


		}
		System.out.println(Arrays.toString(result));
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
		calculateNearestSmallerAndGreatestElement(arr, size);

	}
}