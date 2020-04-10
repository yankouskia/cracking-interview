import java.util.LinkedList;

public class SortedSearch {
  public static int findIndex(Listy listy, int search, int left, int right) {
    if (right < left) return -1;
    int mid = (left + right) / 2;
    int el = listy.elementAt(mid);
    if (el == search) return mid;

    if (el == -1 || search < el) {
      return findIndex(listy, search, left, mid - 1);
    } else {
      return findIndex(listy, search, mid + 1, right);
    }
  }

  public static int findIndex(Listy listy, int search) {
    int left = 1;

    while (listy.elementAt(left) < search && listy.elementAt(left) != -1) {
      left *= 2;
    }

    return findIndex(listy, search, left / 2, left);
  }

  public static void main(String[] args) {
    Listy listy = new Listy();

    listy.add(1);
    listy.add(3);
    listy.add(7);
    listy.add(123);
    listy.add(432);
    listy.add(1000);
    listy.add(11000);
    listy.add(98949);
    listy.add(1000000);

    /*
      0
      1
      2
      5
      8
      -1
    */
    System.out.println(findIndex(listy, 1));
    System.out.println(findIndex(listy, 3));
    System.out.println(findIndex(listy, 7));
    System.out.println(findIndex(listy, 1000));
    System.out.println(findIndex(listy, 1000000));
    System.out.println(findIndex(listy, 5));
  }
}

class Listy {
  LinkedList<Integer> list = new LinkedList<Integer>();

  public void add(Integer n) {
    list.add(n);
  }

  public Integer elementAt(int index) {
    if (index >= list.size()) return -1;
    return list.get(index);
  }
}
