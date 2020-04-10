public class SearchInRotatedArray {
  public static int find(int[] arr, int search, int left, int right) {
    if (right < left) return -1;
    int midIndex = (left + right) / 2;

    if (arr[midIndex] == search) return midIndex;

    if (arr[left] < arr[midIndex]) {
      if (search < arr[midIndex] && search >= arr[left]) {
        return find(arr, search, left, midIndex - 1);
      } else {
        return find(arr, search, midIndex + 1, right);
      }
    } else if (arr[right] > arr[midIndex]) {
      if (search > arr[midIndex] && search <= arr[right]) {
        return find(arr, search, midIndex + 1, right);
      } else {
        return find(arr, search, left, midIndex - 1);
      }
    } else {
      int result = find(arr, search, midIndex + 1, right);
      if (result == -1) return find(arr, search, left, midIndex - 1);
      return result;
    }
  }

  public static int find(int[] arr, int search) {
    return find(arr, search, 0, arr.length - 1);
  }

  public static void main(String[] args) {
    int[] arr = { 7, 8, 9, 10, 1, 2, 3, 4, 5, 6 };

    /*
      1
      2
      5
      6
      8
    */
    System.out.println(find(arr, 8));
    System.out.println(find(arr, 9));
    System.out.println(find(arr, 2));
    System.out.println(find(arr, 3));
    System.out.println(find(arr, 5));
  }
}
