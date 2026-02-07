public class Aman172 {
    public static void main(String[] args) {
        // lower bound
        // smallest index such that arr[index] >= x
        int arr[] = new int[] { 1, };
        int x = 4;
        System.out.println(getLowerBound(arr, x));
    }

    public static int getLowerBound(int arr[], int x) {

        int res = arr.length;
        if (arr.length == 0) {
            System.out.println("array is empty");
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int midElement = arr[mid];
            if (midElement > x) { // <------- lower bound contains equal also this is only difference
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (arr.length == res) {
            System.out.println("not found in array");
            return -1;
        }
        return res;
    }
}
