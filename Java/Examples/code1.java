import java.util.*;
import java.lang.*;
import java.io.*;

public class code1 {
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println("The output is:" + s);
	}
}