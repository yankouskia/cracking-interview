public class Basketball {
  public static String getOption(double p) {
    double noHits = Math.pow(1 - p, 3);
    double oneHit = 3 * p * (1 - p) * (1 - p);
    double secondOptionProbability = 1 - noHits - oneHit;

    return p >= secondOptionProbability ? "first option" : "second option";
  }

  public static void main(String[] args) {
    /*
      For probability = 0.00 - better to choose first option
      For probability = 0.05 - better to choose first option
      For probability = 0.10 - better to choose first option
      For probability = 0.15 - better to choose first option
      For probability = 0.20 - better to choose first option
      For probability = 0.25 - better to choose first option
      For probability = 0.30 - better to choose first option
      For probability = 0.35 - better to choose first option
      For probability = 0.40 - better to choose first option
      For probability = 0.45 - better to choose first option
      For probability = 0.50 - better to choose first option
      For probability = 0.55 - better to choose second option
      For probability = 0.60 - better to choose second option
      For probability = 0.65 - better to choose second option
      For probability = 0.70 - better to choose second option
      For probability = 0.75 - better to choose second option
      For probability = 0.80 - better to choose second option
      For probability = 0.85 - better to choose second option
      For probability = 0.90 - better to choose second option
      For probability = 0.95 - better to choose second option
    */
    for (int i = 0; i < 20; i++) {
      System.out.printf("For probability = %.2f - better to choose %s\n", 0.05 * i, getOption(0.05 * i));
    }
  }
}
