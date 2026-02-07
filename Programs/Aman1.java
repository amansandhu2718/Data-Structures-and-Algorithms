public class Aman1 {

    /**
     * 
     * rain water trapping
     * 
     * @param args
     */
    public static void main(String[] args) {

        int arr[] = new int[] { 4, 2, 0, 3, 2, 5 };
        int arrLeft[] = new int[arr.length];
        int arrRight[] = new int[arr.length];

        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            arrLeft[i] = max;
        }
        max = arr[arr.length - 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
            }
            arrRight[i] = max;
        }

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {

            int res = Math.min(arrLeft[i], arrRight[i]);
            res = res - arr[i];
            sum = sum + res;
        }

        System.out.println(sum);
        // for(int i=0;i<arrLeft.length;i++){
        // System.out.print(arrLeft[i]+" ");
        // }

        // System.out.println();
        // for(int i=0;i<arrRight.length;i++){
        // System.out.print(arrRight[i]+" ");
        // }

    }
}
