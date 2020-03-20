public class Urlify {
  public static String urlify(String str, int strLength) {
    int numberOfSpaces = 0;

    for (int i = 0; i < strLength; i++) {
      if (str.charAt(i) == ' ') {
        numberOfSpaces++;
      }
    }

    char[] finalStringArr = new char[strLength + numberOfSpaces * 2];
    int currentIndex = 0;

    for (int i = 0; i < strLength; i++) {
      char currentChar = str.charAt(i);

      if (currentChar == ' ') {
        finalStringArr[currentIndex] = '%';
        finalStringArr[currentIndex + 1] = '2';
        finalStringArr[currentIndex + 2] = '0';

        currentIndex += 3;
      } else {
        finalStringArr[currentIndex] = currentChar;
        currentIndex++;
      }
    }

    return new String(finalStringArr);
  }

  public static void main(String[] strings) {
    String[] testStrings = { "Hello world", "A  L  E   X", "bye-bye", "yet another test string" };

    for (String str: testStrings) {
      /*
        Urlified version of word 'Hello world' is 'Hello%20world'
        Urlified version of word 'A  L  E   X' is 'A%20%20L%20%20E%20%20%20X'
        Urlified version of word 'bye-bye' is 'bye-bye'
        Urlified version of word 'yet another test string' is 'yet%20another%20test%20string'
      */
      System.out.printf("Urlified version of word '%s' is '%s'\n", str, urlify(str, str.length()));
    }
  }
}
