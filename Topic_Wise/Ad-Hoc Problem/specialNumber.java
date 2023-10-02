import java.util.*;
import java.lang.*;
import java.io.*;

public class specialNumber {
	public static List<Integer> getSpecialNumber(int number) {
		List<Integer> result = new ArrayList<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 1; i <= 9; i++) {
			queue.offer(i);
		}
		int specialNumber, lastDigit, newNumber1 = -1, newNumber2 = -1;

		while (!queue.isEmpty()) {
			specialNumber = queue.poll();
			result.add(specialNumber);
			lastDigit = specialNumber % 10;
			if (lastDigit > 0)
				newNumber1 = specialNumber * 10 + lastDigit - 1;
			if (lastDigit < 9)
				newNumber2 = specialNumber * 10 + lastDigit + 1;
			if (newNumber1 > 0 && newNumber1 <= number)
				queue.offer(newNumber1);
			if (newNumber2 > 0 && newNumber2 <= number)
				queue.offer(newNumber2);
			newNumber1 = -1;
			newNumber2 = -1;
		}
		return result;

	}
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("../Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("../Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello" + 12 + 5 + "gg");
		int number = sc.nextInt();
		System.out.println(getSpecialNumber(number));
	}
}