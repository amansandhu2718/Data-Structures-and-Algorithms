
import java.util.ArrayList;
import java.util.HashSet;

public class Aman144 {
    public static void main(String[] args) {

        int arr[] = intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 });
        for (int num : arr) {
            System.out.println(num);
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<>();

        for (int num : nums1) {
            hs.add(num);
        }

        // for (int num : hs) {
        // System.out.println(num);
        // }

        ArrayList<Integer> arr = new ArrayList<>();
        for (int num : nums2) {
            if (hs.contains(num)) {
                arr.add(num);
                hs.remove(num);
            }
        }

        int[] result = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }

        return result;
    }
}
