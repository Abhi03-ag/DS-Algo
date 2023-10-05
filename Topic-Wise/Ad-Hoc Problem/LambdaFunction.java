import java.util.*;
import java.lang.*;
import java.io.*;

public class  LambdaFunction {
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("../Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("../Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();

		list.add(-1);
		list.add(Integer.MAX_VALUE);
		//list.add(7);
		int bd = -1;
		int add = Integer.MAX_VALUE - bd;
		System.out.println(add);

		Collections.sort(list, (a, b)-> {
			return Integer.compare(a, b);
		});
		System.out.println(list);
	}
}