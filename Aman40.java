public class Aman40 {

    // BUbble sort
    public static void main(String[] args) {
        int arr[] = { 1, 4, 3, 5, -1, 3, -5 };

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int num : arr) {
            System.out.println(num);
        }
    }
}
