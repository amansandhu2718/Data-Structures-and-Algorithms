
public class Aman98 {
    // Given an array of positive integers, find the longest subarray with sum ≤ k.
    public static void main(String[] args) {

        int arr[] = new int[] { 1, 1, 1, 1 };
        int k = 10;

        int sum = 0;
        int max = 0;
        for (int i = 0, j = 0; i < arr.length; i++) {
            // expand
            sum = sum + arr[i];
            // shrink
            while (sum > k) {
                sum = sum - arr[j];
                j++;
            }
            // compare and assign answer
            if (((i - j) + 1) > max) {
                max = (i - j) + 1;
            }
        }
        System.out.println(max);

    }
}
