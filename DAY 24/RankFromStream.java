public class RankFromStream {
  public static void main(String[] args) {
    BinaryNode b = new BinaryNode(6);
    b.add(5);
    b.add(7);
    b.add(8);
    b.add(9);
    b.add(1);
    b.add(2);
    b.add(3);
    b.add(4);

    // 4
    System.out.println(b.getRank(5));

    // 7
    System.out.println(b.getRank(8));
  }
}


class BinaryNode {
  private int value;
  private int leftSize = 0;

  public BinaryNode left = null;
  public BinaryNode right = null;

  public BinaryNode(int value) {
    this.value = value;
  }

  public int getRank(int v) {
    if (this.value == v) {
      return this.leftSize;
    }

    if (this.value > v) {
      if (this.left != null) {
        return this.left.getRank(v);
      } else {
        return 0;
      }
    }

    if (this.right != null) return this.leftSize + 1 + this.right.getRank(v);
    return this.leftSize + 1;
  }

  public void add(int newValue) {
    if (newValue < this.value) {
      this.leftSize++;
      if (this.left != null) {
        this.left.add(newValue);
      } else {
        BinaryNode n = new BinaryNode(newValue);
        this.left = n;
      }
    } else {
      if (this.right != null) {
        this.right.add(newValue);
      } else {
        BinaryNode n = new BinaryNode(newValue);
        this.right = n;
      }
    }
  }

  public int getValue() {
    return this.value;
  }

  public void print() {
    System.out.print(this.value + " ");
  }
}
