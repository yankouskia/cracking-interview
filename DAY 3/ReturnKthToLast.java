/*
  We will keep two pointers. Front pointer will be moved ahead on k steps
  After that we will move on till the front is null. At that moment
  rear will be desired kth from the last element

  Algorithm complexity: O(n)
  Space: O(1)
*/
public class ReturnKthToLast {
  public static int returnKthToLast(ListNode head, int k) {
    ListNode front = head;
    ListNode rear = head;

    for (int i = 0; i < k; i++) {
      front = front.next;
    }

    while(front != null && front.next != null) {
      front = front.next;
      rear = rear.next;
    }

    return rear.value;
  }

  public static void main(String[] args) {
    final int LIST_LENGTH = 6;
    ListNode head = new ListNode(1);

    ListNode last = head;
    for (int i = 0; i < LIST_LENGTH - 1; i++) {
      ListNode node = new ListNode(i + 2);
      last.next = node;
      last = last.next;
    }

    head.print();

    for (int i = 0; i < LIST_LENGTH; i++) {
      /*
        {1}	{2}	{3}	{4}	{5}	{6}
        0th element to last is: 6
        1th element to last is: 5
        2th element to last is: 4
        3th element to last is: 3
        4th element to last is: 2
        5th element to last is: 1
      */
      System.out.printf("%dth element to last is: %d\n", i, returnKthToLast(head, i));
    }
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
