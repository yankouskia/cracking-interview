import java.util.ArrayList;

public class StackOfBoxes {
  public static int getHeight(ArrayList<Box> remainingBoxes, Box previousBox) {
    if (remainingBoxes.size() == 0) return 0;

    Boolean canPut = previousBox == null ? true : previousBox.isMoreThen(remainingBoxes.get(0));
    ArrayList<Box> leftList = new ArrayList<Box>(remainingBoxes);
    Box standBox = leftList.remove(0);

    if (canPut) {
      return Math.max(standBox.height + getHeight(leftList, standBox), getHeight(leftList, previousBox));
    }

    return getHeight(leftList, previousBox);
  }

  public static void main(String[] args) {
    ArrayList<Box> boxes = new ArrayList<Box>();
    boxes.add(new Box(1, 2, 3));
    boxes.add(new Box(5, 5, 5));
    boxes.add(new Box(6, 5, 6));
    boxes.add(new Box(4, 4, 4));
    boxes.add(new Box(100, 100, 100));
    boxes.add(new Box(2, 3, 4));

    boxes.sort((Box first, Box second) -> second.height - first.height);
    int height = getHeight(boxes, null);

    //Max height is: 111
    System.out.println("Max height is: " + height);

  }
}

class Box {
  public int height;
  public int width;
  public int depth;

  public Box(int height, int width, int depth) {
    this.height = height;
    this.width = width;
    this.depth = depth;
  }

  public boolean isLessThen(Box box) {
    return this.height < box.height && this.width < box.width && this.depth < box.depth;
  }

  public boolean isMoreThen(Box box) {
    return this.height > box.height && this.width > box.width && this.depth > box.depth;
  }
}
