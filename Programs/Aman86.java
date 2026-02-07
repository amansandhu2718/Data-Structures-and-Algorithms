
public class Aman86 {
    /*
     * Maximum Sum Subarray of Size K
     *
     * Input: arr[] = [100, 200, 300, 400], k = 2
     * Output: 700
     */

    public static void main(String[] args) {

        int arr[] = new int[] { 100, 200, 300, 400 };
        int k = 1;

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
