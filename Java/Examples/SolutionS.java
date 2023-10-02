import java.math.*;
public class SolutionS {
    public static int compareVersion(String A, String B) {
        int i = 0, j = 0;
        while (i < A.length() && j < B.length()) {
            int k = i;
            while (k < A.length() && A.charAt(k) != '.') {
                k++;
            }

            String A_SUB = A.substring(i, k);
            System.out.println(i + "  " + k);
            i = k + 1;
            int l = j;
            while (l < B.length() && B.charAt(l) != '.') {
                l++;
            }

            String B_SUB = B.substring(j, l);
            System.out.println(j + "  " + l);
            j = l + 1;
            BigInteger A_num  = new BigInteger(A_SUB);
            BigInteger B_num = new BigInteger(B_SUB);
            if (A_num.compareTo(B_num) != 0)
                return A_num.compareTo(B_num);
        }
        if (i < A.length())
            return 1;
        else if (j < B.length())
            return -1;
        return 0;

    }
    public static void main(String args[]) {
        System.out.print(compareVersion("13.0", "13.0.8"));
    }
}
