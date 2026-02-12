package Amazon;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int arr[] = new int[] { 2, 7, 11, 15 };
        int target = 9;
        withoutHashmap(arr, target);

    }

    public static void withHashmap(int arr[], int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            int rem = target - arr[i];
            if (hm.containsKey(rem)) {
                int j = hm.get(rem);
                if (i < j) {
                    System.out.println(arr[i] + "-" + rem);
                }
            }
        }
    }

    public static void withoutHashmap(int arr[], int target) {

        Arrays.sort(arr);

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {

            int sum = arr[i] + arr[j];

            if (sum == target) {

                System.out.println(arr[i] + "-" + arr[j]);

                i++;
                j--;

                // skip duplicates
                while (i < j && arr[i] == arr[i - 1])
                    i++;
                while (i < j && arr[j] == arr[j + 1])
                    j--;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
    }

}
