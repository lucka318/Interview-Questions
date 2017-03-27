package cracking.the.code.interview.arrays_and_strings;

import java.util.Scanner;

import cracking.the.code.inerview.utilitiles.Matrix;

/**
 * If an element in a matrix is 0, set entire row and column to 0.
 * 
 * @author Lucija Megla
 *
 */
public class Question1_8 {

	/**
	 * Memory O(n), Time O(n^2)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out
				.println("Please enter matrix size. Random matrix will be generated.");
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		scan.close();
		Matrix matrix = new Matrix(size);
		System.out.println(matrix.toString());

		int[][] matrixArr = matrix.getMatrix();

		zeroMatrix(matrixArr, size); // inplace

		System.out.println(matrix.toString());

	}

	private static void zeroMatrix(int[][] matrixArr, int size) {
		boolean[] flagRows = new boolean[size];
		boolean[] flagColumns = new boolean[size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (matrixArr[i][j] == 0) {
					flagRows[i] = true;
					flagColumns[j] = true;
				}
			}
		}

		for (int i = 0; i < size; i++) {
			if (flagRows[i]) {
				setRowToZero(matrixArr, i, size);
			}
		}

		for (int j = 0; j < size; j++) {
			if (flagColumns[j]) {
				setColumnToZero(matrixArr, j, size);
			}
		}

	}

	private static void setColumnToZero(int[][] matrixArr, int j, int size) {
		for (int i = 0; i < size; i++) {
			matrixArr[i][j] = 0;
		}
	}

	private static void setRowToZero(int[][] matrixArr, int i, int size) {
		for (int j = 0; j < size; j++) {
			matrixArr[i][j] = 0;
		}
	}
}
