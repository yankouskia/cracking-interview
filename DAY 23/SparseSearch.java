public class SparseSearch {
  public static int findIndex(String[] strings, String search, int left, int right) {
    int midLeft = (left + right) / 2;
    int midRight = midLeft;
    if (left > right) return -1;

    if (strings[midLeft].isEmpty()) {
      while (true) {
        midLeft--;
        midRight++;
        if (midLeft >= left && !strings[midLeft].isEmpty()) {
          midRight = midLeft;
          break;
        }
        if (midRight <= right && !strings[midRight].isEmpty()) {
          midLeft = midRight;
          break;
        }
        if (midLeft < left && midRight > right) {
          return -1;
        }
      }
    }

    if (strings[midLeft].isEmpty()) {
      return -1;
    }

    if (strings[midLeft].compareTo(search) == 0) return midLeft;

    if (strings[midLeft].compareTo(search) < 0) {
      return findIndex(strings, search, midLeft + 1, right);
    } else {
      return findIndex(strings, search, left, midLeft - 1);
    }
  }

  public static void main(String[] args) {
    String[] strings = {
      "abc",
      "",
      "",
      "",
      "bcd",
      "",
      "cde",
      "def",
      "",
      "",
      "",
      "",
      "efg",
      "",
      "fgh"
    };

    /*
      0
      4
      6
      7
      12
    */
    System.out.println(findIndex(strings, "abc", 0, strings.length - 1));
    System.out.println(findIndex(strings, "bcd", 0, strings.length - 1));
    System.out.println(findIndex(strings, "cde", 0, strings.length - 1));
    System.out.println(findIndex(strings, "def", 0, strings.length - 1));
    System.out.println(findIndex(strings, "efg", 0, strings.length - 1));
  }
}
