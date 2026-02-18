public class Aman70 {
    public static void main(String[] args) {

        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        System.out.println(BinarySearch(arr, 2));
    }

    public static int BinarySearch(int arr[], int x) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + ((high - low) / 2);

            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
