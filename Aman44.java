public class Aman44 {

    public static void main(String[] args) {
        // Selection sort
        int arr[] = new int[] { 2, 1, 3, 4, 5, 6, 3, 4, 5, 99, 10 };
        SelectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void SelectionSort(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            int indexOfSnallest = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[indexOfSnallest]) {
                    indexOfSnallest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[indexOfSnallest];
            arr[indexOfSnallest] = temp;
        }
    }
}
