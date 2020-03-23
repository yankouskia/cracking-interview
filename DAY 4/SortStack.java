import java.util.Stack;

/*
  Let's create and keep additional stack, which will be sorted all the time.
  Pop element from the main stack, if it's less then sorted's peek - we just push it
  If it's bigger, then sorted' peek - we pop all sorted's elements into the main stack till it's empty or till first condition is met
*/
public class SortStack {
  public static void main(String[] args) {
    SortableStack s = new SortableStack();

    s.push(1);
    s.push(7);
    s.push(2);
    s.push(6);
    s.push(5);
    s.push(3);
    s.push(4);
    s.push(0);

    s.sort();
    /*
      Sorted stack:
      7	6	5	4	3	2	1	0
    */
    s.print();
  }
}

class SortableStack {
  private Stack<Integer> stack = null;
  private Stack<Integer> sorted = null;

  public SortableStack() {
    this.stack = new Stack<Integer>();
    this.sorted = new Stack<Integer>();
  }

  public void push(int value) {
    this.stack.push(value);
  }

  public int pop() {
    return this.stack.pop();
  }

  public int peek() {
    return this.stack.peek();
  }

  public void sort() {
    while(!this.stack.isEmpty()) {
      int temp = this.stack.pop();

      if (this.sorted.isEmpty()) {
        this.sorted.push(temp);
        continue;
      }

      if (this.sorted.peek() > temp) {
        this.sorted.push(temp);
        continue;
      }

      while(!this.sorted.isEmpty() && this.sorted.peek() < temp) {
        this.stack.push(this.sorted.pop());
      }

      this.sorted.push(temp);
    }

    this.stack = this.sorted;
    this.sorted = new Stack<Integer>();
  }

  public void print() {
    System.out.print("Sorted stack:\n");
    for (int i = 0; i < this.stack.size(); i++) {
      System.out.print(this.stack.toArray()[i] + "\t");
    }
    System.out.println();
  }
}
