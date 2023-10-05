import java.util.*;
import java.lang.*;
import java.io.*;

public class RecursionBasics {
	public static int calculateSumOfNaturalNumbers(int input) {
		//TC-O(n)
		//SC-O(n)
		if (input < 1)
			return 0;

		return input + calculateSumOfNaturalNumbers(input - 1);
	}
	public static void reverseArray(int[] arr, int start, int size) {
		//TC - O(n/2)
		//SC - O(n/2): Recursion Stack Space
		if (start >= (size) / 2)
			return;
		arr[start] ^= arr[size - 1 - start];
		arr[size - 1 - start] ^= arr[start];
		arr[start] ^= arr[size - 1 - start];
		reverseArray(arr, start + 1, size);
	}
	public static void printName(int count) {
		//TC-O(n)
		//SC-O(n): Recursion Stack Space
		if (count < 1)
			return;
		System.out.println("Abhi");
		printName(count - 1);
	}
	public static void printNaturalNumbers(int input) {
		//TC-O(n)
		//SC-O(n)
		if (input < 1)
			return;
		printNaturalNumbers(input - 1);
		System.out.println(input);
	}
	public static boolean checkPalindrome(String input, int start) {
		//TC - O(n/2)
		//SC - O(n/2)
		int len = input.length();
		if (start >= (len / 2))
			return true;
		if (input.charAt(start) != input.charAt(len - 1 - start))
			return false;
		return checkPalindrome(input, start + 1);
	}
	public static int fibonacciNumbers(int term) {
		//TC - O(2^n)
		//SC - O(n) As the maximum depth of tree is n
		if (term <= 1)
			return term;
		return fibonacciNumbers(term - 1) + fibonacciNumbers(term - 2);
	}
	public static double power(double x, int pow) {
		//TC-O(log power)
		//SC-O(log powe)
		if (pow == 0)
			return 1;
		if (pow % 2 == 1)
			return x * power(x * x, pow / 2);
		return power(x * x, pow / 2);
	}
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("../Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("../Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		int base = sc.nextInt();
		int pow = sc.nextInt();
		System.out.println(power(base, pow));

	}
}
