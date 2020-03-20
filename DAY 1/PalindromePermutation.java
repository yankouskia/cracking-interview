/*
  Note: in this problem we skip all non alpha characters and ignore case sensitivity
  The java.lang.Character.getNumericValue(char ch) returns the int value that the specified Unicode character represents
  The letters A-Z in their uppercase ('\u0041' through '\u005A'), lowercase ('\u0061' through '\u007A'),
  and full width variant ('\uFF21' through '\uFF3A' and '\uFF41' through '\uFF5A') forms have numeric values from 10 through 35.
  This is independent of the Unicode specification, which does not assign numeric values to these char values.
 */
public class PalindromePermutation {
  public static final int CHARACTERS_NUMBER = 26;
  public static final int MIN_CHARACTER_CODE = Character.getNumericValue('a');
  public static final int MAX_CHARACTER_CODE = Character.getNumericValue('z');

  public static boolean palindromePermutation(String str) {
    int[] charactersOccurences = new int[CHARACTERS_NUMBER];

    // Palindrome has either all letters occurences even or one of them could be odd
    int oddsNumber = 0;

    for (char ch: str.toCharArray()) {
      int code = Character.getNumericValue(ch);
      if (code < MIN_CHARACTER_CODE || code > MAX_CHARACTER_CODE) {
        continue;
      }

      charactersOccurences[code - MIN_CHARACTER_CODE]++;

      if (charactersOccurences[code - MIN_CHARACTER_CODE] % 2 == 0) {
        oddsNumber--;
      } else {
        oddsNumber++;
      }
    }

    return oddsNumber <= 1;
  }

  public static void main(String[] strings) {
    String[] testStrings = { "taco cat", "HeLlO OLLEH W", "bye bye me", "123 world 321 world", "world" };

    for (String str: testStrings) {
      /*
        The word 'taco cat' is palindrome permutation: true
        The word 'HeLlO OLLEH W' is palindrome permutation: true
        The word 'bye bye me' is palindrome permutation: false
        The word '123 world 321 world' is palindrome permutation: true
        The word 'world' is palindrome permutation: false
      */
      System.out.printf("The word '%s' is palindrome permutation: %b\n", str, palindromePermutation(str));
    }
  }
}
