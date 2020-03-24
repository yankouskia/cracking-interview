/*
  2 methods are implemented for such feature.
  In both of them we are recursively calculating the height of the tree:
    1. We have separate recursive method to check the length's difference of all subtrees in tree
    2. We check that the differences in heights equals or less then 1 inside getHeight method
*/
public class CheckBalanced {
  public static int getHeight(BinaryNode root) {
    if (root == null) return 0;

    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }

  public static boolean checkBalanced(BinaryNode root) {
    if (root == null) return true;

    int heightDiff = getHeight(root.left) - getHeight(root.right);
    if (Math.abs(heightDiff) > 1) return false;

    return checkBalanced(root.left) && checkBalanced(root.right);
  }

  public static int getHeight2(BinaryNode root) {
    if (root == null) return 0;

    int leftHeight = getHeight2(root.left);
    int rightHeight = getHeight2(root.right);

    if (leftHeight < 0 || rightHeight < 0) return -1;
    if (Math.abs(leftHeight - rightHeight) > 1) return -1;

    return Math.max(leftHeight, rightHeight) + 1;
  }

  public static boolean checkBalanced2(BinaryNode root) {
    int height = getHeight2(root);
    return height != -1;
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

    // Binary tree is balanced: true
    System.out.printf("Binary tree is balanced: %b\n", checkBalanced(node1));
    // Binary tree is balanced: true
    System.out.printf("Binary tree is balanced: %b\n", checkBalanced2(node1));

    node11.right = node12;
    // Binary tree is balanced: false
    System.out.printf("Binary tree is balanced: %b\n", checkBalanced(node1));
    // Binary tree is balanced: false
    System.out.printf("Binary tree is balanced: %b\n", checkBalanced2(node1));
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
