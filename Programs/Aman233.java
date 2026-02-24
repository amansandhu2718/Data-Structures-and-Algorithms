import java.util.HashMap;

public class Aman233 {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4, 5, 10, 6, 7, 8, 9 };
        System.out.println(CheckPairsDivisible(arr, 5));
    }

    public static boolean CheckPairsDivisible(int arr[], int target) {

        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int rem = arr[i] % target;
            Integer val = mp.getOrDefault(rem, 0);
            mp.put(rem, val + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            int rem = arr[i] % target;

            if (rem == 0) {
                int freq = mp.get(rem);
                if (freq % 2 == 1) {
                    return false;
                }
            } else if (2 * rem == target) { // why not k/2 (this handles both even and odd case)
                int freq = mp.get(rem);
                if (freq % 2 == 1) {
                    return false;
                }
            } else {
                int freq = mp.get(rem);
                int otherFreq = mp.get(target - rem);
                if (freq != otherFreq) {
                    return false;
                }
            }
        }
        return true;
    }
}
