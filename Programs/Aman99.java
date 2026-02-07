
public class Aman99 {
    // Find the minimum length subarray whose sum is ≥ k.
    public static void main(String[] args) {
        int arr[] = new int[] { 2, 3, 1, 2, 4, 3 };
        int k = 7;

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < arr.length; i++) {
            // expand
            sum = sum + arr[i];
            // shrink
            while (sum >= k) {
                if (((i - j) + 1) < min) { // compare and assign answer after all expansion on all shrinks
                    min = (i - j) + 1;
                }
                sum = sum - arr[j];
                j++;
            }
            // compare and assign answer after all expansion and all shrinks
            // no code
        }
        System.out.println(min);
    }
}
