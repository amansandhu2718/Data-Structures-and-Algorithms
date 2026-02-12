public class Aman198 {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        int k = 3;
        System.out.println(subarraySum2(arr, k));

    }

    public static int subarraySum(int[] arr, int x) {

        int len = 0;
        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                String s = "";
                for (int k = i; k <= j; k++) {
                    sum = sum + arr[k];
                    s = s + arr[k] + " ";
                }
                if (sum == x && (j - i + 1) > len) {
                    len = j - i + 1;
                }
            }

        }

        return len;
    }

    public static int subarraySum2(int[] arr, int x) {

        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                if (sum == x && (j - i + 1) > len) {
                    len = j - i + 1;
                }
            }

        }
        return len;
    }

    public static int subarraySum3(int[] arr, int x) {

        int count = 0;
        int longLen = 0;
        int prefixSUm = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSUm = prefixSUm + arr[i];
            if (prefixSUm == x) {
                count++;
            }
        }
        return count;
    }

}

// https://www.youtube.com/watch?v=frf7qxiN2qU