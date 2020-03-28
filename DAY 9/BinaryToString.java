public class BinaryToString {
  public static String getSequence(Double number) {
    int iteration = 0;
    String result = "";

    while (number != 0 && iteration < 32) {

      iteration++;
      Double currentBinary = Math.pow(0.5, iteration);

      System.out.println("number " + number);
      System.out.println("currentBinary " + currentBinary);
      System.out.println("iteration " + iteration);
      System.out.println("Math.pow(0.5, iteration) " + Math.pow(0.5, iteration));


      if (number >= currentBinary) {
        number -= currentBinary;
        result += "1";
      } else {
        result += "0";
      }
    }

    if (number != 0) return "ERROR!";
    return "0." + result;
  }
  public static void main(String[] args) {
    // System.out.println(getSequence(0.25));
    System.out.println(getSequence(0.1875));
    // System.out.println(getSequence(0.0000025));
  }
}
