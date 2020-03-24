public class MinimalTree {
  public static void inOrderTraversal(BinaryNode node) {
    if (node != null) {
      inOrderTraversal(node.left);
      node.print();
      inOrderTraversal(node.right);
    }
  }

  public static void preOrderTraversal(BinaryNode node) {
    if (node != null) {
      node.print();
      preOrderTraversal(node.left);
      preOrderTraversal(node.right);
    }
  }

  public static void postOrderTraversal(BinaryNode node) {
    if (node != null) {
      node.print();
      postOrderTraversal(node.left);
      postOrderTraversal(node.right);
    }
  }

  public static BinaryNode createBST(int[] sortedArray, int start, int end) {
    if (end < start) return null;

    int middle = (end - start) / 2 + start;
    BinaryNode node = new BinaryNode(sortedArray[middle]);

    node.left = createBST(sortedArray, start, middle - 1);
    node.right = createBST(sortedArray, middle + 1, end);

    return node;
  }

  public static BinaryNode createBST(int[] sortedArray) {
    return createBST(sortedArray, 0, sortedArray.length - 1);
  }

  public static void main(String[] args) {
    int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    BinaryNode bst = createBST(sortedArray);
    inOrderTraversal(bst);
    System.out.println();
    preOrderTraversal(bst);
    System.out.println();
    postOrderTraversal(bst);
    System.out.println();
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
