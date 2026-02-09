public class Aman177 {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6 };
        System.out.println(findSigleElement(arr));
    }

    public static int findSigleElement(int arr[]) {

        if (arr.length == 1) {
            return arr[0];
        }

        if (arr[1] != arr[0]) {
            return arr[0];
        }

        if (arr[arr.length - 1] != arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }

        // NOTE :
        // if iam at even index and on right there is same element then i am on left
        // half
        // if iam at odd index and on right there is same element then i am on right
        // half
        // eleminate that half on which iam at.

        // NOTE 2
        // If even index matches next element → you are in the correct pairing zone,
        // meaning the single element is on the RIGHT.
        int low = 1, high = arr.length - 2;
        while (low <= high) {
            int mid = (low + (high - low) / 2);
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            } else if (mid % 2 == 0) {
                if (arr[mid + 1] == arr[mid]) {
                    // i am at right half
                    high = mid - 1;
                } else {
                    // iam at left half
                    low = mid + 1;
                }
            } else {
                if (arr[mid - 1] == arr[mid]) {
                    // i am at left half
                    low = mid + 1;
                } else {
                    // iam at right half
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}