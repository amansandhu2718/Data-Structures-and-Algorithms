public class Aman80 {
    public static void main(String[] args) {

        int arr1[] = new int[] { 3, 20, 30, 40, 50 };
        int arr2[] = new int[] { 1, 2, 3, 4, 5 };

        int[] arr3 = MergeSortedArrays(arr1, arr2);
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }
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
