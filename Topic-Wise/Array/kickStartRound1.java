import java.util.*;
import java.io.*;
class kickStartRound1 {
    static PrintWriter out = new PrintWriter((System.out));
    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public double nextDouble() {
            return Double.parseDouble(next());
        }
        public String nextLine() {
            try {
                return br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        public boolean hasNext() {
            String next = null;
            try {
                next = br.readLine();
            } catch (Exception e) {
            }
            if (next == null) {
                return false;
            }
            st = new StringTokenizer(next);
            return true;
        }
    }
    public static int findNoOfDeletions(String I, String P) {
        int result = -1;
        int i = 0, j = 0;
        int i_length = I.length();
        int p_length = P.length();
        int delCount = 0;
        while (i < i_length && j < p_length) {
            if (I.charAt(i) == P.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
                delCount++;
            }
        }

        if (i != i_length) {
            return result;
        } else {
            return delCount + p_length - j;
        }
    }
    public static void main(String args[]) throws IOException {

        FastReader sc = new FastReader();
        int testCases = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= testCases; i++) {

            String I, P;
            I = sc.nextLine();
            P = sc.nextLine();

            int res = findNoOfDeletions(I, P);
            out.print("Case #" + i + ": ");
            if (res != -1) {
                out.println(res);
            } else
                out.println("IMPOSSIBLE");
        }
        out.close();
    }
}