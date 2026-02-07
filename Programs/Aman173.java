public class Aman173 {
    public static void main(String[] args) {
        // search in rotated sorted array. [unique elements]
        int arr[] = new int[] { 3, 4, 5, 6, 0, 1, 2 };
        int x = 2;
        System.out.println(Search(arr, x));
    }

    public static int Search(int arr[], int x) {
        int res = -1;

        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {

            int mid = low + ((high - low) / 2);
            if (arr[mid] == x) {
                res = mid;
                break;
            } else {

                if (arr[low] <= arr[mid]) { // left is sorted
                    if (arr[low] <= x && x < arr[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else { // right half is sorted
                    if (arr[mid] < x && x <= arr[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }

            }

        }

        return res;
    }
}
