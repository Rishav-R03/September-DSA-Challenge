package Sept25;

import java.util.Arrays;

public class MaxBeautyArray {
    public int maxBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int right = 0;
        int maxB = 0;
        for (int left = 0; left < nums.length; left++) {
            while (right < nums.length && nums[right] - nums[left] <= 2 * k) {
                right++;
            }
            maxB = Math.max(maxB, right - left);
        }
        return maxB;
    }
}
