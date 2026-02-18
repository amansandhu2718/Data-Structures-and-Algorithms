public class Aman72 {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        RotateArray(arr, 11);

        for (int e : arr) {
            System.out.println(e);
        }
    }

    public static void RotateArray(int arr[], int k) {
        if (k > arr.length) {
            k = k % arr.length;
        }
        System.out.println("K is : " + k);
        ReverseArray(arr, 0, arr.length - 1 - k);
        ReverseArray(arr, arr.length - k, arr.length - 1);
        ReverseArray(arr, 0, arr.length - 1);

    }

    public static void ReverseArray(int arr[], int i, int j) {
        int low = i;
        int high = j;

        while (low <= high) {

            int temp = arr[high];
            arr[high] = arr[low];
            arr[low] = temp;
            low++;
            high--;
        }
    }
}
