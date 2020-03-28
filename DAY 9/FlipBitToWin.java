public class FlipBitToWin {
  public static int flipBit(int n) {
    if (~n == 0) {
      return Integer.BYTES * 8;
    }

    int currentLength = 0;
    int previousLength = 0;
    int max = 0;

    while (n != 0) {
      if ((n & 1) == 1) {
        currentLength++;
      } else {
        previousLength = (n & 2) == 0 ? 0 : currentLength;
        currentLength = 0;
      }

      max = Math.max(previousLength + currentLength + 1, max);
      n >>>= 1;
    }

    return max;
  }

  public static void main(String[] args) {
    int n = 1775;

    // 8
    System.out.println(flipBit(n));
  }
}
