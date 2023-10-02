import java.util.*;
import java.lang.*;
import java.io.*;

public class  Accenture {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the set");
		int size = sc.nextInt();
		System.out.println("Enter the number");
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (size-- > 0) {
			list.add(new Integer(sc.nextInt()));
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Integer i : list) {
			Integer j = map.get(i);
			map.put(i, (j == null) ? 1 : j + 1);
		}
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		for (Map.Entry<Integer, Integer> val : map.entrySet()) {
			if (val.getValue() == 1) {
				list1.add(-1 * val.getKey());
			} else {
				list1.add(val.getValue() * val.getKey());
			}
		}
		int sum = 0;
		for (int i : list1) {
			sum -= i;
		}
		System.out.println(sum);
	}
}