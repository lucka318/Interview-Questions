package cracking.the.code.interview.arrays_and_strings;

import java.util.Scanner;

import cracking.the.code.interview.utilities.Matrix;

/**
 * Rotate matrix
 * 
 * @author Lucija Megla
 *
 */
public class Question1_7 {
	/**
	 * In the problem, we see that each pixel needs 4 bytes, that means that we
	 * should use an integer matrix, so we could store each pixel in an element
	 * in matrix. The best way is to perform swaps layer-wise. Each matrix NxN
	 * matrix has N/2 layers.
	 * 
	 * If we are doing layer-wise swaps, we need to determine 'beginning' and
	 * 'ending' of each layer (first and last in method rotateMatrix).
	 * 
	 * When we rotate elements in one layer, we need to keep track of offset
	 * which shows us what elements we are swaping.
	 * 
	 * Memory: O(1), time: O(n^2), because we need to iterate over all matrix
	 * elements.
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

		rotateMatrix(matrixArr, size); // inplace swap

		System.out.println(matrix.toString());

	}

	private static void rotateMatrix(int[][] matrixArr, int size) {

		for (int layer = 0; layer < size / 2; layer++) {
			int first = layer;
			int last = size - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;

				int temp = matrixArr[first][i];
				matrixArr[first][i] = matrixArr[last - offset][first];
				matrixArr[last - offset][first] = matrixArr[last][last - offset];
				matrixArr[last][last - offset] = matrixArr[i][last];
				matrixArr[i][last] = temp;
			}
		}
	}

}
