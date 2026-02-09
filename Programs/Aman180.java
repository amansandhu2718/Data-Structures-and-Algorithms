public class Aman180 {
    public static void main(String[] args) {
        int arr[] = new int[] { 3, 6, 7, 11 };
        int h = 8;

        System.out.println(KokoEatingBanana(arr, h));
    }

    public static int KokoEatingBanana(int arr[], int h) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int low = 1;
        int high = max;
        int res = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            int reqTime = GetRequiredTime(arr, mid);
            if (reqTime <= h) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return res;
    }

    public static int GetRequiredTime(int arr[], int hourly) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count = count + (int) Math.ceil(arr[i] * 1.0 / hourly);
        }
        return count;
    }

}
