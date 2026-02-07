import java.util.Arrays;

public class Aman46 {

    // Three sum
    public static void main(String[] args) {

        int arr[] = new int[] { -1, 0, 1, 2, -1, -4 };
        int target = 0;
        ThreeSumHandleDuplicates(arr, target);
    }

    public static void ThreeSum(int arr[], int target) {

        int arrNew[] = new int[arr.length];
        System.arraycopy(arr, 0, arrNew, 0, arr.length);
        Arrays.sort(arrNew);
        for (int k = 0; k < arrNew.length; k++) {
            int i = k + 1;
            int j = arrNew.length - 1;

            while (i < j) {
                int sum = arrNew[i] + arrNew[j] + arrNew[k];
                if (sum == target) {
                    System.out.println("val: " + arrNew[i] + " val: " + arrNew[j] + " val:" + arrNew[k]);
                    j--;
                    i++;
                } else if (sum < target) {
                    i++;
                } else { // sum > target
                    j--;
                }
            }
        }

        // note : if you want to return index you have to create pair
    }

    public static void ThreeSumHandleDuplicates(int arr[], int target) {

        int arrNew[] = new int[arr.length];
        System.arraycopy(arr, 0, arrNew, 0, arr.length);
        Arrays.sort(arrNew);
        for (int k = 0; k < arrNew.length - 2; k++) {
            if (k > 0 && arrNew[k] == arrNew[k - 1])
                continue; // Skip duplicate k

            int i = k + 1;
            int j = arrNew.length - 1;

            while (i < j) {
                int sum = arrNew[i] + arrNew[j] + arrNew[k];
                if (sum == target) {
                    System.out.println("val: " + arrNew[k] + " val: " + arrNew[i] + " val: " + arrNew[j]);
                    // Skip duplicate i
                    while (i < j && arrNew[i] == arrNew[i + 1]) {
                        i++;
                    }
                    // Skip duplicate j
                    while (i < j && arrNew[j] == arrNew[j - 1]) {
                        j--;
                    }
                    i++;
                    j--;
                } else if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        // note : if you want to return index you have to create pair
    }
}
