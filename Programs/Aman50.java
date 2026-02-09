public class Aman50 {
    public static void main(String[] args) {
        int arr[] = new int[] { 5, 2, 3, 4, };
        System.out.println(GetPeakElementIndex(arr));
    }

    public static int GetPeakElementIndex(int arr[]) {
        if (arr.length == 0) {
            return -1;
        }

        if (arr.length == 1) {
            return 0;
        }

        if (arr[0] > arr[1]) {
            return 0;
        }

        if (arr[arr.length - 1] > arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int low = 1;
        int high = arr.length - 2;

        while (low <= high) {

            // safer formula
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // move toward the increasing slope
            else if (arr[mid] > arr[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int clearnerGetPeakElementIndex(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1; // peak on right
            } else {
                high = mid; // peak on left or mid
            }
        }

        return low;
    }
}
