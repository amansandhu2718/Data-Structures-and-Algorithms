public class AMan174 {
    public static void main(String[] args) {
        // search in rotated sorted array. [duplicate elements]
        // older solution will not work for duplicate :arr= 3,2,1,3,3,3,3
        int arr[] = new int[] { 3, 2, 1, 3, 3, 3, 3 };
        int x = 2;
        System.out.println(Search(arr, x));
    }

    public static int Search(int arr[], int x) {

        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {

            int mid = low + ((high - low) / 2);
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] == arr[low] && arr[mid] == arr[high]) { // <---- only add this condition
                low = low + 1;
                high = high - 1;
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

        return -1;
    }
}
