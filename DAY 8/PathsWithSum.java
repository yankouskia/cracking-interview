public class PathsWithSum {
  private static int getPathsCount(BinaryNode node, int target, int current) {
    if (node == null) return 0;

    int newCurrent = current + node.getValue();
    int counterPlus = newCurrent == target ? 1 : 0;
    int leftCount = getPathsCount(node.left, target, newCurrent);
    int rightCount = getPathsCount(node.right, target, newCurrent);

    return counterPlus + leftCount + rightCount;
  }
  public static int getPathsCount(BinaryNode node, int target) {
    int pathsCount = getPathsCount(node, target, 0);

    int leftCount = node.left != null ? getPathsCount(node.left, target, 0) : 0;
    int rightCount = node.right != null ? getPathsCount(node.right, target, 0) : 0;

    return pathsCount + leftCount + rightCount;
  }
  public static void main(String[] args) {
    BinaryNode node1 = new BinaryNode(10);
    BinaryNode node2 = new BinaryNode(5);
    BinaryNode node3 = new BinaryNode(-3);
    BinaryNode node4 = new BinaryNode(3);
    BinaryNode node5 = new BinaryNode(2);
    BinaryNode node6 = new BinaryNode(11);
    BinaryNode node7 = new BinaryNode(3);
    BinaryNode node8 = new BinaryNode(-2);
    BinaryNode node9 = new BinaryNode(1);

    node1.left = node2;
    node1.right = node3;

    node2.left = node4;
    node2.right = node5;

    node3.right = node6;

    node4.left = node7;
    node4.right = node8;

    node5.right = node9;

    // 3
    System.out.println(getPathsCount(node1, 8));
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
