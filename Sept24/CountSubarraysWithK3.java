package Sept24;

public class CountSubarraysWithK3 {
    public long countSubarrays(int[] nums, int k) {
        int maxi = Integer.MIN_VALUE;
        for (int n : nums)
            maxi = Math.max(maxi, n);
        int left = 0;
        long maxO = 0;
        long res = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == maxi)
                maxO++;
            while (maxO >= k) {
                if (nums[left] == maxi)
                    maxO--;
                left++;
            }
            res += left;
        }
        return res;
    }
}