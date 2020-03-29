public class Conversion {
  public static int getBitsNumber(int a, int b) {
    int xor = a ^ b;
    int bitsNumber = 0;

    while (xor != 0) {
      if ((xor & 1) != 0) {
        bitsNumber++;
      }

      xor >>>= 1;
    }

    return bitsNumber;
  }

  public static void main(String[] args) {
    // Diff bits number for numbers 16 and 15 is 5
    System.out.printf("Diff bits number for numbers %d and %d is %d\n", 16, 15, getBitsNumber(16, 15));
  }
}
