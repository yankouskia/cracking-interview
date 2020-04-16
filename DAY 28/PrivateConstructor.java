/*
This has direct implications for inheritance, since a subclass calls its parent's constructor. The class A can be
inherited, but only by its own or its parent's inner classes.
*/

public class PrivateConstructor {
  private int data;
  private PrivateConstructor(int n) {
    this.data = n;
  }

  public void check() {
    System.out.println(this.data);
  }

  class PrivateConstructor2 extends PrivateConstructor {
    public PrivateConstructor2() {
      super(10);
    }
  }

  public static void main(String[] args) {
  }
}
