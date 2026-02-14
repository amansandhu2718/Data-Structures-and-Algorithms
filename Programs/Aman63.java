public class Aman63 {
    public static void main(String[] args) {
        // max sum subarray of length k
        int arr[] = new int[] { -4, -2, -8, -1 };
        int k = 2;
        if (k > arr.length) {
            throw new IllegalArgumentException("k is larget than arr");
        }
        int sum = 0;
        int maxsum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + arr[i];
        }
        maxsum = sum;

        for (int i = k; i < arr.length; i++) {
            sum = sum + arr[i];
            sum = sum - arr[i - k];
            if (sum > maxsum) {
                maxsum = sum;
            }
        }
        System.out.println(maxsum);
    }
}
