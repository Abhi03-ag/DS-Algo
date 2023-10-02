import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
	static void diwaliParty(int[] arr) {
		int freq_arr[] = new int[5];
		for (int i = 0; i < arr.length; i++) {
			freq_arr[arr[i] - 1]++;
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i <= 4; i++) {
			boolean isEven = (freq_arr[i] % 2 == 0);
			int count = freq_arr[i] / 2;
			while (count > 0) {
				ans.add(i + 1);
				count--;
			}
			if (!isEven) {
				freq_arr[i] = 1;
			} else {
				freq_arr[i] = 0;
			}
		}
		ArrayList<Integer> unique = new ArrayList<Integer>();
		for (int i = 0; i <= 4; i++) {
			if (freq_arr[i] == 1) {
				unique.add(i + 1);
			}
		}
		int middle  =  ans.size() / 2;

		for (int i = 0; i <= middle; i++) {
			System.out.print(ans.get(i) + " ");
		}
		for (int i = 0; i < unique.size(); i++) {
			System.out.print(unique.get(i) + " ");
		}
		for (int i = middle + 1; i < ans.size(); i++)
			System.out.print(ans.get(i) + " ");

		System.out.println();

	}

	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		while (test_case-- > 0) {
			int size = sc.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
			diwaliParty(arr);

		}

	}
}