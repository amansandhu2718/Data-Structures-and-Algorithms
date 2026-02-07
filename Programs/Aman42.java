public class Aman42 {
    public static void main(String[] args) {

        // Merge sort
        int arr[] = new int[] { 5, 9, 8, 2, 1 };
        arr = MergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static int[] MergeSort(int arr[], int low, int high) {
        if (low == high) {
            int[] base = new int[1];

            base[0] = arr[low];
            return base;
        }
        int mid = (low + high) / 2;
        int arr1[] = MergeSort(arr, low, mid);
        int arr2[] = MergeSort(arr, mid + 1, high);
        int Res[] = MergeSortedArrays(arr1, arr2);
        return Res;
    }

    public static int[] MergeSortedArrays(int[] arr1, int[] arr2) {

        int arr[] = new int[arr1.length + arr2.length];
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        while (i1 < arr1.length && i2 < arr2.length) {

            if (arr1[i1] < arr2[i2]) {

                arr[i] = arr1[i1];
                i1++;
            } else if (arr2[i2] < arr1[i1]) {

                arr[i] = arr2[i2];
                i2++;
            } else {

                arr[i] = arr1[i1];
                i++;
                arr[i] = arr2[i2];
                i1++;
                i2++;
            }

            i++;
        }

        while (i1 < arr1.length) {
            arr[i] = arr1[i1];
            i++;
            i1++;
        }

        while (i2 < arr2.length) {
            arr[i] = arr2[i2];
            i++;
            i2++;
        }

        return arr;
    }
}
