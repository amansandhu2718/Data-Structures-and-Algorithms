package Subnumsays;

/**
 * Given an numsay of positive integers nums and a positive integer
 * target, return the minimal length of a subnumsay whose sum is
 * greater than or equal to target.
 * If there is no such subnumsay, return 0 instead.
 * 
 */
public class S1 {
    public static void main(String[] args) {
        int nums[] = new int[] { 1, 1, 1, 1, 1, 1, 1, 1 };
        int target = 11;
        System.out.println(minSubnumsayLen(target, nums));
    }

    public static int minSubnumsayLen(int target, int[] nums) {

        int i = 0;
        int j = 0;
        int sum = 0;
        int minSize = Integer.MAX_VALUE;
        int size = 0;
        while (i < nums.length) {
            sum = sum + nums[i];
            size++;
            if (sum >= target && size < minSize) {
                // System.out.println(size);
                minSize = size;
            }
            while (sum >= target) {
                sum = sum - nums[j];
                j++;
                size--;
                if (sum >= target && size < minSize) {
                    // System.out.println(size);
                    minSize = size;
                }
            }

            i++;
        }
        if (minSize == Integer.MAX_VALUE) {
            minSize = 0;
        }
        return minSize;
    }
}
