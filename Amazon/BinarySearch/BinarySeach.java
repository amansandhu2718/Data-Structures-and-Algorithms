package Amazon.BinarySearch;

import javax.swing.text.Position;

public class BinarySeach {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 1, 3, 5, 6, 4 };

        // System.out.println(BinarySeachh(arr, 0, arr.length - 1, 3));

        // System.out.println(SearchInsertPosition(arr, 0, arr.length - 1, 7));

        // System.out.println(GetBadVersionIndex(1, 1, 1));

        // int res[] = FirstAndLastIndex(arr, 0, arr.length - 1, 3);
        // System.out.println("RESULT: " + res[0] + " - " + res[1]);

        // System.out.println(PeakElement(arr));

        // System.out.println(SearchInRotatedSorted(new int[] { 1 }, 3));

        System.out.println(KokoEatingBanana(new int[] { 30, 11, 23, 4, 20 }, 5));
    }

    public static int KokoEatingBanana(int arr[], int h) {
        int low = 1;
        int high = h;

        for (int bananas : arr) {
            high = Math.max(high, bananas);
        }

        int res = -1;
        while (low <= high) {
            int mid = (low + (high - low) / 2);
            if (canEatBanana(arr, h, mid) == true) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static boolean canEatBanana(int arr[], int h, int mid) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            int val = (int) Math.ceil(arr[i] * 1.0 / mid);
            sum = sum + val;

            if (sum > h) {
                return false;
            }
        }

        return true;
    }

    public static int SearchInRotatedSorted(int arr[], int x) {
        int low = 0;
        int high = arr.length - 1;
        int res = -1;
        while (low <= high) {
            int mid = (low + (high - low) / 2);

            if (arr[mid] == x) {
                res = mid;
                break;
            } else if (arr[low] <= arr[mid]) {// standin on left part
                if (x >= arr[low] && x < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (x > arr[mid] && x <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return res;
    }

    public static int PeakElement(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        int res = -1;
        while (low <= high) {
            int mid = (low + (high - low) / 2);

            boolean leftOK = (mid == 0) || (arr[mid] >= arr[mid - 1]);
            boolean rightOK = (mid == arr.length - 1) || (arr[mid] >= arr[mid + 1]);

            // Peak condition
            if (leftOK && rightOK) {
                return mid;
            } else if (!rightOK) {// left of peak
                low = mid + 1;
            } else {// right of peak
                high = mid - 1;
            }
        }
        return res;
    }

    public static int BinarySeachh(int arr[], int low, int high, int x) {

        while (low <= high) {
            int mid = (low + (high - low) / 2);
            if (arr[mid] == x) {
                return mid;
            } else if (x < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int SearchInsertPosition(int arr[], int low, int high, int x) {
        int res = arr.length;
        while (low <= high) {
            int mid = (low + (high - low) / 2);
            if (arr[mid] >= x) {
                res = mid;
                high = mid - 1;
            } else {

                low = mid + 1;
            }
        }
        return res;
    }

    public static int GetBadVersionIndex(int low, int high, int x) {
        int res = -1;
        while (low <= high) {
            int mid = (low + (high - low) / 2);
            if (mid >= x) {
                res = mid;
                high = mid - 1;
            } else {

                low = mid + 1;
            }
        }
        return res;
    }

    // LC: 34. Find First and Last Position of Element in Sorted Array

    public static int[] FirstAndLastIndex(int arr[], int m_low, int m_high, int x) {
        int low = m_low;
        int high = m_high;

        int res[] = new int[] { -1, -1 };
        while (low <= high) {
            int mid = (low + (high - low) / 2);
            if (arr[mid] == x) {
                res[0] = mid;
                high = mid - 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {

                low = mid + 1;
            }
        }

        if (res[0] == -1) {
            return res;
        }

        low = m_low;
        high = m_high;

        while (low <= high) {
            int mid = (low + (high - low) / 2);
            if (arr[mid] == x) {
                res[1] = mid;
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}
