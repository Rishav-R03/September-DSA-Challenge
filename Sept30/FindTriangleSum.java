package Sept30;

class Solution {
    public int triangularSum(int[] nums) {
        for (int size = nums.length; size > 1; size--) {
            for (int i = 0; i < size - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }
        return nums[0];
    }
}
