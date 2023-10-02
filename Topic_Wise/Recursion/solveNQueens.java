import java.util.*;
import java.lang.*;
import java.io.*;
/*
Problem Link: https://leetcode.com/problems/n-queens/description/
Time Complexity: O(N!) First queen has N options second queen has N-1 column options and subsequently others.
Space Complexity: O(N^2 * k) where k = no of possible answers.
*/
public class solveNQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		boolean[][] board = new boolean[n][n];
		solveNQueen(0, board, n, result, 0, 0, 0);
		return result;
	}

	public void solveNQueen(int row, boolean[][] board, int size, List<List<String>> result, int cols, int diag, int antiDiag) {
		if (row == size) {
			result.add(parseBoard(board, size));
			return;
		}

		for (int col = 0; col < size; col++) {
			int currDiag = row + col;
			int antiCurrDiag = (size - 1) + (col - row);
			//Pick a position
			if ((cols & (1 << col)) != 0 || (diag & (1 << currDiag)) != 0 || (antiDiag & (1 << antiCurrDiag)) != 0)
				continue;

			board[row][col] = true;
			solveNQueen(row + 1, board, size, result, cols | (1 << col), diag | (1 << currDiag), antiDiag | (1 << antiCurrDiag));
			board[row][col] = false;
		}
	}

	public boolean isValidPosition(int row, int col, boolean[][] board, int size) {
		//check for same row
		for (int i = 0; i < size; i++) {
			if (board[row][i] && i != col)
				return false;
		}

		//check for same col
		for (int i = 0; i < size; i++) {
			if (board[i][col] && i != row)
				return false;
		}

		//checking for the diagnol
		for (int i = 0; i < size; i++) {
			int diff = Math.abs(row - i);
			if (diff != 0) {
				int leftCol = col - diff;
				int rightCol = col + diff;
				if (leftCol >= 0 && leftCol < size && board[i][leftCol]) {
					return false;
				}
				if (rightCol >= 0 && rightCol < size && board[i][rightCol]) {
					return false;
				}
			}
		}
		return true;
	}
	public List<String> parseBoard(boolean[][] board, int size) {
		List<String> option = new ArrayList<>();
		for (int row = 0; row < size; row++) {
			StringBuilder temp = new StringBuilder();
			for (int col = 0; col < size; col++) {
				if (board[row][col]) {
					temp.append("Q");
				} else {
					temp.append(".");
				}
			}
			option.add(temp.toString());
		}
		return option;
	}
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("../Input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("../Output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);

	}
}