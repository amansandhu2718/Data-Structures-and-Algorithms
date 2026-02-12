public class Aman200 {
    public static void main(String[] args) {

        int Pages[] = { 15, 17, 20 };
        int k = 5;
        System.out.println(AllotBooks(Pages, k));
    }

    public static int AllotBooks(int arr[], int k) {

        if (k > arr.length) {
            return -1;
        }
        int res = Integer.MAX_VALUE;

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        int low = 0;
        int high = sum;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isValid(arr, k, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;

    }

    public static boolean isValid(int arr[], int k, int mid) {
        int st = 1;
        int pagesProvided = 0;
        for (int i = 0; i < arr.length; i++) {
            pagesProvided = pagesProvided + arr[i];

            if (pagesProvided > mid) {
                st++;
                pagesProvided = arr[i];
            }

            if (st > k) {
                return false;
            }
        }
        return true;
    }
}
// https://www.youtube.com/watch?v=JRAByolWqhw
