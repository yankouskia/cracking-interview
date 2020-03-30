public class PairwiseSwap {
  public static int pairwiseSwap(int a) {
    int even = 0b10101010101010101010101010101010;
    int odd = even >>> 1;

    return ((even & a) >>> 1) | ((odd & a) << 1);
  }

  public static void main(String[] args) {
    int n = 2796202;
    // The swap of number 2796202 (1010101010101010101010) is 1398101 (101010101010101010101)
    System.out.printf("The swap of number %d (%s) is %d (%s)\n", n, Integer.toBinaryString(n), pairwiseSwap(n), Integer.toBinaryString(pairwiseSwap(n)));
  }
}
