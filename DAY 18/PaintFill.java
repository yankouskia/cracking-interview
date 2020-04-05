
public class PaintFill {
  public static void paintFill(int[][] screen, int row, int column, int color, int oldColor) {
    if (row < 0 || row >= screen.length || column < 0 || column >= screen[0].length) {
      return;
    }

    if (screen[row][column] == oldColor) {
      screen[row][column] = color;

      paintFill(screen, row, column - 1, color, oldColor);
      paintFill(screen, row, column + 1, color, oldColor);
      paintFill(screen, row - 1, column, color, oldColor);
      paintFill(screen, row + 1, column, color, oldColor);
    }
  }

  public static void paintFill(int[][] screen, int row, int column, int color) {
    int oldColor = screen[row][column];
    paintFill(screen, row, column, color, oldColor);
  }

  public static void main(String[] args) {
    int[][] screen = new int[4][5];

    screen[0][3] = 1;
    screen[1][3] = 1;
    screen[2][3] = 1;
    screen[3][3] = 1;

    paintFill(screen, 0, 1, 5);
    paintFill(screen, 0, 4, 6);

    /*
      5	5	5	1	6
      5	5	5	1	6
      5	5	5	1	6
      5	5	5	1	6
    */
    for (int[] row: screen) {
      for (int color: row) {
        System.out.print(color + "\t");
      }
      System.out.println();
    }
  }
}
