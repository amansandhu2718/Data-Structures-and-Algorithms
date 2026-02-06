public class Aman94 {
    /**
     * Find the maximum sum subarray of size k that contains exactly k odd numbers.
     * 
     * 
     */
    public static void main(String[] args) {
        int arr[] = new int[] { 100, 201, 300, 400 };
        int k = 3;

        int i = 0, j = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int count = 0;
        while (i < k) {
            sum = sum + arr[i];
            if (arr[i] % 2 != 0) {
                count++;
            }
            i++;
        }
        if (count == 1) {
            max = sum;
        }

        while (i < arr.length) {
            if (arr[i] % 2 != 0) {
                count++;
            }
            if (arr[j] % 2 != 0) {
                count--;
            }
            sum = sum + arr[i];
            sum = sum - arr[j];

            if (count == 1) {
                if (sum > max) {
                    max = sum;
                }
            }
            j++;
            i++;
        }
        if (max != Integer.MIN_VALUE) {
            System.out.println("ans: " + max);
        } else {
            System.out.println("condition not met");
        }
    }
}
