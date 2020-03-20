/*
 1. ASCII contains 128 characters
 2. Unicode:
    a. UTF-16 contains 65536 characters (16 bits for each character)
    b. UTF-32 contains 1073741824 characters (32 bits for each character)

  For this solution we imply that string consists of ASCII characters
 */

public class IsUnique {
  static final int MAX_CHARACTERS_COUNT = 128;

  public static boolean isUnique(String str) {
    // cache length
    int length = str.length();

    // if more then number of allowed characters return false immediately
    if (length > MAX_CHARACTERS_COUNT)
      return false;

    // keep array to check if one or other character was already caught
    boolean[] caughtCharacters = new boolean[MAX_CHARACTERS_COUNT];

    for (int i = 0; i < length; i++) {
      int charCode = str.charAt(i);
      if (caughtCharacters[charCode])
        return false;
      caughtCharacters[charCode] = true;
    }

    return true;
  }

  public static void main(String[] args) {
    String[] testStrings = { "Alex", "AAlex", "Aalex", "heLlo", "trololo", "!@#$%^&*(!" };

    for (int i = 0; i < testStrings.length; i++) {
      /*
        Word Alex contains unique characters: true
        Word AAlex contains unique characters: false
        Word Aalex contains unique characters: true
        Word heLlo contains unique characters: true
        Word trololo contains unique characters: false
        Word !@#$%^&*(! contains unique characters: false
       */
      System.out.printf("Word %s contains unique characters: %b\n", testStrings[i], isUnique(testStrings[i]));
    }
  }
}
