public class TheHeavyPill {
  public static void main(String[] args) {
    double x = 1.0;
    double y = 1.1;

    int count = 20;
    int fake = 8;

    // make cart with i pills from i-th bottle
    double cart = 0;
    double expectedCart = 210 * x;

    for (int i = 1; i <= count; i++) {
      if (i == fake) {
        cart += y * i;
      } else {
        cart += x * i;
      }
    }

    // Fake bottle number is: 8
    System.out.printf("Fake bottle number is: %d\n", (int)((cart - expectedCart) / (y - x)));
  }
}
