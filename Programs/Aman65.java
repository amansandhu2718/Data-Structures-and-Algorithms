import java.util.HashMap;

public class Aman65 {
    public static void main(String[] args) {
        int arr[] = new int[] { 2, 2, 2, 2 };
        int x = 6;
        System.out.println(getMinSizeSubarray(arr, x));
    }

    public static int getMinSizeSubarray(int arr[], int x) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int remaining = 0;
        mp.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            remaining = sum - x;
            if (mp.containsKey(remaining)) {
                int index = mp.get(remaining);
                int size = i - index;
                if (size < min) {
                    min = size;
                }
            }
            mp.put(sum, i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
