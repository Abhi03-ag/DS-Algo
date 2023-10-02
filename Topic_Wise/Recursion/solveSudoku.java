import java.util.*;
import java.lang.*;
import java.io.*;

/*
Problem Link: https://leetcode.com/problems/sudoku-solver/description/
Time Complexity: O(N!)^N (For arranging N in single row it will take N! ways we have to do it for N such rows.)
Space Complexity: O(N^2)
*/
public class solveSudoku {
	public void solveSudoku(char[][] board) {
		List<List<Integer>> emptyPositions = new ArrayList<>();
		findEmptyPositions(board, emptyPositions);
		//System.out.println(emptyPositions);
		findSudokuSolution(board, 0, emptyPositions);

	}
	public boolean findSudokuSolution(char[][] board, int posIdx, List<List<Integer>> emptyPositions) {
		if (posIdx == emptyPositions.size()) {
			// System.out.println(Arrays.deepToString(board));
			return true;
		}
		int row = emptyPositions.get(posIdx).get(0);
		int col = emptyPositions.get(posIdx).get(1);
		for (int element = 1; element < 10; element++) {
			char ele = (char)(element + 48);
			if (isValid(board, row, col, ele)) {
				board[row][col] = ele;
				if (findSudokuSolution(board, posIdx + 1, emptyPositions))
					return true;
				board[row][col] = '.';
			}
		}
		return false;
	}
	public boolean isValid(char[][] board, int row, int col, char element) {
		for (int i = 0; i < board.length; i++) {
			if (board[row][i] == element)
				return false;
			if (board[i][col] == element)
				return false;
			if (board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] == element)
				return false;
		}
		return true;
	}
	public void findEmptyPositions(char[][] board, List<List<Integer>> emptyPositions) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				if (board[row][col] == '.') {
					emptyPositions.add(Arrays.asList(row, col));
				}
			}
		}
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