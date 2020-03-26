public class FirstCommonAncestor {
  // function works as combinations of 2 functions: includes & findMinNode
  public static BinaryNode ancestor(BinaryNode root, BinaryNode first, BinaryNode second) {
    if (root == null) return null;
    if (root == first || root == second) return root;

    BinaryNode x = ancestor(root.left, first, second);
    if (x != null && x != first && x != second) {
      return x;
    }

    BinaryNode y = ancestor(root.right, first, second);
    if (y != null && y != first && y != second) {
      return y;
    }

    if (x != null && y != null && x != y) return root;
    return x != null ? x : y;
  }

  public static void main(String[] args) {
    BinaryNode node1 = new BinaryNode(1);

    BinaryNode node2 = new BinaryNode(2);
    BinaryNode node3 = new BinaryNode(3);

    BinaryNode node4 = new BinaryNode(4);
    BinaryNode node5 = new BinaryNode(5);

    BinaryNode node6 = new BinaryNode(6);
    BinaryNode node7 = new BinaryNode(7);

    node1.left = node2;
    node1.right = node3;

    node2.left = node4;
    node2.right = node5;

    node3.left = node6;
    node3.right = node7;

    // 2
    ancestor(node1, node4, node5).print();

    // 1
    ancestor(node1, node4, node7).print();
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
