public class Aman178 {
    public static void main(String[] args) {

        int num = 36;
        System.out.println(getSquareRoot(num));
    }

    public static int getSquareRoot(int n) {
        int low = 1;
        int high = n;
        int res = 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (mid * mid <= n) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}
