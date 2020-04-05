import java.util.LinkedList;

public class PermutationsWithoutDups {
  public static String insertAt(String s, String ch, int index) {
    if (index == 0) {
      return ch + s;
    }

    return s.substring(0, index) + ch + s.substring(index, s.length());
  }

  public static void permutate(String remaining, LinkedList<String> permutations) {
    if (remaining.isEmpty()) {
      return;
    }

    String remain = remaining.substring(1, remaining.length());
    String firstChar = remaining.substring(0, 1);

    if (permutations.size() == 0) {
      permutations.add(firstChar);
    } else {
      int len = permutations.size();

      while (len-- > 0) {
        String top = permutations.remove();

        for (int i = 0; i < top.length() + 1; i++) {
          permutations.add(insertAt(top, firstChar, i));
        }
      }
    }

    permutate(remain, permutations);
  }

  public static LinkedList<String> permutations(String s) {
    LinkedList<String> permutations = new LinkedList<String>();
    permutate(s, permutations);
    return permutations;
  }

  public static void main(String[] args) {
    LinkedList<String> result = permutations("ABCD");
    result.sort((String first, String second) -> first.compareTo(second));

    // ABCD ABDC ACBD ACDB ADBC ADCB BACD BADC BCAD BCDA BDAC BDCA CABD CADB CBAD CBDA CDAB CDBA DABC DACB DBAC DBCA DCAB DCBA
    for (String s: result) {
      System.out.print(s + " ");
    }

    System.out.println();
  }
}
