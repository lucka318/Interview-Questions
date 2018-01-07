package career.cup;

public class MatrixInSpiral {

	public static void main(String[] args) {

		int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 },
				{ 13, 14, 15, 16, 17, 18 } };

		printMatrixInSpiralForm(a);
	}

	public static void printMatrixInSpiralForm(int[][] matrix) {

		int row_begin = 0;
		int column_begin = 0;

		int row_end = matrix.length - 1;
		int column_end = matrix[0].length - 1;

		int layer = 2;
		while (layer > 0) {

			if (row_end >= row_begin) {
				for (int i = column_begin; i <= column_end; i++) {
					System.out.print(matrix[row_begin][i] + " ");
				}
				row_begin++;
			}
			if (column_begin <= column_end) {
				for (int i = row_begin; i <= row_end; i++) {
					System.out.print(matrix[i][column_end] + " ");
				}
				column_end--;
			}
			if (row_end >= row_begin) {
				for (int i = column_end; i >= column_begin; i--) {
					System.out.print(matrix[row_end][i] + " ");
				}
				row_end--;
			}
			if (column_begin <= column_end) {
				for (int i = row_end; i >= row_begin; i--) {
					System.out.print(matrix[i][column_begin] + " ");
				}
				column_begin++;
			}
			layer--;
		}

	}

}
