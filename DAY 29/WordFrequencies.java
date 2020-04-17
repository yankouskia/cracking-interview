import java.util.HashMap;

public class WordFrequencies {
  public static HashMap<String, Integer> map = new HashMap<String, Integer>();

  public static int getFrequencies(String text, String word) {
    if (map.containsKey(word)) {
      return map.get(word);
    }

    int frequencies = 0;

    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == word.charAt(0)) {
        if (i == 0 || text.charAt(i - 1) != ' ') {
          continue;
        }

        boolean isMatch = true;
        int skip = 0;
        for (int j = 1; j < word.length(); j++) {
          skip++;
          if (text.charAt(i + j) != word.charAt(j)) {
            isMatch = false;
            break;
          }
        }

        if (isMatch) {
          frequencies++;
        }

        i += skip;
      }
    }

    map.put(word, frequencies);
    return frequencies;
  }
  public static void main(String[] args) {
    String text = "Hello world Alex, my name is Alex. But his name is Alex too";

    /*
      The number of word 'Alex' occurs 3 times
      The number of word 'is' occurs 2 times
    */
    System.out.printf("The number of word 'Alex' occurs %d times \n", getFrequencies(text, "Alex"));
    System.out.printf("The number of word 'is' occurs %d times \n", getFrequencies(text, "is"));
  }
}
