public class SortedMerge {
  public static void merge(int[] to, int[] from) {
    int fromLength = from.length;
    int toLength = to.length;

    int toCurrent = toLength - fromLength - 1;
    int fromCurrent = fromLength - 1;

    for (int i = toLength - 1; i >= 0; i--) {
      if (fromCurrent >= 0 && from[fromCurrent] > to[toCurrent]) {
        to[i] = from[fromCurrent];
        fromCurrent--;
      } else if (toCurrent >= 0) {
        to[i] = to[toCurrent];
        toCurrent--;
      }
    }
  }

  public static void main(String[] args) {
    int[] to = { 1, 3, 5, 7, 9, 0, 0, 0, 0 };
    int[] from = { 2, 4, 6, 100 };

    merge(to, from);

    // 1	2	3	4	5	6	7	9	100
    for (int el: to) {
      System.out.print(el + "\t");
    }
    System.out.println();
  }
}
