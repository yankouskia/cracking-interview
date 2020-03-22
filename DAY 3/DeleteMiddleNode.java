public class DeleteMiddleNode {
  /*
    Removing passed node.
    Change node's value to next; forward next's next node to current next
  */
  public static void deleteMiddleNode(ListNode deleteNode) {
    if (deleteNode == null || deleteNode.next == null) {
      throw new Error("Not possible to remove last or null node");
    }

    ListNode next = deleteNode.next;
    deleteNode.value = next.value;
    deleteNode.next = next.next;
  }

  public static void main(String[] args) {
    final int LIST_LENGTH = 5;
    ListNode head = new ListNode(1);

    ListNode last = head;
    for (int i = 0; i < LIST_LENGTH - 1; i++) {
      ListNode node = new ListNode(i + 2);
      last.next = node;
      last = last.next;
    }

    /*
      We are passing 4th element to delete
      {1}	{2}	{3}	{4}	{5}
      {1}	{2}	{3}	{5}
    */
    head.print();
    deleteMiddleNode(head.next.next.next);
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
