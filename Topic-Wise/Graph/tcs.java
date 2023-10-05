import java.util.*;
import java.lang.*;
import java.io.*;

public class  tcs {
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("../Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("../Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		int noOfElements = sc.nextInt();
		int arr[] = new int[noOfElements];
		for (int i = 0; i < noOfElements; i++) {
			arr[i] = sc.nextInt();
		}

		int new_arr[] =  new int[noOfElements];
		Arrays.sort(arr);
		int evenIndex = 0;
		int midIndex = noOfElements % 2 == 0 ? noOfElements / 2 : noOfElements / 2 + 1;
		int oddIndex = midIndex;
		int newIndex = 0;
		while (evenIndex < midIndex || oddIndex < noOfElements) {
			if (newIndex % 2 == 0) {
				new_arr[newIndex++] = arr[evenIndex++];
			} else
				new_arr[newIndex++] = arr[oddIndex++];
		}
		System.out.println(Arrays.toString(new_arr));
	}
}