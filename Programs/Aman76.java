public class Aman76 {
    public static void main(String[] args) {
        int arr[] = new int[] { 0, 1, 2, 2, 1, 1, 1, 1, 0, 0, 0 };
        SortZeroOnes(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void SortZeroOnes(int[] arr) {
        int i = 0, j = 0;
        int k = arr.length - 1;

        while (i <= k) {
            if (arr[i] == 0) {
                Swap(arr, i, j);
                j++;
                i++;
            } else if (arr[i] == 2) {
                Swap(arr, i, k);
                k--;
            } else {
                i++;
            }

        }
    }

    public static void Swap(int arr[], int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
