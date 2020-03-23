import java.util.ArrayList;
import java.util.Stack;

public class StackOfPlates {
  public static void main(String[] args) {
    MultipleStack s = new MultipleStack();

    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);
    s.push(6);
    s.push(7);
    s.push(8);
    s.push(9);
    s.push(10);
    s.push(11);

    /*
      Multiple stack includes next stacks:
      1	 2	3
      4	 5	6
      7	 8	9
      10 11
    */
    s.print();

    s.pop();
    s.pop();
    s.pop();
    s.pop();

    /*
      Multiple stack includes next stacks:
      1	2	3
      4	5	6
      7
    */
    s.print();
  }
}

class MultipleStack {
  private static int STACK_LIMIT = 3;
  private ArrayList<Stack<Integer>> list = null;

  public MultipleStack() {
    this.list = new ArrayList<Stack<Integer>>();

    Stack<Integer> stack = new Stack<Integer>();
    this.list.add(stack);
  }

  private Stack<Integer> last() {
    return this.list.get(this.list.size() - 1);
  }

  public void push(int value) {
    int lastSize = this.last().size();

    if (lastSize < STACK_LIMIT) {
      this.last().push(value);
      return;
    }

    Stack<Integer> stack = new Stack<Integer>();
    stack.push(value);

    this.list.add(stack);
  }

  public int pop() {
    int result = this.last().pop();

    if (this.last().isEmpty() && this.list.size() > 1) {
      this.list.remove(this.list.size() - 1);
    }

    return result;
  }

  public int peek() {
    return this.last().peek();
  }

  public void print() {
    System.out.print("Multiple stack includes next stacks:\n");
    for (Stack<Integer> stack: this.list) {
      for (int i = 0; i < stack.toArray().length; i++) {
        System.out.print(stack.toArray()[i] + "\t");
      }
      System.out.print("\n");
    }
  }
}
