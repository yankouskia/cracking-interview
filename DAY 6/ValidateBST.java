/*
  Implementation based on definition: BST is a binary tree in which every node fits a specific ordering property:
  all left descendent s <= n < all right descendants. This must be true for each node n.
*/
public class ValidateBST {
  public static void traverse(BinaryNode node) {
    if (node == null) return;
    traverse(node.left);
    node.print();
    traverse(node.right);
  }

  public static boolean checkBST(BinaryNode node, Integer min, Integer max) {
    if (node == null) return true;

    Integer value = node.getValue();

    boolean isMinCorrect = min == null || value >= min;
    boolean isMaxCorrect = max == null || value < max;

    if (!isMinCorrect || !isMaxCorrect) return false;
    return checkBST(node.left, min, value) && checkBST(node.right, value, max);
  }

  public static boolean checkBST(BinaryNode node) {
    return checkBST(node, null, null);
  }

  public static void main(String[] args) {
    BinaryNode node1 = new BinaryNode(10);

    BinaryNode node2 = new BinaryNode(5);
    BinaryNode node3 = new BinaryNode(15);

    BinaryNode node4 = new BinaryNode(3);
    BinaryNode node5 = new BinaryNode(7);

    BinaryNode node6 = new BinaryNode(12);
    BinaryNode node7 = new BinaryNode(17);

    BinaryNode node8 = new BinaryNode(8);
    BinaryNode node9 = new BinaryNode(9);

    BinaryNode node10 = new BinaryNode(10);
    BinaryNode node11 = new BinaryNode(11);

    node1.left = node2;
    node1.right = node3;

    node2.left = node4;
    node2.right = node5;

    node3.left = node6;
    node3.right = node7;

    /*
      3 5 7 10 12 15 17 Binary tree is BST: true
    */
    traverse(node1);
    System.out.printf("Binary tree is BST: %b\n", checkBST(node1));

    node4.left = node8;
    node4.right = node9;

    node5.left = node10;
    node5.right = node11;

    /*
      8 3 9 5 10 7 11 10 12 15 17 Binary tree is BST: false
    */
    traverse(node1);
    System.out.printf("Binary tree is BST: %b\n", checkBST(node1));
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
