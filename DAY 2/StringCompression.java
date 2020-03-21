public class StringCompression {
  /*
    Getting compressed string length for 2 reasons:
    1. helps to avoid further calculations for cases, where final length is equal or more then initial
    2. be able to create an array of chars for final result with correspondent length
  */
  public static int getCompressedLength(String str) {
    int compressedLength = 0;
    int consequenceCount = 0;

    for (int i = 0; i < str.length(); i++) {
      consequenceCount++;

      if (i + 1 == str.length() || str.charAt(i + 1) != str.charAt(i)) {
        compressedLength += 1 + Integer.toString(consequenceCount).length();
        consequenceCount = 0;
      }
    }

    return compressedLength;
  }

  public static String stringCompression(String str) {
    // If there are 2 or less characters - compression will not help
    if (str.length() < 3) return str;

    int compressedLength = getCompressedLength(str);
    if (compressedLength >= str.length()) return str;

    char[] compressedChars = new char[compressedLength];
    int consequenceCount = 0;
    int currentCompressedIndex = 0;

    for (int i = 0; i < str.length(); i++) {
      consequenceCount++;

      if (i + 1 == str.length() || str.charAt(i + 1) != str.charAt(i)) {
        String repeatNumberString = Integer.toString(consequenceCount);
        compressedChars[currentCompressedIndex++] = str.charAt(i);

        for (int j = 0; j < repeatNumberString.length(); j++) {
          compressedChars[currentCompressedIndex++] = repeatNumberString.charAt(j);
        }

        consequenceCount = 0;
      }
    }

    return new String(compressedChars);
  }

  public static void main(String[] args) {
    String[] testStrings = { "", "ab", "abacabaaaa", "aaaabbbbbcccc", "dddddddddddddddddddddddddabccccc" };


    for (String str: testStrings) {
      /*
        The compressed version of string '' is ''
        The compressed version of string 'ab' is 'ab'
        The compressed version of string 'abacabaaaa' is 'abacabaaaa'
        The compressed version of string 'aaaabbbbbcccc' is 'a4b5c4'
        The compressed version of string 'dddddddddddddddddddddddddabccccc' is 'd25a1b1c5'
      */
      System.out.printf("The compressed version of string '%s' is '%s'\n", str, stringCompression(str));
    }
  }
}
