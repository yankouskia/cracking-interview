/*
 1. ASCII contains 128 characters
 2. Unicode:
    a. UTF-16 contains 65536 characters (16 bits for each character)
    b. UTF-32 contains 1073741824 characters (32 bits for each character)

  For this solution we imply that string consists of ASCII characters

  Note: we need to know if strings are case-sensitive and whether whitespaces are important or not
  For this problem we imply that strings are case-sensitive and whitespace is a separate character
 */

public class CheckPermutation {
  public static final int MAX_CHARACTERS_COUNT = 128;

  public static boolean checkPermutation(String first, String second) {
    int firstLength = first.length();
    int secondLength = second.length();

    if (firstLength != secondLength) return false;

    // create array to keep char codes and number of occurences in the string
    int[] charsOccurrences = new int[MAX_CHARACTERS_COUNT];

    for (int i = 0; i < firstLength; i++) {
      charsOccurrences[first.charAt(i)]++;
    }

    for (int i = 0; i < secondLength; i++) {
      int charCode = second.charAt(i);
      charsOccurrences[charCode]--;

      if (charsOccurrences[charCode] < 0) return false;
    }

    return true;
  }

  public static void main(String[] args) {
    String[][] testStrings = { { "1", "23" }, { "hello", "elloh" }, { "QWE", "qwe" }, { "qwertyuiop", "poiuytrewq" } };

    for (int i = 0; i < testStrings.length; i++) {
      /*
        Words '1' and '23' are permutations: false
        Words 'hello' and 'elloh' are permutations: true
        Words 'QWE' and 'qwe' are permutations: false
        Words 'qwertyuiop' and 'poiuytrewq' are permutations: true
      */
      System.out.printf("Words '%s' and '%s' are permutations: %b\n", testStrings[i][0], testStrings[i][1], checkPermutation(testStrings[i][0], testStrings[i][1]));
    }
  }
}
