public class Aman57 {
    public static void main(String[] args) {
        int arr[] = { 0 };
        int n = 0;
        System.out.println(canPlace(arr, n));
    }

    public static boolean canPlace(int arr[], int n) {
        if (arr.length == 0) {
            return false;
        }
        if (arr.length == 1) {
            if (arr[0] == 0 && n <= 1) {
                return true;
            } else {
                return false;
            }
        }
        int i = 0;
        while (i < arr.length) {
            int val = arr[i];
            if (i == 0) {
                if (val == 0 && arr[1] == 0) {
                    n--;
                    arr[i] = 1;
                }
            } else if (i == arr.length - 1) {
                if (val == 0 && arr[arr.length - 2] == 0) {
                    n--;
                    arr[i] = 1;
                }
            } else {
                if (val == 0 && arr[i - 1] == 0 && arr[i + 1] == 0) {
                    n--;
                    arr[i] = 1;
                }
            }
            if (n == 0) {
                return true;
            }
            i++;
        }
        return false;
    }
}
