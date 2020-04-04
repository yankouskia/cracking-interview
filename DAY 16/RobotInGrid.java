import java.util.LinkedList;

public class RobotInGrid {
  public static LinkedList<int[]> getPath(int[][] maze, int row, int column, int[][] visited) {
    LinkedList<int[]> list = new LinkedList<int[]>();

    if (row < 0 || row >= maze.length || column < 0 || column >= maze[0].length || maze[row][column] == 1) {
      return null;
    }

    if (visited[row][column] != 0) {
      return null;
    }

    System.out.println("Visit "+ row + " " + column + " ");
    visited[row][column] = 1;

    int[] point = { row, column };
    list.push(point);

    if (row == maze.length - 1 && column == maze[0].length - 1) {
      return list;
    }

    LinkedList<int[]> remainingBottom = getPath(maze, row + 1, column, visited);
    LinkedList<int[]> remainingRight = getPath(maze, row, column + 1, visited);

    if (remainingBottom != null) {
      list.addAll(remainingBottom);
      return list;
    }

    if (remainingRight != null) {
      list.addAll(remainingRight);
      return list;
    }

    return null;
  }

  public static LinkedList<int[]> getPath(int[][] maze) {
    // remember visited points
    int[][] visited = new int[maze.length][maze[0].length];
    return getPath(maze, 0, 0, visited);
  }

  public static void main(String[] args) {
    int N = 6;
    int[][] maze = new int[N][N];

    maze[3][0] = 1;
    maze[3][1] = 1;
    maze[3][2] = 1;
    maze[3][3] = 1;
    maze[3][4] = 1;

    LinkedList<int[]> path = getPath(maze);

    /*
      Visit 0 0
      Visit 1 0
      Visit 2 0
      Visit 2 1
      Visit 2 2
      Visit 2 3
      Visit 2 4
      Visit 2 5
      Visit 3 5
      Visit 4 5
      Visit 5 5
      Visit 1 1
      Visit 1 2
      Visit 1 3
      Visit 1 4
      Visit 1 5
      Visit 0 1
      Visit 0 2
      Visit 0 3
      Visit 0 4
      Visit 0 5
      0 0
      1 0
      2 0
      2 1
      2 2
      2 3
      2 4
      2 5
      3 5
      4 5
      5 5
    */
    for (int[] point: path) {
      System.out.println(point[0] + " " + point[1]);
    }

  }
}
