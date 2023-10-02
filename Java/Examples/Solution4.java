import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution4  {
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int counter = input / 2;
		int num = 1;
		for (int i = 0; i < input; i++) {
			if (i != 0 && i % 2 == 0 )
				counter--;
			for (int j = 1; j <= counter; j++) {
				if (i % 2 != 0 && j == counter)
					System.out.print("* ");
				else
					System.out.print("*" + num++);
			}

			System.out.println();
		}
	}
}