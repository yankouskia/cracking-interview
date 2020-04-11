import java.util.BitSet;

public class MissingInt {
  public static int getMissing(int[] numbers) {
    BitSet set = new BitSet(Integer.MAX_VALUE);

    for (int i = 0; i < numbers.length; i++) {
      set.set(numbers[i], true);
    }

    for (int i = 0; i < set.length(); i++) {
      if (!set.get(i)) return i;
    }
    return -1;
  }

  public static void main(String[] strings) {
    int[] numbers = { 0, 9,8,7,6,5,4,3,2,1,14,13,12,11,15,16,17,18 };

    // The missing int is: 10
    System.out.printf("The missing int is: %d\n", getMissing(numbers));
  }
}
