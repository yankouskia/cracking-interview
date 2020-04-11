public class SortedMatrixSearch {
  public static boolean isAnswer(int[] ans) {
    return ans[0] != -1 && ans[1] != -1;
  }

  public static int[] find(int[][] matrix, int search, int startRow, int endRow, int startColumn, int endColumn) {
    int[] answer = { -1, -1 };
    if (endRow < startRow || endColumn < startColumn) {
      return answer;
    }

    int midRow = (startRow + endRow) / 2;
    int midColumn = (startColumn + endColumn) / 2;
    int mid = matrix[midRow][midColumn];

    if (mid == search) {
      answer[0] = midRow;
      answer[1] = midColumn;
      return answer;
    }

    if (midRow == endRow) {
      if (search > mid) {
        return find(matrix, search, midRow, midRow, midColumn + 1, endColumn);
      } else {
        return find(matrix, search, midRow, midRow, startColumn, midColumn - 1);
      }
    }

    if (midColumn == endColumn) {
      if (search > mid) {
        return find(matrix, search, midRow + 1, endRow, midColumn, midColumn);
      } else {
        return find(matrix, search, startRow, midRow - 1, midColumn, midColumn);
      }
    }

    int elMore = matrix[midRow + 1][midColumn + 1];
    if (search >= elMore) {
      return find(matrix, search, midRow + 1, endRow, midColumn + 1, endColumn);
    } else if (search <= mid) {
      return find(matrix, search, startRow, midRow, startColumn, midColumn);
    } else {
      int[] firstTry = find(matrix, search, midRow + 1, endRow, startColumn, midColumn);
      if (isAnswer(firstTry)) {
        return firstTry;
      } else {
        return find(matrix, search, startRow, midRow, midColumn + 1, endColumn);
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = {
      { 1, 10, 20, 29 },
      { 2, 15, 25, 35 },
      { 3, 20, 30, 40 },
      { 6, 32, 40, 50 },
    };

    /*
      2 2
      1 2
      0 3
    */
    System.out.println(find(matrix, 30, 0, 3, 0, 3)[0] + " " + find(matrix, 30, 0, 3, 0, 3)[1]);
    System.out.println(find(matrix, 25, 0, 3, 0, 3)[0] + " " + find(matrix, 25, 0, 3, 0, 3)[1]);
    System.out.println(find(matrix, 29, 0, 3, 0, 3)[0] + " " + find(matrix, 29, 0, 3, 0, 3)[1]);
  }
}
