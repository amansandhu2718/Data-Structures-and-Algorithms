public class Aman226 {
    public static void main(String[] args) {
        int n = 6;
        int arr[] = new int[] { 3, 3, 0, 2, 2, 3 };
        System.out.println(countJumps(n, arr));
    }

    public static int countJumps(int n, int arr[]) {

        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int i = arr.length - 1; i >= 0; i--) {

            int sum = 0;
            for (int j = 1; j <= arr[i] && (i + j < dp.length); j++) {
                sum = sum + dp[i + j];
            }
            dp[i] = sum;
        }
        return dp[0];
    }
}
