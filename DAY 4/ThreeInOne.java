public class ThreeInOne {
  public static void main(String[] args) {
    MultipleStack st = new MultipleStack(3);

    st.push(0, 1);
    st.push(0, 2);
    st.push(1, 3);
    st.push(1, 4);
    st.push(1, 5);
    st.push(2, 6);
    st.push(2, 7);
    st.push(2, 8);
    st.push(2, 9);
    st.push(2, 1);
    st.push(2, 2);
    st.push(2, 3);
    st.push(2, 4);
    st.push(2, 5);
    st.push(2, 6);
    st.push(2, 7);
    st.pop(1);

    /*
      Multiple stack structure:
      1	2
      3	4
      6	7	8	9	1	2	3	4	5	6	7
    */
    st.print();
  }
}

class MultipleStack {
  private static final int INITIAL_ELEMENTS_MULTIPLIER = 10;
  private int[] arr = null;
  private int[] sizes = null;
  private int stacksCount = 0;

  public MultipleStack(int count) {
    this.stacksCount = count;
    this.arr = new int[count * INITIAL_ELEMENTS_MULTIPLIER];
    this.sizes = new int[count];
  }

  public void push(int stackNumber, int value) {
    if (stackNumber > this.stacksCount) {
      throw new Error("Stack number is more then the count of stacks");
    }

    int stackSize = this.sizes[stackNumber];
    int elementIndex = stackNumber + stackSize * this.stacksCount;

    if (elementIndex >= this.arr.length) {
      int[] biggerArray = new int[this.arr.length * 2];
      for (int i = 0; i < this.arr.length; i++) {
        biggerArray[i] = this.arr[i];
      }
      this.arr = biggerArray;
    }

    this.arr[elementIndex] = value;
    this.sizes[stackNumber]++;
  }

  public int pop(int stackNumber) {
    if (this.sizes[stackNumber] == 0) {
      throw new Error("No elements in stack");
    }

    this.sizes[stackNumber]--;
    int elementIndex = stackNumber + this.sizes[stackNumber] * this.stacksCount;

    return this.arr[elementIndex];
  }

  public int peek(int stackNumber) {
    if (this.sizes[stackNumber] == 0) {
      throw new Error("No elements in stack");
    }

    return this.arr[stackNumber + (this.sizes[stackNumber] - 1) * this.stacksCount];
  }

  public boolean isEmpty(int stackNumber) {
    return this.sizes[stackNumber] == 0;
  }

  public void print() {
    System.out.print("Multiple stack structure:\n");
    for (int i = 0; i < this.stacksCount; i++) {
      for (int j = 0; j < this.sizes[i]; j++) {
        System.out.print(this.arr[i + j * this.stacksCount] + "\t");
      }
      System.out.print("\n");
    }
  }
}
