import java.util.BitSet;

public class FindDuplicates {
  public static void printDuplicates(int[] numbers) {
    BitSet set = new BitSet(32001);

    for (int i = 0; i < numbers.length; i++) {
      if (set.get(numbers[i])) {
        System.out.println(numbers[i]);
      }
      set.set(numbers[i]);
    }
  }

  public static void main(String[] args) {
    int[] numbers = { 1, 1, 100, 3, 4, 5, 123, 100, 98, 543, 321, 45, 123, 4, 9, 543, 5643, 12341, 543 };

    /*
      1
      100
      123
      4
      543
      543
    */
    printDuplicates(numbers);
  }
}
