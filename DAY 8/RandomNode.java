import java.util.Random;

/*
  Store the size of subtree for each node to calculate the same probability
*/
public class RandomNode {
  public static void main(String[] args) {
    BinaryNode tree = new BinaryNode(1000);

    tree.insert(500);
    tree.insert(1500);

    tree.insert(250);
    tree.insert(750);
    tree.insert(1250);
    tree.insert(1750);

    tree.insert(125);
    tree.insert(375);
    tree.insert(625);
    tree.insert(875);
    tree.insert(1125);
    tree.insert(1375);
    tree.insert(1625);
    tree.insert(1825);


    /*
      1500
      1250
      375
      1825
      1825
      875
      250
      1750
      1750
      1000
      875
      500
      1750
      1825
      1500
      1250
      250
      500
    */
    System.out.println(tree.randomNode().getValue());
    System.out.println(tree.randomNode().getValue());
    System.out.println(tree.randomNode().getValue());
    System.out.println(tree.randomNode().getValue());
    System.out.println(tree.randomNode().getValue());
    System.out.println(tree.randomNode().getValue());
    System.out.println(tree.randomNode().getValue());
    System.out.println(tree.randomNode().getValue());
    System.out.println(tree.randomNode().getValue());
    System.out.println(tree.randomNode().getValue());
    System.out.println(tree.randomNode().getValue());
    System.out.println(tree.randomNode().getValue());
    System.out.println(tree.randomNode().getValue());
    System.out.println(tree.randomNode().getValue());
    System.out.println(tree.randomNode().getValue());
    System.out.println(tree.randomNode().getValue());
    System.out.println(tree.randomNode().getValue());
    System.out.println(tree.randomNode().getValue());

    tree.inorder(tree);
    System.out.println();

    tree.delete(250);
    tree.inorder(tree);
    System.out.println();

    tree.delete(1250);
    tree.inorder(tree);
    System.out.println();

    tree.delete(500);
    tree.inorder(tree);
    System.out.println();

    /*
      50 125 250 375 500 625 750 875 1000 1125 1250 1375 1500 1625 1750 1825
      50 125 375 500 625 750 875 1000 1125 1250 1375 1500 1625 1750 1825
      50 125 375 500 625 750 875 1000 1125 1375 1500 1625 1750 1825
      50 125 375 625 625 750 1000 1125 1375 1500 1625 1750 1825
    */
  }
}

class BinaryNode {
  private int value;
  private int childrenCount = 0;

  public BinaryNode left = null;
  public BinaryNode right = null;

  public BinaryNode(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

  public void print() {
    System.out.print(this.value + "\t");
  }

  public int getChildrenCount() {
    return this.childrenCount;
  }

  public BinaryNode randomNode() {
    if (this.left == null && this.right == null) return this;

    Random random = new Random();
    int r = random.nextInt(childrenCount);
    int leftSize = this.left == null ? 0 : this.left.childrenCount;

    if (r < leftSize) {
      return this.left.randomNode();
    } else if (r == leftSize) {
      return this;
    } else {
      return this.right.randomNode();
    }
  }

  private void insert(BinaryNode node, int value) {
    node.childrenCount++;

    int current = node.getValue();
    if (value > current) {
      if (node.right != null) {
        insert(node.right, value);
      } else {
        BinaryNode newNode = new BinaryNode(value);
        node.right = newNode;
      }
    } else {
      if (node.left != null) {
        insert(node.left, value);
      } else {
        BinaryNode newNode = new BinaryNode(value);
        node.left = newNode;
      }
    }
  }

  public void insert(int value) {
    this.insert(this, value);
  }

  private BinaryNode find(BinaryNode node, int value) {
    if (node == null) return null;
    if (node.getValue() == value) return node;
    if (value > node.getValue()) {
      return find(node.right, value);
    } else {
      return find(node.left, value);
    }
  }

  public BinaryNode find(int value) {
    return find(this, value);
  }

  private BinaryNode findParent(BinaryNode node, int value) {
    if (node == null) return null;

    BinaryNode left = node.left;
    BinaryNode right = node.right;

    if (left != null && left.getValue() == value) return node;
    if (right != null && right.getValue() == value) return node;

    BinaryNode inLeftParent = findParent(left, value);
    return inLeftParent != null ? inLeftParent : findParent(right, value);
  }

  private BinaryNode findSuccessor(BinaryNode node) {
    if (node.left == null) return node;
    return findSuccessor(node.left);
  }

  public void delete(int value) {
    BinaryNode toRemove = this.find(this, value);
    if (toRemove == null) return;

    BinaryNode toRemoveParent = this.findParent(this, value);

    if (toRemove.left == null && toRemove.right == null) {
      if (toRemoveParent == null) {
        throw new Error("Removing last element");
      }

      if (toRemoveParent.left == toRemove) {
        toRemoveParent.left = null;
        return;
      }

      if (toRemoveParent.right == toRemove) {
        toRemoveParent.right = null;
        return;
      }
    }

    if (toRemove.left == null) {
      toRemove.value = toRemove.right.getValue();
      toRemove.left = toRemove.right.left;
      toRemove.right = toRemove.right.right;
      return;
    }

    if (toRemove.right == null) {
      toRemove.value = toRemove.left.getValue();
      toRemove.right = toRemove.left.right;
      toRemove.left = toRemove.left.left;
      return;
    }

    BinaryNode successor = this.findSuccessor(toRemove.right);
    BinaryNode successorParent = this.findParent(this, successor.value);

    toRemove.value = successor.value;
    successorParent.right = successor.right;
  }

  public void inorder(BinaryNode node) {
    if (node != null) {
      inorder(node.left);
      System.out.print(node.getValue() + " ");
      inorder(node.right);
    }
  }
}
