public class Aman89 {
    /**
     * Count how many subarrays of size k have a sum exactly equal to X
     * 
     * @param args
     */
    public static void main(String[] args) {
        int arr[] = new int[] { 100, 200, 200, 300, 400 };
        int k = 2;
        int x = 400;
        int i = 0, j = 0;
        int sum = 0;
        int count = 0;

        while (i < k) {
            sum = sum + arr[i];
            i++;
        }
        if (sum == x) {
            count++;
        }

        while (i < arr.length) {
            sum = sum + arr[i];
            sum = sum - arr[j];

            if (sum == x) {
                count++;
            }
            j++;
            i++;
        }
        System.out.println("ans: " + count);
    }
}
