import java.util.Random;

/*
  Let's create two nodes: one for head and one for tail.
  While going through all elements - all numbers less then the middle will be added to the head;
  more then the middle - to the tail
*/
public class Partition {
  public static ListNode partition(ListNode list, int middle) {
    ListNode head = list;
    ListNode tail = list;

    while (list != null) {
      if (list.value > middle) {
        tail.next = list;
        tail = tail.next;
        list = list.next;
      } else {
        ListNode temp = list;
        list = list.next;
        temp.next = head;
        head = temp;
      }
    }
    tail.next = null;
    return head;
  }

  public static void main(String[] args) {
    final int MAX_RANDOM = 100;
    final int LIST_LENGTH = 8;
    ListNode head = new ListNode(1);

    Random r = new Random();
    ListNode last = head;
    for (int i = 0; i < LIST_LENGTH - 1; i++) {
      ListNode node = new ListNode(r.nextInt(MAX_RANDOM) + 2);
      last.next = node;
      last = last.next;
    }

    head.print();
    ListNode newHead = partition(head, MAX_RANDOM / 3);
    /*
      {1}	  {36}	{28}	{101}	{18}	{56}	{11}	{36}
      {11}	{18}	{28}	{1}	  {36}	{101}	{56}	{36}
    */
    newHead.print();
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
