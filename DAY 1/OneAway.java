public class OneAway {
  public static boolean oneAway(String first, String second) {
    // insert / delete is the same edit, if we will identify string with less length and string with more length
    String less = first.length() < second.length() ? first : second;
    String more = first.length() < second.length() ? second : first;

    int lessLength = less.length();
    int moreLength = more.length();

    // if difference in length more then 1 character we can break right here
    if (moreLength - lessLength > 1) return false;

    boolean isReplacement = moreLength == lessLength;
    boolean isDiffFound = false;

    int lessIndex = 0;

    for (int i = 0; i < moreLength && lessIndex < lessLength; i++) {
      if (less.charAt(lessIndex) == more.charAt(i)) {
        lessIndex++;
        continue;
      }

      // If diff is found the second time return false
      if (isDiffFound) return false;
      isDiffFound = true;

      if (isReplacement) {
        // if it's just replacement proceed with regular iteration, otherwise that character will be checked in next iteration
        lessIndex++;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    String[][] testStrings = { { "pale", "ple" }, { "pales", "pale" }, { "pale", "bale" }, { "pale", "bake" }, { "pales", "pall" } };

    for (String[] testPair: testStrings) {
      /*
        Words 'pale' and 'ple' are one away edit: true
        Words 'pales' and 'pale' are one away edit: true
        Words 'pale' and 'bale' are one away edit: true
        Words 'pale' and 'bake' are one away edit: false
        Words 'pales' and 'pall' are one away edit: false
      */
      System.out.printf("Words '%s' and '%s' are one away edit: %b\n", testPair[0], testPair[1], oneAway(testPair[0], testPair[1]));
    }
  }
}
