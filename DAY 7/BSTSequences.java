import java.util.LinkedList;

/*
  This problem is combination of 2 problems:
  1. Get all permutations of 2 lists, where in each final list the order of elements in initial lists save
  2. We need to get those sequences of elements from root to bottommost children
*/
public class BSTSequences {
  public static LinkedList<LinkedList<Integer>> getSequences(BinaryNode root) {
    LinkedList<LinkedList<Integer>> listSet = new LinkedList<LinkedList<Integer>>();
    LinkedList<Integer> list = new LinkedList<Integer>();
    listSet.add(list);

    if (root == null) return listSet;

    LinkedList<Integer> prefix = new LinkedList<Integer>();
    prefix.add(root.getValue());

    LinkedList<LinkedList<Integer>> leftSet = getSequences(root.left);
    LinkedList<LinkedList<Integer>> rightSet = getSequences(root.right);

    LinkedList<LinkedList<Integer>> result = new LinkedList<LinkedList<Integer>>();
    for (LinkedList<Integer> leftList: leftSet) {
      for (LinkedList<Integer> rightList: rightSet) {
        LinkedList<LinkedList<Integer>> temp = permutate(leftList, rightList, prefix);
        result.addAll(temp);
      }
    }

    return result;
  }

  public static LinkedList<LinkedList<Integer>> permutate(LinkedList<Integer> first, LinkedList<Integer> second, LinkedList<Integer> prefix) {
    if (first.isEmpty() || second.isEmpty()) {
      LinkedList<LinkedList<Integer>> listSet = new LinkedList<LinkedList<Integer>>();
      LinkedList<Integer> list = new LinkedList<Integer>();
      list.addAll(prefix);
      list.addAll(first);
      list.addAll(second);

      listSet.add(list);
      return listSet;
    }

    Integer firstElement = first.remove();
    prefix.add(firstElement);

    LinkedList<LinkedList<Integer>> firstSet = permutate(first, second, prefix);

    prefix.removeLast();
    first.addFirst(firstElement);
    prefix.add(second.remove());

    LinkedList<LinkedList<Integer>> secondSet = permutate(first, second, prefix);

    second.addFirst(prefix.removeLast());
    firstSet.addAll(secondSet);
    return firstSet;
  }

  public static void main(String[] args) {
    BinaryNode node1 = new BinaryNode(1);
    BinaryNode node2 = new BinaryNode(2);
    BinaryNode node3 = new BinaryNode(3);
    BinaryNode node4 = new BinaryNode(4);
    BinaryNode node5 = new BinaryNode(5);

    node4.left = node3;
    node4.right = node5;

    node3.left = node1;
    node3.right = node2;

    LinkedList<LinkedList<Integer>> listSet = getSequences(node4);

    /*
      4 3 1 2 5
      4 3 1 5 2
      4 3 5 1 2
      4 5 3 1 2
      4 3 2 1 5
      4 3 2 5 1
      4 3 5 2 1
      4 5 3 2 1
    */
    for (LinkedList<Integer> list: listSet) {
      for (Integer value: list) {
        System.out.print(value + " ");
      }
      System.out.println();
    }
  }
}

class BinaryNode {
  private int value;

  public BinaryNode left = null;
  public BinaryNode right = null;

  public BinaryNode(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

  public void print() {
    System.out.print(this.value + " ");
  }
}
