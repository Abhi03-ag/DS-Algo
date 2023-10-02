import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int number = sc.nextInt();
		int maxnum = 0;
		int i = 1;
		while (number / i > 0) {
			int newnum = (number / (i * 10)) * i + number % i;
			i *= 10;
			if (maxnum < newnum)
				maxnum = newnum;
		}
		System.out.println(maxnum);
	}
}