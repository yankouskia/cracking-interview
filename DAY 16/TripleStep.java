public class TripleStep {
  private static int getWays(int steps, int[] memo) {
    if (steps <= 0) return 0;
    if (steps == 1) return 1;

    if (memo[steps] != 0) return memo[steps];
    memo[steps] = getWays(steps - 1, memo) + getWays(steps - 2, memo) + getWays(steps - 3, memo);
    return memo[steps];
  }

  public static int getWays(int steps) {
    int[] memo = new int[steps + 1];
    return getWays(steps, memo);
  }

  public static void main(String[] args) {

    /*
      There are 1 ways to get 2th steps stair
      There are 2 ways to get 3th steps stair
      There are 4 ways to get 4th steps stair
      There are 7 ways to get 5th steps stair
      There are 13 ways to get 6th steps stair
      There are 24 ways to get 7th steps stair
      There are 44 ways to get 8th steps stair
      There are 81 ways to get 9th steps stair
      There are 149 ways to get 10th steps stair
      There are 274 ways to get 11th steps stair
      There are 504 ways to get 12th steps stair
      There are 927 ways to get 13th steps stair
      There are 1705 ways to get 14th steps stair
      There are 3136 ways to get 15th steps stair
      There are 5768 ways to get 16th steps stair
      There are 10609 ways to get 17th steps stair
      There are 19513 ways to get 18th steps stair
      There are 35890 ways to get 19th steps stair
      There are 66012 ways to get 20th steps stair
      There are 121415 ways to get 21th steps stair
      There are 223317 ways to get 22th steps stair
      There are 410744 ways to get 23th steps stair
      There are 755476 ways to get 24th steps stair
      There are 1389537 ways to get 25th steps stair
      There are 2555757 ways to get 26th steps stair
      There are 4700770 ways to get 27th steps stair
      There are 8646064 ways to get 28th steps stair
      There are 15902591 ways to get 29th steps stair
      There are 29249425 ways to get 30th steps stair
      There are 53798080 ways to get 31th steps stair
      There are 98950096 ways to get 32th steps stair
      There are 181997601 ways to get 33th steps stair
      There are 334745777 ways to get 34th steps stair
      There are 615693474 ways to get 35th steps stair
      There are 1132436852 ways to get 36th steps stair
    */
    for (int i = 2; i < 37; i+= 1) {
      System.out.printf("There are %d ways to get %dth steps stair\n", getWays(i), i);
    }
  }
}
