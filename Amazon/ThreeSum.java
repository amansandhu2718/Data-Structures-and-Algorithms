package Amazon;

import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {

        int arr[] = { 10, 10, 20, 20, 30, 40, 40, 50, 60, 70, 80, 90 };
        int target = 100;

        Arrays.sort(arr);

        for (int k = 0; k < arr.length - 2; k++) {

            if (k > 0 && arr[k] == arr[k - 1])
                continue;

            int i = k + 1;
            int j = arr.length - 1;
            int tar = target - arr[k];

            while (i < j) {

                int sum = arr[i] + arr[j];

                if (sum == tar) {

                    System.out.println(arr[k] + "-" + arr[i] + "-" + arr[j]);

                    i++;
                    j--;

                    // Skip duplicates
                    while (i < j && arr[i] == arr[i - 1])
                        i++;
                    while (i < j && arr[j] == arr[j + 1])
                        j--;
                } else if (sum < tar) {
                    i++;
                } else {
                    j--;
                }
            }
        }
    }
}
