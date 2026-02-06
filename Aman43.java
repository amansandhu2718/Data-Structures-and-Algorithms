public class Aman43 {
    public static void main(String[] args) {

        // Quick sort
        int arr[] = new int[] { 2, 4, 5, 3, 2, 1 };
        QuickSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void QuickSort(int arr[], int low, int high) {
        if (low > high) {
            return;
        }
        int pivot = arr[high];
        int pivotIndex = Partition(arr, pivot, low, high);
        QuickSort(arr, low, pivotIndex - 1);
        QuickSort(arr, pivotIndex + 1, high);
    }

    public static int Partition(int arr[], int pivot, int low, int high) {

        // Region 1 (0 to j-1) -> less than equal to pivot
        // Region 2 (j to i-1) -> more than pivot
        // Region 3 (i to end) -> unknown

        int i = low;
        int j = low;
        while (i <= high) {
            if (arr[i] > pivot) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
        }
        // System.out.println("partiton INdex: " + (j - 1));
        return j - 1;

    }

}
