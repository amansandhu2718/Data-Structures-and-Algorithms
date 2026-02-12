import java.util.Arrays;

public class Aman199 {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 8, 9 };
        int k = 3;
        Arrays.sort(arr);
        int min = arr[0];
        int max = arr[arr.length - 1];
        int low = 1;
        int high = max - min;
        int res = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (CanPlace(arr, k, mid)) {
                low = mid + 1;
                res = mid;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(res);
    }

    public static boolean CanPlace(int arr[], int cows, int dist) {
        int lastCowIndex = 0;
        int cowsUsed = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[lastCowIndex] >= dist) {
                cowsUsed++;
                lastCowIndex = i;
            }
            if (cowsUsed == cows) {
                return true;
            }
        }
        return false;
    }
}
