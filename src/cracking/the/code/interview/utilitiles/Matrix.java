package cracking.the.code.interview.utilitiles;

import java.util.Random;

public class Matrix {

	private static final int min = 0;
	private static final int max = 50;
	private int size;
	private int[][] matrix;

	public Matrix(int size) {
		this.size = size;
		this.matrix = generateRandomMatrix(size);
	}

	public Matrix(int[][] matrix, int size) {
		this.size = size;
		this.matrix = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.matrix[i][j] = matrix[i][j];
			}
		}
	}

	private int[][] generateRandomMatrix(int size) {
		Random rand = new Random();
		int[][] randomMatrix = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				randomMatrix[i][j] = rand.nextInt((max - min) + 1) + min;
			}
		}
		return randomMatrix;
	}

	public int getSize() {
		return size;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public int getElement(int i, int j) {
		checkIndices(i, j);
		return matrix[i][j];
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sb.append(matrix[i][j]);
				sb.append(" ");
			}
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}

	private void checkIndices(int i, int j) {
		if (i < 0 || i >= size || j < 0 || j >= size) {
			throw new IllegalArgumentException("Wrong indices");
		}
	}

}
