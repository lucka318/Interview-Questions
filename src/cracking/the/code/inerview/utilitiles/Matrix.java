package cracking.the.code.inerview.utilitiles;

import java.util.Random;

public class Matrix {

	private int size;
	private int[][] matrix;

	public Matrix(int size) {
		this.size = size;
		this.matrix = generateRandomMatrix(size);
	}

	private int[][] generateRandomMatrix(int size) {
		Random generator = new Random();
		int[][] randomMatrix = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				randomMatrix[i][j] = generator.nextInt();
			}
		}
		return randomMatrix;
	}

}