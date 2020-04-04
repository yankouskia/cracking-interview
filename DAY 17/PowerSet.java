import java.util.Arrays;
import java.util.LinkedList;

public class PowerSet {
  public static void getSets(LinkedList<Integer> list, LinkedList<LinkedList<Integer>> allSets) {
    if (list.size() == 0) return;

    Integer element = list.removeLast();
    LinkedList<Integer> elementList = new LinkedList<Integer>();
    elementList.add(element);

    LinkedList<LinkedList<Integer>> allSetsCopy = new LinkedList<LinkedList<Integer>>();
    for (LinkedList<Integer> l: allSets) {
      LinkedList<Integer> newList = new LinkedList<Integer>();
      for (int lElement: l) {
        newList.add(lElement);
      }

      newList.add(element);
      allSetsCopy.add(newList);
    }

    allSetsCopy.add(elementList);
    allSets.addAll(allSetsCopy);
    getSets(list, allSets);
  }

  public static LinkedList<LinkedList<Integer>> getSets(int[] arr) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    for (int el: arr) {
      list.add(el);
    }

    LinkedList<LinkedList<Integer>> allSets = new LinkedList<LinkedList<Integer>>();

    getSets(list, allSets);

    return allSets;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5 };

    LinkedList<LinkedList<Integer>> allSets = getSets(arr);
    allSets.sort((LinkedList<Integer> left, LinkedList<Integer> right) -> left.size() - right.size());

    /*
      5
      4
      3
      2
      1
      5 4
      5 3
      4 3
      5 2
      4 2
      3 2
      5 1
      4 1
      3 1
      2 1
      5 4 3
      5 4 2
      5 3 2
      4 3 2
      5 4 1
      5 3 1
      4 3 1
      5 2 1
      4 2 1
      3 2 1
      5 4 3 2
      5 4 3 1
      5 4 2 1
      5 3 2 1
      4 3 2 1
      5 4 3 2 1
    */
    for (LinkedList<Integer> list: allSets) {
      for (Integer el: list) {
        System.out.print(el + " ");
      }
      System.out.println();
    }
  }
}
