public class Aman41 {
    public static void main(String[] args) {
        // Insertion sort

        int arr[] = new int[] { 5, 9, 8, 2, 1 };

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // move elements greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}