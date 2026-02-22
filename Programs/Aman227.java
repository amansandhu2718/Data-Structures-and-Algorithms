public class Aman227 {
    public static void main(String[] args) {

        int arr[] = new int[] { 3, 2, 4, 2, 0, 2, 3, 1, 2, 2 };
        int n = arr.length;
        System.out.println(countJumps(n, arr));
    }

    public static int countJumps(int n, int arr[]) {

        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > 0) {

                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= arr[i] && (i + j < dp.length); j++) {
                    if (dp[i + j] != null) {
                        min = Math.min(min, dp[i + j]);
                    }
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                }
            }

        }
        return dp[0] == null ? -1 : dp[0];
    }
}
