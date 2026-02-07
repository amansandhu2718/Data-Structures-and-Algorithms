
import java.util.ArrayList;
import java.util.HashSet;

public class Aman142 {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] { 1, 2, 3, 4, 100, 300, 301, 1, 2 }));
    }

    // Longest Consecutive Sequence
    public static int longestConsecutive(int[] nums) {

        HashSet<Integer> hs = new HashSet<Integer>();

        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }

        for (Integer key : hs) {
            int keyCpy = key;
            if (!hs.contains(keyCpy - 1)) {
                int count = 1;
                while (hs.contains(keyCpy + 1)) {
                    count++;
                    keyCpy = keyCpy + 1;
                }
                // System.out.println(count);
                if (count > max) {
                    max = count;

                }
            }
        }
        return max;
    }
}
