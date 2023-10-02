import java.util.*;
class Spiral {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int size = sc.nextInt();
        int number = size * size;
        int maximumDigit = countDigit(number);
        int row_start = 0, col_start = 0;
        int row_end = size - 1, col_end = size - 1;
        int arr[][] = new int[size][size];
        while (row_start < row_end) {
            for (int i = col_start; i <= col_end; i++) {
                arr[row_start][i] = number;
                number--;
            }
            row_start++;
            for (int i = row_start; i <= row_end; i++) {
                arr[i][col_end] = number;
                number--;
            }
            col_end--;
            for (int i = col_end; i >= col_start; i--) {
                arr[row_end][i] = number;
                number--;
            }
            row_end--;
            for (int i = row_end; i >= row_start; i--) {
                arr[i][col_start] = number;
                number--;
            }
            col_start++;


        }
        if (size % 2 != 0)
            arr[size / 2][size / 2] = 1;
        printMatrix(arr, size);

    }
    public static int countDigit(int number) {
        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }
    public static void printMatrix(int[][] mat, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(mat[i][j] + "  ");

            }
            System.out.println();
        }
    }
}