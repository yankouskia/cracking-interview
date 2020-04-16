public class ReturnFinally {
  public static int test() {
    try {
      return 1;
    } catch(Exception e) {
      return 2;
    } finally {
      return 3;
    }
  }
  public static void main(String[] args) {
    // 3
    System.out.println(test());
  }
}
