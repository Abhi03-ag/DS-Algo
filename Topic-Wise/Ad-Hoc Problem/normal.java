import java.util.*;
import java.lang.*;
import java.io.*;

public class normal {
    public static int binarySearch(List<Integer> list, int index) {
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int element = list.get(mid);
            if (element <= index)
                start = mid + 1;
            else if (element > index)
                end = mid;
        }
        return start;

    }
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("../Input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("../Output.txt")));
        } catch (Exception e) {
            System.err.println("Error");
        }
        //System.out.println("a");
        Scanner sc = new Scanner(System.in);
        List<Integer> list = Arrays.asList(new Integer[] {0, 1, 2, 4, 6, 7, 9, 10, 15, 17, 20});
        System.out.println(binarySearch(list, 18));
    }
}