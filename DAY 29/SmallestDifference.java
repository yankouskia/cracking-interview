import java.util.Arrays;

public class SmallestDifference {
  public static int difference(int[] first, int[] second) {
    Arrays.sort(first);
    Arrays.sort(second);

    int a = 0;
    int b = 0;

    int diff = Integer.MAX_VALUE;

    while (a < first.length && b < second.length) {
      if (first[a] < second[b]) {
        if (second[b] - first[a] < diff) {
          diff = second[b] - first[a];
        }
        a++;
      } else {
        if (first[a] - second[b]  < diff) {
          diff = first[a] - second[b];
        }
        b++;
      }
    }

    return diff;
  }

  public static void main(String[] args) {
    int[] first = { 1, 3, 15, 11, 2 };
    int[] second = { 23, 127, 235, 19, 8 };

    // 3
    System.out.println(difference(first, second));
  }
}
