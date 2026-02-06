public class Aman75 {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1 };
        SortZeroOnes(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void SortZeroOnes(int[] arr) {
        int i = 0, j = 0;

        while (i < arr.length) {
            if (arr[i] == 0) {
                Swap(arr, i, j);
                j++;
            }
            i++;
        }
    }

    public static void Swap(int arr[], int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
