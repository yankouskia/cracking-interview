/*
  Calculate the length of each list, start from the same distance from the end
  and check if any node is the same - it will be the sought for node
*/
public class Intersection {
  public static int getLength(ListNode list) {
    int length = 0;

    while(list != null) {
      length++;
      list = list.next;
    }

    return length;
  }

  public static ListNode intersection(ListNode first, ListNode second) {
    int firstLength = getLength(first);
    int secondLength = getLength(second);

    int diffLength = firstLength > secondLength ? firstLength - secondLength : secondLength - firstLength;

    for (int i = 0; i < diffLength; i++) {
      if (firstLength > secondLength) {
        first = first.next;
      } else {
        second = second.next;
      }
    }

    while(first != null) {
      if (first == second) return first;

      first = first.next;
      second = second.next;
    }

    return null;
  }

  public static void main(String[] args) {
    final int LIST_LENGTH = 9;
    ListNode head = new ListNode(1);

    ListNode last = head;
    for (int i = 0; i < LIST_LENGTH - 1; i++) {
      ListNode node = new ListNode(i);
      last.next = node;
      last = last.next;
    }


    ListNode first = new ListNode(20);
    ListNode second = new ListNode(10);
    first.next = head;
    second.next = head;

    first.print();
    second.print();
    System.out.print("The intersection node:\n");

    /*
      {20}	{1}	{0}	{1}	{2}	{3}	{4}	{5}	{6}	{7}
      {10}	{1}	{0}	{1}	{2}	{3}	{4}	{5}	{6}	{7}
      The intersection node:
      {1}	{0}	{1}	{2}	{3}	{4}	{5}	{6}	{7}
    */
    intersection(first, second).print();
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
