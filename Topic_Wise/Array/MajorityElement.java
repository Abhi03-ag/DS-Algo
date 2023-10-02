import java.util.*;
import java.lang.*;
import java.io.*;

public class MajorityElement {
	public static List<Integer> getMajorityElementList(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		if (nums == null || nums.length == 0)
			return list;
		int majorityElement1, majorityElement2, majorityElement3;
		int count1, count2, count3;
		count1 = count2 = count3 = 0;
		majorityElement1 = nums[0];
		majorityElement2 = nums[0];
		majorityElement3 = nums[0];

		for (int i = 0; i < nums.length; i++) {
			int element = nums[i];
			if (element == majorityElement1) {
				count1++;
			} else if (element == majorityElement2) {
				count2++;
			} else if (element == majorityElement3) {
				count3++;
			} else if (count1 == 0) {
				majorityElement1 = element;
				count1++;
			} else if (count2 == 0) {
				majorityElement2 = element;
				count2++;
			} else if (count3 == 0) {
				majorityElement3 = element;
				count3++;
			} else {
				count1--;
				count2--;
				count3--;
			}
		}
		//Again make their counts zero
		count1 = count2 = count3 = 0;
		for (int i = 0; i < nums.length; i++) {
			int element = nums[i];
			if (element == majorityElement1)
				count1++;
			else if (element == majorityElement2)
				count2++;
			else if (element == majorityElement3)
				count3++;
		}
		if (count1 > nums.length / 4)
			list.add(majorityElement1);
		if (count2 > nums.length / 4)
			list.add(majorityElement2);
		if (count3 > nums.length / 4)
			list.add(majorityElement3);

		return list;

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
		int arr[] = new int[100000000];
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		List<Integer> list = getMajorityElementList(arr);
		System.out.println(list);
	}
}