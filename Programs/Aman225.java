public class Aman225 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("recursion : " + CountPaths(n));
        System.out.println("memo : " + CountPathsDP(n, new int[n + 1]));
        System.out.println("tabulation : " + CountPathsDP_tabulation(n, new int[n + 1]));
    }

    public static int CountPathsDP_tabulation(int n, int arr[]) {

        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int sum = 0;
            for (int j = 1; j <= 3 && i - j >= 0; j++) {
                sum = sum + arr[i - j];
            }
            arr[i] = sum;
        }
        return arr[n];
    }

    /**
     * this is memoization
     * 
     * @param n
     * @param arr
     * @return
     */
    public static int CountPathsDP(int n, int arr[]) {

        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (arr[n] != 0) {
            return arr[n];
        }

        int sum = 0;
        for (int i = 1; i <= 3; i++) {
            sum = sum + CountPaths(n - i);
        }
        arr[n] = sum;
        return sum;
    }

    public static int CountPaths(int n) { // very bad code
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= 3; i++) {
            sum = sum + CountPaths(n - i);
        }
        return sum;
    }
}
