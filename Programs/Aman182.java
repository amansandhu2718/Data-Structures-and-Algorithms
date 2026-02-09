public class Aman182 {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;
        System.out.println(getLeastCapacity(arr, days));
    }

    public static int getLeastCapacity(int arr[], int days) {
        if (arr.length == 0) {
            return 0;
        }
        int high = 0;
        int low = 0;
        int res = -1;
        for (int i = 0; i < arr.length; i++) {
            high = high + arr[i];
            if (arr[i] > low) {
                low = arr[i];
            }
        }

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            // System.out.println(mid);
            if (canDeliver(arr, days, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }

    // Checks whether we can ship all packages within 'days'
    // if ship capacity is 'cap'
    public static boolean canDeliver(int arr[], int days, int cap) {

        int dayCount = 1; // Start shipping from day 1
        int currentLoad = 0; // Current weight loaded for the day

        for (int weight : arr) {

            // If adding this package exceeds capacity,
            // ship current load and move to next day
            if (currentLoad + weight > cap) {

                dayCount++; // Need one more day
                currentLoad = weight; // Start new day with this package

                // If days exceed allowed limit → capacity is insufficient
                if (dayCount > days) {
                    return false;
                }

            } else {

                // Otherwise, load the package on the same day
                currentLoad += weight;
            }
        }

        // Successfully shipped within given days
        return true;
    }
}
