
public class MagicIndex {
  public static int findIndex(int[] arr, int start, int end) {
    if (start > end) return -1;

    int mid = (start + end) / 2;
    if (arr[mid] == mid) return mid;
    if (arr[mid] > mid) return findIndex(arr, start, mid - 1);
    return findIndex(arr, mid + 1, end);
  }

  public static int findIndex(int[] arr) {
    int start = 0;
    int end = arr.length - 1;

    return findIndex(arr, start, end);
  }
  public static void main(String[] args) {
    int[] arr = { -2, -1, 0, 1, 2, 5, 8, 10, 12 };
    System.out.println("Found index is " + findIndex(arr));
  }
}
