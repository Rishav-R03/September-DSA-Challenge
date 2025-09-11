/**
 * Find the closes sum to target and return that.
 */
public class P3_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int minSum = Integer.MAX_VALUE / 2;
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int curSum = nums[i] + nums[l] + nums[r];
                if (Math.abs(curSum - target) < Math.abs(minSum - target)) {
                    minSum = curSum;
                }
                if (curSum < target) {
                    l++;
                } else if (curSum > target) {
                    r--;
                } else {
                    return curSum;
                }
            }
        }
        return minSum;
    }
}
