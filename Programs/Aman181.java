public class Aman181 {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 4, 9, 3, 4, 1 };
        int m = 2;
        int k = 2;
        System.out.println(GetMinDays(arr, m, k));
    }

    public static int GetMinDays(int arr[], int m, int k) {
        if ((long) m * k > arr.length)
            return -1;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }

        }

        int low = min;
        int high = max;
        int res = min;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (canMake(arr, m, k, mid) == true) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static boolean canMake(int arr[], int m, int k, int days) {

        int total = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= days) {
                count++;
            } else {
                count = 0;
            }

            if (count == k) {
                count = 0;
                total++;
            }

            if (total == m) {
                return true;
            }
        }
        return false;
    }

}
