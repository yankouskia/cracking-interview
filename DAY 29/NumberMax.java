public class NumberMax {
  public static int maxNumber(int a, int b) {
    int diffA = a - b;
    int diffB = b - a;

    int signA = diffA >>> 31;
    int signB = diffB >>> 31;

    return signB * a + signA * b;
  }

  public static void main(String[] args) {
    int a = 500;
    int b = 10000;

    // 10000
    System.out.println(maxNumber(a, b));
  }
}
