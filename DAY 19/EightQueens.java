import java.util.ArrayList;

public class EightQueens {
  public static Boolean isGoodPlace(int row, int column, int[] rows) {
    for (int i = 1; i < row; i++) {
      if (rows[i] == column) return false;
      if (row - column == i - rows[i]) return false;
      if (row + column == i + rows[i]) return false;
    }
    return true;
  }

  public static void getWays(int row, int rows[], ArrayList<int[]> results) {
    for (int i = 1; i <= 8; i++) {
      if (isGoodPlace(row, i, rows)) {
        int[] newRows = rows.clone();
        newRows[row] = i;

        if (row == 8) {
          results.add(newRows);
        } else {
          getWays(row + 1, newRows, results);
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] rows = new int[9];
    ArrayList<int[]> results = new ArrayList<int[]>();
    getWays(1, rows, results);

    System.out.println("There are: " + results.size() + " possible ways to arrange 8 queens on the board:");
    for (int[] result: results) {
      for (int i: result) {
        if (i != 0) {
           System.out.print(i + "\t");
        }
      }
      System.out.println();
    }
    /*
      There are: 92 possible ways to arrange 8 queens on the board:
      1	5	8	6	3	7	2	4
      1	6	8	3	7	4	2	5
      1	7	4	6	8	2	5	3
      1	7	5	8	2	4	6	3
      2	4	6	8	3	1	7	5
      2	5	7	1	3	8	6	4
      2	5	7	4	1	8	6	3
      2	6	1	7	4	8	3	5
      2	6	8	3	1	4	7	5
      2	7	3	6	8	5	1	4
      2	7	5	8	1	4	6	3
      2	8	6	1	3	5	7	4
      3	1	7	5	8	2	4	6
      3	5	2	8	1	7	4	6
      3	5	2	8	6	4	7	1
      3	5	7	1	4	2	8	6
      3	5	8	4	1	7	2	6
      3	6	2	5	8	1	7	4
      3	6	2	7	1	4	8	5
      3	6	2	7	5	1	8	4
      3	6	4	1	8	5	7	2
      3	6	4	2	8	5	7	1
      3	6	8	1	4	7	5	2
      3	6	8	1	5	7	2	4
      3	6	8	2	4	1	7	5
      3	7	2	8	5	1	4	6
      3	7	2	8	6	4	1	5
      3	8	4	7	1	6	2	5
      4	1	5	8	2	7	3	6
      4	1	5	8	6	3	7	2
      4	2	5	8	6	1	3	7
      4	2	7	3	6	8	1	5
      4	2	7	3	6	8	5	1
      4	2	7	5	1	8	6	3
      4	2	8	5	7	1	3	6
      4	2	8	6	1	3	5	7
      4	6	1	5	2	8	3	7
      4	6	8	2	7	1	3	5
      4	6	8	3	1	7	5	2
      4	7	1	8	5	2	6	3
      4	7	3	8	2	5	1	6
      4	7	5	2	6	1	3	8
      4	7	5	3	1	6	8	2
      4	8	1	3	6	2	7	5
      4	8	1	5	7	2	6	3
      4	8	5	3	1	7	2	6
      5	1	4	6	8	2	7	3
      5	1	8	4	2	7	3	6
      5	1	8	6	3	7	2	4
      5	2	4	6	8	3	1	7
      5	2	4	7	3	8	6	1
      5	2	6	1	7	4	8	3
      5	2	8	1	4	7	3	6
      5	3	1	6	8	2	4	7
      5	3	1	7	2	8	6	4
      5	3	8	4	7	1	6	2
      5	7	1	3	8	6	4	2
      5	7	1	4	2	8	6	3
      5	7	2	4	8	1	3	6
      5	7	2	6	3	1	4	8
      5	7	2	6	3	1	8	4
      5	7	4	1	3	8	6	2
      5	8	4	1	3	6	2	7
      5	8	4	1	7	2	6	3
      6	1	5	2	8	3	7	4
      6	2	7	1	3	5	8	4
      6	2	7	1	4	8	5	3
      6	3	1	7	5	8	2	4
      6	3	1	8	4	2	7	5
      6	3	1	8	5	2	4	7
      6	3	5	7	1	4	2	8
      6	3	5	8	1	4	2	7
      6	3	7	2	4	8	1	5
      6	3	7	2	8	5	1	4
      6	3	7	4	1	8	2	5
      6	4	1	5	8	2	7	3
      6	4	2	8	5	7	1	3
      6	4	7	1	3	5	2	8
      6	4	7	1	8	2	5	3
      6	8	2	4	1	7	5	3
      7	1	3	8	6	4	2	5
      7	2	4	1	8	5	3	6
      7	2	6	3	1	4	8	5
      7	3	1	6	8	5	2	4
      7	3	8	2	5	1	6	4
      7	4	2	5	8	1	3	6
      7	4	2	8	6	1	3	5
      7	5	3	1	6	8	2	4
      8	2	4	1	7	5	3	6
      8	2	5	3	1	7	4	6
      8	3	1	6	2	5	7	4
      8	4	1	3	6	2	7	5
    */
  }
}
