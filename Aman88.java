import java.util.HashMap;

public class Aman88 {
    // Find the maximum sum of a subarray of size k such that all elements are
    // distinct.
    public static void main(String[] args) {
        int arr[] = new int[] { 100, 200, 300, 400, 400 };
        int k = 2;

        HashMap<Integer, Integer> mymap = new HashMap<>();
        int i = 0, j = 0;
        int sum = 0;
        int max = 0;

        while (i < k) {

            if (mymap.containsKey(arr[i])) {
                mymap.put(arr[i], mymap.get(arr[i]) + 1);
            } else {
                mymap.put(arr[i], 1);
            }
            sum = sum + arr[i];
            i++;
        }
        if (mymap.size() == k) {
            max = sum;
        }

        while (i < arr.length) {
            sum = sum + arr[i];
            sum = sum - arr[j];

            if (mymap.containsKey(arr[i])) {
                mymap.put(arr[i], mymap.get(arr[i]) + 1);
            } else {
                mymap.put(arr[i], 1);
            }

            if (mymap.containsKey(arr[j]) && mymap.get(arr[j]) > 1) {
                mymap.put(arr[j], mymap.get(arr[j]) - 1);
            } else {
                mymap.remove(arr[j]);
            }

            if (mymap.size() == k && (sum > max)) {

                max = sum;

            }
            j++;
            i++;
        }
        System.out.println("ans: " + max);
    }
}
