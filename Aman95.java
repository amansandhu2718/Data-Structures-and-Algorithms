public class Aman95 {
    // Given a binary array, find the maximum number of 1s in any subarray of size
    // k.
    public static void main(String[] args) {
        int arr[] = new int[] { 0, 1, 1, 0, 0, 1, 0, 1, 1, 1 };

        int k = 4;

        int i = 0, j = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        while (i < k) {
            sum = sum + arr[i];
            i++;
        }
        max = sum;

        while (i < arr.length) {
            sum = sum + arr[i];
            sum = sum - arr[j];

            if (sum > max) {
                max = sum;
            }
            j++;
            i++;
        }
        System.out.println("ans: " + max);
    }
}
