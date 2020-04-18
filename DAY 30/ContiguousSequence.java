public class ContiguousSequence {
  public static int maxSum(int[] arr) {
    int[] normalized = new int[arr.length];

    int index = 0;
    normalized[index] = arr[index];
    boolean isPositive = normalized[index] > 0;

    for (int i = 1; i < arr.length; i++) {
      if ((isPositive && arr[i] > 0) || (!isPositive && arr[i] < 0)) {
        normalized[index] += arr[i];
      } else {
        isPositive = !isPositive;
        normalized[++index] = arr[i];
      }
    }

    int sum = 0;
    int maxSum = 0;
    for (int i = 0; i <= index; i++) {
      sum += normalized[i];
      if (sum > maxSum) {
        maxSum = sum;
      }

      if (sum < 0) {
        sum = 0;
      }
    }

    return maxSum;
  }

  public static void main(String[] args) {
    // Max sum is: 5
    int[] arr = { 2, -8 , 3, -2, 4, -16 };
    System.out.println("Max sum is: " + maxSum(arr));

    // Max sum is: 7
    int[] arr2 = { 2, 3, -8, -1, 2, 4, -2, 3 };
    System.out.println("Max sum is: " + maxSum(arr2));
  }
}
