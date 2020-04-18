import java.util.LinkedList;

public class PondSizes {
  public static int dfs(int[][] field, int row, int column) {
    if (row < 0 || row >= field.length || column < 0 || column >= field[0].length) {
      return 0;
    }

    if (field[row][column] != 0) {
      return 0;
    }

    field[row][column] = -1;

    int result = 1;
    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        result += dfs(field, row + i, column + j);
      }
    }

    return result;
  }

  public static LinkedList<Integer> getSizes(int[][] field) {
    LinkedList<Integer> list = new LinkedList<Integer>();

    for (int i = 0; i < field.length; i++) {
      for (int j = 0; j < field[0].length; j++) {
        if (field[i][j] == -1 || field[i][j] > 0) continue;
        int pondSize = dfs(field, i, j);
        list.add(pondSize);
      }
    }

    return list;
  }

  public static void main(String[] args) {
    int[][] field = {
      { 0, 1, 2, 0 },
      { 0, 1, 0, 1 },
      { 1, 1, 0, 1 },
      { 0, 1, 0, 1 },
    };

    LinkedList<Integer> list = getSizes(field);

    // 2 4 1
    for (int size: list) {
      System.out.print(size + " ");
    }
    System.out.println();

  }
}
