public class StingRotation {
  /*
    Just imagine this is that existing external isSubstring function
    which identifies if one string is part of another one
  */
  public static boolean isSubstring(String main, String part) {
    return main.indexOf(part) != -1;
  }

  public static boolean stringRotation(String first, String second) {
    if (first.length() != second.length()) return false;

    /*
      If sizes of string and potential rotated string are equal
      then "doubled" initial string will definitely include its own rotation
    */
    return isSubstring(first + first, second);
  }

  public static void main(String[] args) {
    String[][] testStringsPairs = {
      { "waterbottle", "erbottlewat" },
      { "waterbottle", "rbottlewate" },
      { "hello", "olleh" },
      { "hello", "llohe" },
      { "hell", "llohe" },
    };

    for (String[] stringsPair: testStringsPairs) {
      /*
        String 'waterbottle' is rotation of string 'erbottlewat': true
        String 'waterbottle' is rotation of string 'rbottlewate': true
        String 'hello' is rotation of string 'olleh': false
        String 'hello' is rotation of string 'llohe': true
        String 'hell' is rotation of string 'llohe': false
      */
      System.out.printf("String '%s' is rotation of string '%s': %b\n", stringsPair[0], stringsPair[1], stringRotation(stringsPair[0], stringsPair[1]));
    }
  }
}
