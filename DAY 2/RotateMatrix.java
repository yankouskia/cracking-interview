/*
  The image is represented by matrix, where all elements are 4 bytes values
  We are going to work with 2-dimensional array with integer values
*/

public class RotateMatrix {
  public static int[][] rotateMatrix(int[][] matrix) {
    int matrixLength = matrix.length;

    for (int i = 0; i < matrixLength / 2; i++) {
      for (int j = 0; j < (matrixLength + 1) / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[matrixLength - j - 1][i];
        matrix[matrixLength - j - 1][i] = matrix[matrixLength - i - 1][matrixLength - j - 1];
        matrix[matrixLength - i - 1][matrixLength - j - 1] = matrix[j][matrixLength - i - 1];
        matrix[j][matrixLength - i - 1] = temp;
      }
    }

    return matrix;
  }

  public static void printMatrix(int[][] matrix) {
    for (int[] row: matrix) {
      for (int value: row) {
        System.out.print(value + "\t");
      }
      System.out.print("\n");
    }
  }

  public static void main(String[] args) {
    int MATRIX_SIZE_ODD = 5;
    int MATRIX_SIZE_EVEN = 6;

    int[][] testMatrixOdd = new int[MATRIX_SIZE_ODD][MATRIX_SIZE_ODD];
    int[][] testMatrixEven = new int[MATRIX_SIZE_EVEN][MATRIX_SIZE_EVEN];

    for (int i = 0; i < MATRIX_SIZE_ODD; i++) {
      for (int j = 0; j < MATRIX_SIZE_ODD; j++) {
        testMatrixOdd[i][j] = i * MATRIX_SIZE_ODD + j + 1;
      }
    }

    for (int i = 0; i < MATRIX_SIZE_EVEN; i++) {
      for (int j = 0; j < MATRIX_SIZE_EVEN; j++) {
        testMatrixEven[i][j] = i * MATRIX_SIZE_EVEN + j + 1;
      }
    }

    /*
      1   2   3   4   5
      6   7   8   9   10
      11	12	13	14	15
      16	17	18	19	20
      21	22	23	24	25
      -------------------
      21	16	11	6	  1
      22	17	12	7	  2
      23	18	13	8	  3
      24	19	14	9	  4
      25	20	15	10	5
    */
    printMatrix(testMatrixOdd);
    System.out.println("-------------------");
    printMatrix(rotateMatrix(testMatrixOdd));

    System.out.println("////////////////////////////////////////////////");

    /*
      1   2   3   4   5   6
      7   8   9	  10	11	12
      13	14	15	16	17	18
      19	20	21	22	23	24
      25	26	27	28	29	30
      31	32	33	34	35	36
      -----------------------
      31	25	19	13	7	  1
      32	26	20	14	8	  2
      33	27	21	15	9	  3
      34	28	22	16	10	4
      35	29	23	17	11	5
      36	30	24	18	12	6
    */
    printMatrix(testMatrixEven);
    System.out.println("-----------------------");
    printMatrix(rotateMatrix(testMatrixEven));
  }
}
