/*
  The right element can be:
    1. The leftmost element in right subtree
    2. Nearest parent, which has specified node in left subtree
*/
public class Successor {
  public static void inorder(BinaryNode node) {
    if (node == null) return;
    inorder(node.left);
    node.print();
    inorder(node.right);
  }

  public static Integer successor(BinaryNode node) {
    if (node == null) return null;
    if (node.right != null) {
      BinaryNode foundNode = node.right;

      while(foundNode.left != null) {
        foundNode = foundNode.left;
      }

      return foundNode.getValue();
    }

    while(node.parent != null) {
      BinaryNode parent = node.parent;

      if (parent.left == node) {
        return parent.getValue();
      }

      node = parent;
    }

    return null;
  }

  public static void main(String[] args) {
    BinaryNode node1 = new BinaryNode(10);

    BinaryNode node2 = new BinaryNode(5);
    BinaryNode node3 = new BinaryNode(15);

    BinaryNode node4 = new BinaryNode(3);
    BinaryNode node5 = new BinaryNode(7);

    BinaryNode node6 = new BinaryNode(12);
    BinaryNode node7 = new BinaryNode(17);

    node1.addLeft(node2);
    node1.addRight(node3);

    node2.addLeft(node4);
    node2.addRight(node5);

    node3.addLeft(node6);
    node3.addRight(node7);

    /*
      For binary tree:
      3 5 7 10 12 15 17
      The successor node to 10 is 12
      The successor node to 5 is 7
      The successor node to 15 is 17
      The successor node to 3 is 5
      The successor node to 7 is 10
      The successor node to 12 is 15
      The successor node to 17 is null
    */
    System.out.println("For binary tree: ");
    inorder(node1);
    System.out.printf("\nThe successor node to %d is %d\n", node1.getValue(), successor(node1));
    System.out.printf("\nThe successor node to %d is %d\n", node2.getValue(), successor(node2));
    System.out.printf("\nThe successor node to %d is %d\n", node3.getValue(), successor(node3));
    System.out.printf("\nThe successor node to %d is %d\n", node4.getValue(), successor(node4));
    System.out.printf("\nThe successor node to %d is %d\n", node5.getValue(), successor(node5));
    System.out.printf("\nThe successor node to %d is %d\n", node6.getValue(), successor(node6));
    System.out.printf("\nThe successor node to %d is %d\n", node7.getValue(), successor(node7));
  }
}

class BinaryNode {
  private int value;

  public BinaryNode parent = null;
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

  public void addLeft(BinaryNode node) {
    this.left = node;
    node.parent = this;
  }

  public void addRight(BinaryNode node) {
    this.right = node;
    node.parent = this;
  }
}
