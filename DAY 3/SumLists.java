/*
  We will create a separate ListNode to store result and keep head & tail of that list.
  The summarizing will be the same as we use with "column addition" technique.
  isOverflow boolean variable will keep if we have a carry
*/
public class SumLists {
  public static ListNode sumLists(ListNode firstList, ListNode secondList) {
    ListNode head = null;
    ListNode tail = null;
    boolean isOverflow = false;

    // Go forward till the end of BOTH lists (they could have different size)
    while(firstList != null || secondList != null) {
      int firstValue = firstList == null ? 0 : firstList.value;
      int secondValue = secondList == null ? 0 : secondList.value;

      int newValue = firstValue + secondValue + (isOverflow ? 1 : 0);
      ListNode node = new ListNode(newValue % 10);
      isOverflow = newValue / 10 == 1;

      if (head != null) {
        tail.next = node;
        tail = tail.next;
      } else {
        head = node;
        tail = node;
      }

      firstList = firstList != null ? firstList.next : null;
      secondList = secondList != null ? secondList.next : secondList;
    }

    // Add additional node in front in case of overflow
    if (isOverflow) {
      ListNode node = new ListNode(1);
      tail.next = node;
    }

    return head;
  }

  public static void main(String[] args) {
    final int LIST_LENGTH = 7;
    ListNode head = new ListNode(1);

    ListNode last = head;
    for (int i = 0; i < LIST_LENGTH - 1; i++) {
      ListNode node = new ListNode(i + 2);
      last.next = node;
      last = last.next;
    }

    head.print();
    sumLists(head, head).print();
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
