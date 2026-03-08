import java.util.HashMap;

public class Aman66 {
    public static void main(String[] args) {
        int arr[] = new int[] { 11, 5, 1, 1, 1 };
        int x = 6;
        System.out.println(subarray(arr, x));
    }

    // max size subarray having sum atmost k
    public static int subarray(int arr[], int x) {

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {

            // expansion
            sum = sum + arr[i];

            // shrink
            while (sum > x) {
                sum = sum - arr[j];
                j++;

            }
            // check condition
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
