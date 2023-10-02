import java.util.*;
import java.lang.*;
import java.io.*;

public class IndusNet {
	public static int calculateDivisor(String input1, String input2) {
		int len_input2 = input2.length();
		int len_input1 = input1.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i * len_input1 <= len_input2; i++) {
			sb.append(input1);
		}
		if (!sb.toString().equals(input2))
			return -1;
		else {
			//int divisibality = 1;
			for (int i = 1; i <= len_input1; i++) {
				if (len_input1 % i != 0) {
					continue;
				} else {
					sb = new StringBuilder();
					String sub = input1.substring(0, i);
					while (sb.length() < len_input1)
						sb.append(sub);
					if (sb.toString().equals(input1))
						return i;
				}
			}

		}
		return -1;

	}
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		String input1 = sc.nextLine();
		String input2 = sc.nextLine();
		System.out.println(calculateDivisor(input1, input2));


	}
}