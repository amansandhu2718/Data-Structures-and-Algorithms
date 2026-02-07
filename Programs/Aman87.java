
public class Aman87 {

    /**
     * Return an array of averages of all contiguous subarrays of size k
     *
     */
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 4, 2, 10, 23, 3, 1, 0, };
        int k = 3;

        int i = 0, j = 0;
        int sum = 0;
        int resPointer = 0;
        int x = arr.length - k + 1;
        System.out.println("x is : " + x);
        // --------------------------------------
        // ! formula:
        // * how many windows of size k in array ?
        // n - k + 1
        // --------------------------------------
        float arrRes[] = new float[x];
        while (i < k) {
            sum = sum + arr[i];
            i++;
        }
        arrRes[resPointer] = (float) sum / k;
        resPointer++;
        while (i < arr.length) {
            sum = sum + arr[i];
            sum = sum - arr[j];
            System.out.println(resPointer);
            arrRes[resPointer] = (float) sum / k;
            resPointer++;

            j++;
            i++;
        }
        for (int l = 0; l < arrRes.length; l++) {
            System.out.println("window" + l + " " + arrRes[l]);
        }
    }
}
