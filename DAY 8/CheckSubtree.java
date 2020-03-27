public class CheckSubtree {
  public static boolean checkEqual(BinaryNode first, BinaryNode second) {
    if (first == null && second == null) return true;
    if (first != null ^ second != null) return false;
    if (first.getValue() != second.getValue()) return false;

    return checkEqual(first.left, second.left) && checkEqual(first.right, second.right);
  }

  public static boolean checkSubtree(BinaryNode t1, BinaryNode t2) {
    if (t2 == null) return true;
    if (t1 == null) return false;

    if (t1.getValue() == t2.getValue() && checkEqual(t1, t2)) {
      return true;
    }

    return checkSubtree(t1.left, t2) || checkSubtree(t1.right, t2);
  }

  public static void main(String[] args) {
    BinaryNode node1 = new BinaryNode(1);
    BinaryNode node2 = new BinaryNode(2);
    BinaryNode node3 = new BinaryNode(3);
    BinaryNode node4 = new BinaryNode(4);
    BinaryNode node5 = new BinaryNode(5);
    BinaryNode node6 = new BinaryNode(6);
    BinaryNode node7 = new BinaryNode(7);
    BinaryNode node8 = new BinaryNode(8);
    BinaryNode node9 = new BinaryNode(9);
    BinaryNode node10 = new BinaryNode(10);
    BinaryNode node11 = new BinaryNode(11);
    BinaryNode node12 = new BinaryNode(12);

    node1.left = node2;
    node1.right = node3;

    node2.left = node4;
    node2.right = node5;

    node3.left = node6;
    node3.right = node7;

    node4.left = node8;
    node4.right = node9;

    node5.left = node10;
    node5.right = node11;

    /*
      Node 4 is a subtree of Node 1: true
      Node 1 is a subtree of Node 2: false
      Node 12 is a subtree of Node 1: false
      Node 11 is a subtree of Node 1: true
    */
    System.out.println("Node 4 is a subtree of Node 1: " + checkSubtree(node1, node4));
    System.out.println("Node 1 is a subtree of Node 2: " + checkSubtree(node2, node1));
    System.out.println("Node 12 is a subtree of Node 1: " + checkSubtree(node1, node12));
    System.out.println("Node 11 is a subtree of Node 1: " + checkSubtree(node1, node11));
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
