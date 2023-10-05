import java.util.*;
import java.lang.*;
import java.io.*;

public class raceTrack {
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("../Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("../Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		String input[] = sc.nextLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		List<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < m; i++) {
			input = sc.nextLine().split(" ");
			list.add(new int[] {input[0], input[1]});
		}
		boolean
		Collections.sort()
	}
}