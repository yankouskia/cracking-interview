import java.util.Stack;

/*
  We will keep additional stack and move elements there in case we need to remove (need to eject the last one in stack)
  Also, additional optimization is used for cases, when pop is called several times in raw we do not move all elements to another
  stack each time. We will have isFirst flag and have lazy implementation of that method
*/
public class QueueViaStacks {
  public static void main(String[] args) {
    Queue q = new Queue();

    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    q.add(5);
    q.add(6);

    q.remove();
    q.remove();
    q.remove();

    q.add(1);
    q.add(2);
    q.add(3);

    q.remove();

    /*
      Queue structure:
      5	6	1	2	3
    */
    q.print();
  }
}

class Queue {
  private Stack<Integer> first;
  private Stack<Integer> second;
  private boolean isFirst = true;

  public Queue() {
    this.first = new Stack<Integer>();
    this.second = new Stack<Integer>();
  }

  private void move(Stack<Integer> from, Stack<Integer> to) {
    while(!from.isEmpty()) {
      to.push(from.pop());
    }
  }

  public void add(int value) {
    if (!this.isFirst) {
      this.move(this.second, this.first);
      this.isFirst = true;
    }

    this.first.push(value);
  }

  public int remove() {
    if (this.isFirst) {
      this.move(this.first, this.second);
      this.isFirst = false;
    }

    return this.second.pop();
  }

  public int peek() {
    if (this.isFirst) {
      this.move(this.first, this.second);
      this.isFirst = false;
    }

    return this.second.peek();
  }

  public void print() {
    this.move(this.second, this.first);

    System.out.print("Queue structure:\n");
    for (int i = 0; i < this.first.toArray().length; i++) {
      System.out.print(this.first.toArray()[i] + "\t");
    }
    System.out.println();
  }
}
