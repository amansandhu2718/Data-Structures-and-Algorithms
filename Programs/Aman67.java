
public class Aman67 {
    public static void main(String[] args) {
        int arr[] = new int[] { 11, 5, 2, 1, 2, 1, 1 };
        int x = 3;
        System.out.println(subarray(arr, x));
    }

    // longest subarray with amtmost k odd numbers
    public static int subarray(int arr[], int x) {

        int maxLength = 0;
        int j = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {

            // expansion

            if (arr[i] % 2 != 0) {
                count++;
            }

            // shrink
            while (count > x) {
                if (arr[j] % 2 != 0) {
                    count--;
                }
                j++;
            }
            // check condition
            maxLength = Math.max(maxLength, i - j + 1);

        }
        return maxLength;
    }
}
