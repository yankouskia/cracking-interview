/*
  Idea: reverse linked list and check if reversed and initial are equal
  Complexity: O(n)
  Space: O(n)
*/
public class Palindrome {
  public static ListNode reverse(ListNode list) {
    ListNode head = new ListNode(list.value);

    list = list.next;
    while(list != null) {
      ListNode node = new ListNode(list.value);

      node.next = head;
      head = node;
      list = list.next;
    }

    return head;
  }

  public static boolean palindrome(ListNode list) {
    ListNode reversed = reverse(list);

    while(reversed != null) {
      if (reversed.value != list.value) return false;

      reversed = reversed.next;
      list = list.next;
    }

    return true;
  }

  public static void main(String[] args) {
    final int LIST_LENGTH = 9;
    ListNode head = new ListNode(1);

    ListNode last = head;
    for (int i = 0; i < LIST_LENGTH - 1; i++) {
      ListNode node = new ListNode(i % 2);
      last.next = node;
      last = last.next;
    }

    head.print();
    /*
      {1}	{0}	{1}	{0}	{1}	{0}	{1}	{0}	{1}
      List above is palindrome: true
    */
    System.out.printf("List above is palindrome: %b\n", palindrome(head));
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
