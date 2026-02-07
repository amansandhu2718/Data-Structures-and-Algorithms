import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class Aman45 {
    // Two sum

    public static void main(String[] args) {

        System.out.println();
        int arr[] = new int[] { 5, 5, 2, 7, 4, 3, 8, };
        int target = 10;
        // MethodOne(arr, target);
        // System.out.println();
        // MethodTwo(arr, target);
        MethodThree(arr, target);
    }

    // using two pointers
    public static void MethodTwo(int arr[], int target) {

        System.out.println("using method  2 : ");
        int arrNew[] = new int[arr.length];
        System.arraycopy(arr, 0, arrNew, 0, arr.length);
        Arrays.sort(arrNew);
        int i = 0;
        int j = arrNew.length - 1;

        while (i < j) {
            int sum = arrNew[i] + arrNew[j];
            if (sum == target) {
                System.out.println("val: " + arrNew[i] + " val: " + arrNew[j]);
                j--;
                i++;
            } else if (sum < target) {
                i++;
            } else { // sum > target
                j--;
            }
        }

        // note : if you want to return index you have to create pair
    }

    // using hashmap
    public static void MethodOne(int arr[], int target) {
        System.out.println("using method  1 : ");
        HashMap<Integer, Integer> mymap = new HashMap<Integer, Integer>();

        // populating value to index map
        for (int i = 0; i < arr.length; i++) {
            mymap.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            int val = target - arr[i];
            if (mymap.containsKey(val)) {
                int j = mymap.get(val);
                if (i < j) {
                    System.out.println("i: " + i + " j: " + j);
                }
            }
        }
    }

    // using hashmap optimized
    public static void MethodThree(int arr[], int target) {
        System.out.println("using method  3 : ");
        HashMap<Integer, Integer> mymap = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            int val = target - arr[i];
            if (mymap.containsKey(val)) {
                int j = mymap.get(val);
                // if (i < j) {
                System.out.println("i: " + i + " j: " + j);
                // }
            } else {
                mymap.put(arr[i], i);

            }
        }
    }
}
