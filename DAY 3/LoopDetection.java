/*
  Fast pointer - 2 moves (.next calls) per step
  Slow pointer - 1 move (.next calls) per step

  We move fast pointer twice as fast as slow pointer. When slow pointer enters the loop, after k nodes,
  fast pointer is k nodes into the loop. This means that fast pointer and slow pointer are LOOP_SIZE - k nodes away from each other.
  Next, if fast pointer moves two nodes for each node that slow pointer moves, they move one node closer to each other on each turn.
  Therefore, they will meet after LOOP_SIZE - k turns. Both will be k nodes from the front of the loop.
  The head of the linked list is also k nodes from the front of the loop. So, if we keep one pointer where it is,
  and move the other pointer to the head of the linked list, then they will meet at the front of the loop.
*/
public class LoopDetection {
  public static ListNode loopDetection(ListNode list) {
    if (list == null || list.next == null) return null;

    ListNode slow = list;
    ListNode fast = list.next.next;

    while(slow != fast && fast != null) {
      slow = slow.next;
      fast = fast.next != null ? fast.next.next : null;
    }

    if (fast == null || fast.next == null) {
      return null;
    }

    slow = list;

    if (slow == fast) {
      return fast;
    }

    while (slow != fast) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  public static void main(String[] args) {
    final int LIST_LENGTH = 9;
    ListNode head = new ListNode(1);

    ListNode last = head;
    for (int i = 0; i < LIST_LENGTH - 1; i++) {
      ListNode node = new ListNode(i + 2);
      last.next = node;
      last = last.next;
    }
    last.next = head;


    ListNode first = new ListNode(20);
    ListNode second = new ListNode(10);
    first.next = second;
    second.next = head;

    /*
      The loop start node:
      1
    */
    System.out.print("The loop start node:\n");
    System.out.println(loopDetection(first).value);
  }
}

class ListNode {
  public int value;
  public ListNode next = null;

  public ListNode(int value) {
    this.value = value;
  }

  public void print() {
    ListNode current = this;

    while(current != null) {
      System.out.printf("{%d}\t", current.value);
      current = current.next;
    }

    System.out.print("\n");
  }
}
