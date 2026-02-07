
public class Aman145 {
    public static void main(String[] args) {
        System.out.println("ans: " + firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
    }

    public static int firstMissingPositive(int[] nums) {
        System.out.println("range (1-" + nums.length + ")");
        boolean isOnePresent = false;
        // make all outof range elements = 1 and check if 1 was present
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                isOnePresent = true;
            }
            if (nums[i] < 1 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }

        // if one was missing then 1 is positive int

        if (isOnePresent == false) {
            return 1;
        }
        // if 1 is presnt then another num is missing and now check which no is missing
        // go to arr[i]-1 index and make element negative;

        for (int i = 0; i < nums.length; i++) {
            // go to arr[i]-1 index and make element negative;
            int index = Math.abs(nums[i]);
            index = index - 1;
            nums[index] = -Math.abs(nums[index]);
        }

        // iterate and go to first positive value. here index +1 value is answer

        for (int num : nums) {
            System.out.println(num);
        }
        int res = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res = i + 1;
                break;
            }
        }

        return res;
    }
}
