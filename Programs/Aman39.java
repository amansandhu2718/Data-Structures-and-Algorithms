public class Aman39 {
    public static void main(String[] args) {
        int arr[] = new int[] { 6, 4, 2, 1, 5, 5, 6, 4, 3, 2, 2, 2, 3 };
        System.out.println("partition index: " + Partition(arr, arr[arr.length - 1]));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int Partition(int arr[], int pivot) {

        // Region 1 (0 to j-1) -> less than equal to pivot
        // Region 2 (j to i-1) -> more than pivot
        // Region 3 (i to end) -> unknown

        int i = 0;
        int j = 0;
        while (i < arr.length) {
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

        return j - 1;

    }
}
