import java.util.*;
import java.lang.*;
import java.io.*;

public class atherTest {
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("../Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("../Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		int totalBoxes = sc.nextInt();
		int totalQuery = sc.nextInt();

		int movedFrom[] = new int[totalQuery];
		int movedTO[] = new int[totalQuery];
		for (int i = 0; i < totalQuery; i++) {
			movedFrom[i] = sc.nextInt();
			movedTO[i] = sc.nextInt();
		}

		Set<Integer> currentPossibleBoxes = new HashSet<Integer>();
		currentPossibleBoxes.add(1);
		int[] size = new int[totalBoxes + 1];
		Arrays.fill(size, 1);

		int a, b;
		for (int i = 0; i < totalQuery; i++) {
			a = movedFrom[i];
			b = movedTO[i];
			if (currentPossibleBoxes.contains(a)) {
				size[a]--;
				if (size[a] == 0)
					currentPossibleBoxes.remove(a);
				currentPossibleBoxes.add(b);
				size[b]++;
			}
		}

		System.out.println(currentPossibleBoxes.size());


	}
}