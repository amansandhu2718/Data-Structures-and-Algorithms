public class Aman71 {

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        ReverseArray(arr);
        for (int e : arr) {
            System.out.println(e);
        }
    }

    public static void ReverseArray(int arr[]) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int temp = arr[high];
            arr[high] = arr[low];
            arr[low] = temp;
            low++;
            high--;
        }
    }
}
