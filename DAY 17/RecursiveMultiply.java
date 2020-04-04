
public class RecursiveMultiply {
  public static int multiply(int first, int second) {
    int less = first > second ? second : first;
    int more = first > second ? first : second;

    if (less == 0) {
      return 0;
    }

    if (less == 1) {
      return more;
    }

    int halfLess = less >> 1;
    int addition = less % 2 == 1 ? more : 0;

    return (multiply(halfLess, more) << 1) + addition;
  }
  public static void main(String[] args) {
    // 1234000
    System.out.println(multiply(1234, 1000));
  }
}
