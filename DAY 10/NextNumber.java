public class NextNumber {
  public static int previous(int n) {
    boolean canStart = false;

    for (int i = 0; i < 32; i++) {
      if ((n & (1 << i)) == 0) {
        canStart = true;
      } else {
        if (canStart) {
          return n - (1 << (i - 1));
        }
      }
    }

    return 0;
  }

  public static int next(int n) {
    boolean canStart = false;

    for (int i = 0; i < 32; i++) {
      if ((n & (1 << i)) == 0) {
        if (canStart) {
          return n + (1 << (i - 1));
        }
      } else {
        canStart = true;
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    /*
      1000
      100
      10000
      10010
      10001
      10100
    */
    System.out.println(Integer.toBinaryString(8));
    System.out.println(Integer.toBinaryString(previous(8)));
    System.out.println(Integer.toBinaryString(next(8)));

    System.out.println(Integer.toBinaryString(18));
    System.out.println(Integer.toBinaryString(previous(18)));
    System.out.println(Integer.toBinaryString(next(18)));
  }
}
