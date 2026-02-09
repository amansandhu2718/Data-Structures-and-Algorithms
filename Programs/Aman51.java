public class Aman51 {
    public static void main(String[] args) {
        // first occurance and last occurance

        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 7, 8, 9 };
        int x = 7;
        System.out.println(GetFirstOccurance(arr, x));
        System.out.println(GetLastOccurance(arr, x));

    }

    public static int GetFirstOccurance(int arr[], int x) {
        int res = -1;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + (high - low) / 2);
            if (arr[mid] == x) {
                res = mid;
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return res;
    }

    public static int GetLastOccurance(int arr[], int x) {
        int res = -1;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + (high - low) / 2);
            if (arr[mid] == x) {
                res = mid;
                low = mid + 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return res;
    }
}
