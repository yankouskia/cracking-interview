public class Insertion {
  public static int insertion(int m, int n, int i, int j) {
    int ones = ~0;
    int jShiftOnes = ones << (j - i + 1);
    int onesI = (1 << (i + 1)) - 1;
    int ijEmpty = jShiftOnes | onesI;
    int mask = ijEmpty & m;

    System.out.println(Integer.toBinaryString(mask));
    System.out.println(Integer.toBinaryString(n));
    System.out.println(Integer.toBinaryString(n << (i - 1)));

    return mask + (n << (i - 1));
  }
  public static void main(String[] args) {
    int m = 0b10000000000;
    int n = 0b10011;

    int i = 2;
    int j = 6;

    int result = insertion(m, n, i, j);
    System.out.println(Integer.toBinaryString(result));
  }
}
