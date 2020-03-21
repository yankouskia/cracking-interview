public class ZeroMatrix {
  public static void nullifyRow(int[][] matrix, int i) {
    for (int j = 0; j < matrix[0].length; j++) {
      matrix[i][j] = 0;
    }
  }

  public static void nullifyColumn(int[][] matrix, int j) {
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][j] = 0;
    }
  }

  public static int[][] zeroMatrix(int[][] matrix) {
    /*
      check if first column and row has already zeros
      and will use them to store information about other columns / row
      which contains 0
    */
    boolean isColumnWithZero = false;
    boolean isRowWithZero = false;

    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        isColumnWithZero = true;
        break;
      }
    }

    for (int j = 0; j < matrix[0].length; j++) {
      if (matrix[0][j] == 0) {
        isRowWithZero = true;
        break;
      }
    }

    // store in first row and column potential zero-values rows / columns
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    // nullify rows / columns based on first row / column
    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        nullifyRow(matrix, i);
      }
    }

    for (int j = 0; j < matrix[0].length; j++) {
      if (matrix[0][j] == 0) {
        nullifyColumn(matrix, j);
      }
    }

    // if initially in first row / column were zeros - nullify them as well
    if (isColumnWithZero) {
      nullifyColumn(matrix, 0);
    }

    if (isRowWithZero) {
      nullifyRow(matrix, 0);
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
    System.out.println("--------------------------------------");
  }

  public static void main(String[] args) {
    int MATRIX_SIZE = 5;
    int[][] testMatrix = new int[MATRIX_SIZE][MATRIX_SIZE];

    for (int i = 0; i < MATRIX_SIZE; i++) {
      for (int j = 0; j < MATRIX_SIZE; j++) {
        testMatrix[i][j] = i * MATRIX_SIZE + j + 1;
      }
    }

    // test matrix with 2 zeros
    testMatrix[0][2] = 0;
    testMatrix[2][2] = 0;

    /*
      1   2   0   4   5
      6   7   8   9   10
      11	12	0	  14	15
      16	17	18	19	20
      21	22	23	24	25
      --------------------------------------
      0   0   0   0   0
      6   7   0   9   10
      0   0   0   0   0
      16	17	0	  19	20
      21	22	0  	24	25
    */
    printMatrix(testMatrix);
    printMatrix(zeroMatrix(testMatrix));

    // Complexity - O(n ^ 2)
  }
}
