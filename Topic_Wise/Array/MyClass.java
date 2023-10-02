import java.util.*;
import java.lang.*;
import java.io.*;

public class MyClass {
	public static void fillPrimeList(int n, List<Integer> primeList) {
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);
		for (int i = 2; i * i <= n; i++) {
			if (prime[i]) {
				for (int j = i * i; j <= n; j += i) {
					prime[j] = false;
				}
			}
		}
		for (int i = 2; i <= n; i++) {
			if (prime[i]) {
				primeList.add(i);
			}
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
		int size = sc.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		int count = 0;
		List<Integer> list = new ArrayList<Integer>();
		fillPrimeList(10000, list);
		for (int i = 0; i < size; i++) {
			int element = arr[i];
			int primeCount = 0;
			for (int prime : list) {
				if (prime > element)
					break;
				if (element % prime == 0)
					primeCount++;
			}
			if (primeCount == k)
				count++;
		}
		System.out.println(count);
	}
}