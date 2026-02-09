public class Aman176 {
    public static void main(String[] args) {
        int arr[] = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findMinimum(arr));
    }

    public static int findMinimum(int arr[]) {

        int low = 0, high = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high) {
            int mid = (low + (high - low) / 2);
            if (arr[low] <= arr[mid]) { // left is sorted
                if (arr[low] < min) {
                    min = arr[low];
                    index = low;
                }
                low = mid + 1;
            } else { // right is sorted
                if (arr[mid] < min) {
                    min = arr[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index;
    }
}
