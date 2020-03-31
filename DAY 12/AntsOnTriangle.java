public class AntsOnTriangle {
  public static double getCollisionProbability(int vertices) {
    double waysNumber = Math.pow(2, vertices);
    return 1.0 - 2.0 / waysNumber;
  }

  public static void main(String[] args) {
    /*
      Probability of collision in 3-vertex polygon is 0.7500000
      Probability of collision in 4-vertex polygon is 0.8750000
      Probability of collision in 5-vertex polygon is 0.9375000
      Probability of collision in 6-vertex polygon is 0.9687500
      Probability of collision in 7-vertex polygon is 0.9843750
      Probability of collision in 8-vertex polygon is 0.9921875
      Probability of collision in 9-vertex polygon is 0.9960938
      Probability of collision in 10-vertex polygon is 0.9980469
      Probability of collision in 11-vertex polygon is 0.9990234
      Probability of collision in 12-vertex polygon is 0.9995117
      Probability of collision in 13-vertex polygon is 0.9997559
      Probability of collision in 14-vertex polygon is 0.9998779
      Probability of collision in 15-vertex polygon is 0.9999390
      Probability of collision in 16-vertex polygon is 0.9999695
      Probability of collision in 17-vertex polygon is 0.9999847
      Probability of collision in 18-vertex polygon is 0.9999924
      Probability of collision in 19-vertex polygon is 0.9999962
      Probability of collision in 20-vertex polygon is 0.9999981
    */
    for (int i = 3; i <= 20; i++) {
      System.out.printf("Probability of collision in %d-vertex polygon is %.7f\n", i, getCollisionProbability(i));
    }
  }
}
