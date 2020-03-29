public class Debugger {
  public static int debugger(int n) {
    return (n & (n - 1));
  }
  public static void main(String[] args) {
    // It returns 0 only in case n == 2 ** K
    System.out.printf("For n = %d, (n & (n - 1)) = %d\n", 8, debugger(8));
    System.out.printf("For n = %d, (n & (n - 1)) = %d\n", 256, debugger(256));
  }
}
