import java.util.Stack;

public class TowersOfHanoi {
  public static void moveOne(Stack<Integer> from, Stack<Integer> to) {
    if (from.isEmpty()) return;
    to.push(from.pop());
  }

  public static void move(int number, Stack<Integer> from, Stack<Integer> buffer, Stack<Integer> to) {
    if (number > 0) {
      move(number - 1, from, to, buffer);
      moveOne(from, to);
      move(number - 1, buffer, from, to);
    }
  }

  public static void move(Stack<Integer> from, Stack<Integer> buffer, Stack<Integer> to) {
    move(from.size(), from, buffer, to);
  }

  public static void printStack(String name, Stack<Integer> stack) {
    System.out.println(name);
    for (int i: stack) {
      System.out.print(i + " ");
    }
    if (stack.isEmpty()) {
      System.out.print("-- no elements --");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Stack<Integer> from = new Stack<Integer>();
    Stack<Integer> buffer = new Stack<Integer>();
    Stack<Integer> to = new Stack<Integer>();

    for (int i = 10; i > 0; i--) {
      from.push(i);
    }

    printStack("FROM:", from);
    printStack("BUFFER:", buffer);
    printStack("TO:", to);

    /*
      FROM:
      10 9 8 7 6 5 4 3 2 1
      BUFFER:
      -- no elements --
      TO:
      -- no elements --

      FROM:
      -- no elements --
      BUFFER:
      -- no elements --
      TO:
      10 9 8 7 6 5 4 3 2 1
    */
    System.out.println();
    move(from, buffer, to);

    printStack("FROM:", from);
    printStack("BUFFER:", buffer);
    printStack("TO:", to);
  }
}
