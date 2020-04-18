public class SubSort {
  public static int[] subSort(int[] arr) {
    int brokenStart = 0;
    int brokenEnd = arr.length - 1;

    for (int i = 0; i < arr.length - 1; i++) {
      brokenStart = i + 1;
      if (arr[i + 1] < arr[i]) {
        break;
      }
    }

    for (int i = arr.length - 1; i > 0; i--) {
      brokenEnd = i - 1;
      if (arr[i - 1] > arr[i]) {
        break;
      }
    }

    int brokenMin = Integer.MAX_VALUE;
    int brokenMax = Integer.MIN_VALUE;

    for (int i = brokenStart; i < arr.length; i++) {
      if (arr[i] < brokenMin) {
        brokenMin = arr[i];
      }
    }

    for (int i = brokenEnd; i >= 0; i--) {
      if (arr[i] > brokenMax) {
        brokenMax = arr[i];
      }
    }


    int startIndex = 0;
    int endIndex = arr.length - 1;

    for (int i = 0; i <= brokenStart; i++) {
      if (arr[i] > brokenMin) {
        startIndex = i;
        break;
      }
    }

    for (int i = arr.length - 1; i >= brokenEnd; i--) {
      if (arr[i] < brokenMax) {
        endIndex = i;
        break;
      }
    }

    int[] result = { startIndex, endIndex };
    return result;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 };

    // Start index: 3. End index: 9
    System.out.println("Start index: " + subSort(arr)[0] + ". End index: " + subSort(arr)[1]);
  }
}
