import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class GroupAnagrams {
  public static void sort(String[] words) {
    Arrays.sort(words, new WordComparator());
  }

  public static void main(String[] args) {
    String[] words = { "abcd", "123", "adbc", "bca", "bcda", "abc", "dabc", "qwerty", "cab", "cbda" };
    sort(words);

    // 123	abc	cab	bca	abcd	cbda	dabc	bcda	adbc	qwerty
    for (String word: words) {
      System.out.print(word + "\t");
    }

    System.out.println();
  }
}

class WordComparator implements Comparator<String> {
  private static HashMap<String, String> map = new HashMap<String, String>();
  public String transform(String s) {
    if (map.containsKey(s)) return map.get(s);

    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    map.put(s, new String(chars));

    return map.get(s);
  }

  public int compare(String left, String right) {
    return transform(left).compareTo(right);
  }
}
