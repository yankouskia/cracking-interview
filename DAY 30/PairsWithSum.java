import java.util.HashMap;
import java.util.LinkedList;

public class PairsWithSum {
  public static LinkedList<Integer[]> getPairs(int[] arr, int sum) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    LinkedList<Integer[]> list = new LinkedList<Integer[]>();

    for (int el: arr) {
      if (map.containsKey(sum - el)) {
        int count = map.get(sum - el);

        if (count > 0) {
          Integer[] pair = { el, sum - el };
          list.add(pair);
          map.put(sum - el, count - 1);
          continue;
        }
      }

      if (map.containsKey(el)) {
        map.put(el, map.get(el) + 1);
      } else {
        map.put(el, 1);
      }

    }

    return list;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 5, 3, 65, 3, 5, 32, 3, 7, 8, -3, 9, 1 };

    LinkedList<Integer[]> list = getPairs(arr, 6);
    for (Integer[] pair: list) {
      for (Integer n: pair) {
        System.out.print(n + " ");
      }
      System.out.println();
    }
  }
}
