public class Aman179 {
    public static void main(String[] args) {

        int num = 27;
        int root = 3;
        System.out.println(getSquareRoot(num, root));
    }

    public static int getSquareRoot(int n, int r) {

        int low = 1;
        int high = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            long val = getValue(mid, r, n);

            if (val == n) {
                return mid;
            }

            if (val < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // no perfect root
    }

    public static long getValue(int mid, int r, int n) {

        long res = 1;

        for (int i = 0; i < r; i++) {

            res *= mid;

            if (res > n) {
                return res; // early stop
            }
        }

        return res;
    }

}
