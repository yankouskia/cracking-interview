public class FinalEtc {
  public static final int data = 5;

  protected void finalize() throws Throwable {
    System.out.println("The automatic garbage collector calls the finalize method just before actually destroying the object");
  }

  public static void finallyTest() {
    try {} catch (Exception e) {} finally {
      System.out.println("Always called");
    }
  }

  public static void main(String[] args) {

  }
}
