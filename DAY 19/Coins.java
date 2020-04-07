import java.util.Arrays;

public class Coins {
  public static int getWaysNumber(int n, int[] coins) {
    if (coins.length == 0) {
      return 0;
    }

    if (coins.length == 1) {
      return 1;
    }

    int biggestCoin = coins[coins.length - 1];
    int[] reducedCoins = Arrays.copyOf(coins, coins.length - 1);
    int ways = 0;

    for (int i = 0; i * biggestCoin <= n; i++) {
      ways += getWaysNumber(n - i * biggestCoin, reducedCoins);
    }

    return ways;
  }

  public static int getWaysNumber(int n) {
    int[] coins = { 1, 5, 10, 25, 50 };
    return getWaysNumber(n, coins);
  }

  public static void main(String[] args) {
    for (int i = 1; i <= 100; i++) {
      System.out.printf("%d cents could be exchanged in %d ways\n", i, getWaysNumber(i));
    }
  }
}

/*
  1 cents could be exchanged in 1 ways
  2 cents could be exchanged in 1 ways
  3 cents could be exchanged in 1 ways
  4 cents could be exchanged in 1 ways
  5 cents could be exchanged in 2 ways
  6 cents could be exchanged in 2 ways
  7 cents could be exchanged in 2 ways
  8 cents could be exchanged in 2 ways
  9 cents could be exchanged in 2 ways
  10 cents could be exchanged in 4 ways
  11 cents could be exchanged in 4 ways
  12 cents could be exchanged in 4 ways
  13 cents could be exchanged in 4 ways
  14 cents could be exchanged in 4 ways
  15 cents could be exchanged in 6 ways
  16 cents could be exchanged in 6 ways
  17 cents could be exchanged in 6 ways
  18 cents could be exchanged in 6 ways
  19 cents could be exchanged in 6 ways
  20 cents could be exchanged in 9 ways
  21 cents could be exchanged in 9 ways
  22 cents could be exchanged in 9 ways
  23 cents could be exchanged in 9 ways
  24 cents could be exchanged in 9 ways
  25 cents could be exchanged in 13 ways
  26 cents could be exchanged in 13 ways
  27 cents could be exchanged in 13 ways
  28 cents could be exchanged in 13 ways
  29 cents could be exchanged in 13 ways
  30 cents could be exchanged in 18 ways
  31 cents could be exchanged in 18 ways
  32 cents could be exchanged in 18 ways
  33 cents could be exchanged in 18 ways
  34 cents could be exchanged in 18 ways
  35 cents could be exchanged in 24 ways
  36 cents could be exchanged in 24 ways
  37 cents could be exchanged in 24 ways
  38 cents could be exchanged in 24 ways
  39 cents could be exchanged in 24 ways
  40 cents could be exchanged in 31 ways
  41 cents could be exchanged in 31 ways
  42 cents could be exchanged in 31 ways
  43 cents could be exchanged in 31 ways
  44 cents could be exchanged in 31 ways
  45 cents could be exchanged in 39 ways
  46 cents could be exchanged in 39 ways
  47 cents could be exchanged in 39 ways
  48 cents could be exchanged in 39 ways
  49 cents could be exchanged in 39 ways
  50 cents could be exchanged in 50 ways
  51 cents could be exchanged in 50 ways
  52 cents could be exchanged in 50 ways
  53 cents could be exchanged in 50 ways
  54 cents could be exchanged in 50 ways
  55 cents could be exchanged in 62 ways
  56 cents could be exchanged in 62 ways
  57 cents could be exchanged in 62 ways
  58 cents could be exchanged in 62 ways
  59 cents could be exchanged in 62 ways
  60 cents could be exchanged in 77 ways
  61 cents could be exchanged in 77 ways
  62 cents could be exchanged in 77 ways
  63 cents could be exchanged in 77 ways
  64 cents could be exchanged in 77 ways
  65 cents could be exchanged in 93 ways
  66 cents could be exchanged in 93 ways
  67 cents could be exchanged in 93 ways
  68 cents could be exchanged in 93 ways
  69 cents could be exchanged in 93 ways
  70 cents could be exchanged in 112 ways
  71 cents could be exchanged in 112 ways
  72 cents could be exchanged in 112 ways
  73 cents could be exchanged in 112 ways
  74 cents could be exchanged in 112 ways
  75 cents could be exchanged in 134 ways
  76 cents could be exchanged in 134 ways
  77 cents could be exchanged in 134 ways
  78 cents could be exchanged in 134 ways
  79 cents could be exchanged in 134 ways
  80 cents could be exchanged in 159 ways
  81 cents could be exchanged in 159 ways
  82 cents could be exchanged in 159 ways
  83 cents could be exchanged in 159 ways
  84 cents could be exchanged in 159 ways
  85 cents could be exchanged in 187 ways
  86 cents could be exchanged in 187 ways
  87 cents could be exchanged in 187 ways
  88 cents could be exchanged in 187 ways
  89 cents could be exchanged in 187 ways
  90 cents could be exchanged in 218 ways
  91 cents could be exchanged in 218 ways
  92 cents could be exchanged in 218 ways
  93 cents could be exchanged in 218 ways
  94 cents could be exchanged in 218 ways
  95 cents could be exchanged in 252 ways
  96 cents could be exchanged in 252 ways
  97 cents could be exchanged in 252 ways
  98 cents could be exchanged in 252 ways
  99 cents could be exchanged in 252 ways
  100 cents could be exchanged in 292 ways
*/
