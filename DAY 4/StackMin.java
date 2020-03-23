import java.util.Stack;

/*
  Let's keep additional stack and push value there when new min value is added
  In this case all operations has O(n) complexity
*/
public class StackMin {
  public static void main(String[] args) {
    StackWithMin s = new StackWithMin();

    s.push(5);
    s.push(4);
    s.push(6);
    // Current min value is: 4
    System.out.println("Current min value is: " + s.min());

    s.push(3);
    // Current min value is: 3
    System.out.println("Current min value is: " + s.min());

    s.pop();
    // Current min value is: 4
    System.out.println("Current min value is: " + s.min());
  }
}

class StackWithMin {
  private Stack<Integer> stack = null;
  private Stack<Integer> minStack = null;

  public StackWithMin() {
    this.stack = new Stack<Integer>();
    this.minStack = new Stack<Integer>();
  }

  public void push(int value) {
    this.stack.push(value);

    if (this.minStack.isEmpty() || this.minStack.peek() >= value) {
      this.minStack.push(value);
    }
  }

  public int pop() {
    int result = this.stack.pop();
    int minValue = this.minStack.peek();

    if (result == minValue) {
      this.minStack.pop();
    }

    return result;
  }

  public int min() {
    return this.minStack.peek();
  }
}
