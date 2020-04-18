import java.util.Arrays;

public class SumSwap {
  public static int[] findPair(int[] first, int[] second) {
    Arrays.sort(first);
    Arrays.sort(second);

    int firstSum = 0;
    int secondSum = 0;

    for (int el: first) {
      firstSum += el;
    }

    for (int el: second) {
      secondSum += el;
    }

    int diff = secondSum - firstSum;

    int firstIndex = 0;
    int secondIndex = 0;

    while(firstIndex < first.length && secondIndex < second.length) {
      if (second[secondIndex] - first[firstIndex] == diff) {
        int[] result = { first[firstIndex], second[secondIndex] };
        return result;
      } else if (second[secondIndex] - first[firstIndex] > diff) {
        firstIndex++;
      } else {
        secondIndex++;
      }
    }

    int[] result = { -1, -1 };
    return result;
  }

  public static void main(String[] args) {
    int[] first = { 4, 2, 1, 1, 2 };
    int[] second = { 3, 6, 3 };

    // 1 3
    for (int el: findPair(first, second)) {
      System.out.print(el + " ");
    }

    System.out.println();
  }
}
