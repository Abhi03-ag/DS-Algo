import java.util.*;
import java.lang.*;
import java.io.*;

public class PalinString  {
	public static long modulo = 1000000007;
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		int No_Of_TestCases =  sc.nextInt();
		while (No_Of_TestCases-- > 0) {
			int length = sc.nextInt();
			int No_Of_Letters =  sc.nextInt();
			sc.nextLine();
			String input = sc.nextLine();


		}
	}
}