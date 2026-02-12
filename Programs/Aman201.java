public class Aman201 {
    public static void main(String[] args) {

        int Pages[] = { 5, 10, 30, 20, 15 };
        int k = 3;
        System.out.println(PainterPartition(Pages, k));
    }

    public static int PainterPartition(int arr[], int k) {
        int res = 0;
        // max = if we allot all boards to 1 painter
        // min = if we have num of painter = num of board then biggest board's paining
        // time will be min time
        int high = 0;
        int low = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > low) {
                low = arr[i];
            }
            high = high + arr[i];
        }

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
        int painterCount = 1;
        int boardTimeSum = 0;

        for (int i = 0; i < arr.length; i++) {
            boardTimeSum = boardTimeSum + arr[i];

            if (boardTimeSum > mid) {
                painterCount++;
                boardTimeSum = arr[i];
            }

            if (painterCount > k) {
                return false;
            }
        }
        return true;
    }
}
// https://www.youtube.com/watch?v=JRAByolWqhw
