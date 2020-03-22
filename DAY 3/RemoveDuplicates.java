/*
  Without additional space the best algorithm has complexity O(n ^ 2)
  For each node we are looking for the same values through the list
*/
public class RemoveDuplicates {
  public static void removeDuplicates(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while(slow != null) {
      while(fast != null && fast.next != null) {
        if (fast.next.value == slow.value) {
          fast.next = fast.next.next;
        }
        fast = fast.next;
      }

      slow = slow.next;
      fast = slow;
    }
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);

    ListNode secondNode = new ListNode(2);
    ListNode thirdNode = new ListNode(4);
    ListNode fourthNode = new ListNode(2);
    ListNode fifthNode = new ListNode(3);
    ListNode lastNode = new ListNode(4);

    head.next = secondNode;
    secondNode.next = thirdNode;
    thirdNode.next = fourthNode;
    fourthNode.next = fifthNode;
    fifthNode.next = lastNode;

    /*
      {1}	{2}	{4}	{2} {3}	{4}
      {1}	{2}	{4}	{3}
    */
    head.print();
    removeDuplicates(head);
    head.print();
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
