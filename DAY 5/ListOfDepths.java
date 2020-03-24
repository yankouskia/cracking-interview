import java.util.ArrayList;
import java.util.LinkedList;

/*
  Task is implemented via 2 methods:
  1. Modified version of BFS
  2. Recursive DFS with passing current level
*/
public class ListOfDepths {
  public static ArrayList<LinkedList<BinaryNode>> getDepthsList(BinaryNode root) {
    ArrayList<LinkedList<BinaryNode>> list = new ArrayList<LinkedList<BinaryNode>>();
    LinkedList<BinaryNode> queue = new LinkedList<BinaryNode>();

    queue.add(root);

    while(!queue.isEmpty()) {
      list.add(queue);

      LinkedList<BinaryNode> nextLevelQueue = new LinkedList<BinaryNode>();

      for (BinaryNode node: queue) {
        if (node.left != null) {
          nextLevelQueue.add(node.left);
        }

        if (node.right != null) {
          nextLevelQueue.add(node.right);
        }
      }

      queue = nextLevelQueue;
    }

    return list;
  }

  public static void getDepthsList2(BinaryNode root, ArrayList<LinkedList<BinaryNode>> list, int level) {
    if (list.size() <= level) {
      LinkedList<BinaryNode> q = new LinkedList<BinaryNode>();
      list.add(q);
    }

    list.get(level).add(root);
    if (root.left != null) {
      getDepthsList2(root.left, list, level + 1);
    }

    if (root.right != null) {
      getDepthsList2(root.right, list, level + 1);
    }
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

    node8.left = node10;
    node8.right = node11;

    node11.right = node12;

    ArrayList<LinkedList<BinaryNode>> list = getDepthsList(node1);

    /*
      1
      2 3
      4 5 6 7
      8 9
      10 11
      12
    */
    for (LinkedList<BinaryNode> q: list) {
      for (BinaryNode n: q) {
        System.out.print(n.getValue() + " ");
      }
      System.out.println("");
    }

    ArrayList<LinkedList<BinaryNode>> result = new ArrayList<LinkedList<BinaryNode>>();
    getDepthsList2(node1, result, 0);

    /*
      1
      2 3
      4 5 6 7
      8 9
      10 11
      12
    */
    for (LinkedList<BinaryNode> q: result) {
      for (BinaryNode n: q) {
        System.out.print(n.getValue() + " ");
      }
      System.out.println("");
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
