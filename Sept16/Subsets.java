import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        subset(0, nums, res, new ArrayList<>());
        return res;
    }

    private void subset(int i, int[] nums, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            list.add(nums[j]);
            subset(j + 1, nums, res, list);
            list.remove(list.size() - 1);
        }
    }
}
