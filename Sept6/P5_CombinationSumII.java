
/**
 * Just use each element only once
 */
import java.util.*;

public class P5_CombinationSumII {
    public List<List<Integer>> combinationSumII(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] nums, int target, int start, List<Integer> comb, List<List<Integer>> ans) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > target) {
                break;
            }
            comb.add(nums[i]);
            dfs(nums, target - nums[i], i + 1, comb, ans);
            comb.remove(comb.size() - 1);
        }
    }
}

/**
 * Step by Step Algorithm
 * Sort Candidates:
 * 
 * candidates.sort()
 * Sorts the candidates list in non-decreasing order. This is crucial for
 * ensuring that duplicates can be handled effectively and combinations are
 * generated in a predictable manner.
 * 
 * Initialize Result List:
 * 
 * res = []
 * Initializes an empty list res to store all valid combinations that sum up to
 * target.
 * Define Depth-First Search (DFS) Function dfs:
 * 
 * def dfs(target, start, comb):
 * Parameters:
 * target: Current remaining target sum to achieve.
 * start: Index to start exploring in the candidates list.
 * comb: Current combination being constructed.
 * Base Cases:
 * 
 * if target < 0:
 * return
 * if target == 0:
 * res.append(comb)
 * return
 * Checks if target is less than 0. If true, it means the current combination
 * cannot lead to a valid sum, so the function returns without further
 * exploration.
 * Checks if target equals 0. If true, it means comb sums up to the target, so
 * comb is added to res, and the function returns.
 * Iterate through Candidates:
 * 
 * for i in range(start, len(candidates)):
 * Iterates through the candidates list starting from index start. This loop
 * explores all possible candidates to include in the current combination.
 * Skip Duplicates:
 * 
 * if i > start and candidates[i] == candidates[i-1]:
 * continue
 * Skips duplicates to avoid generating duplicate combinations. This condition
 * ensures that only the first occurrence of each candidate value at any depth
 * of recursion is considered.
 * Check Candidate Value:
 * 
 * if candidates[i] > target:
 * break
 * Breaks out of the loop if the current candidate value exceeds the remaining
 * target. Since candidates is sorted, all subsequent values will also be
 * greater than target.
 * Recursive Call to dfs:
 * 
 * dfs(target - candidates[i], i + 1, comb + [candidates[i]])
 * Recursively calls dfs with:
 * Updated target by subtracting candidates[i].
 * Updated start to i + 1 to avoid reusing the same element.
 * Updated comb by adding candidates[i] to it, representing the current
 * combination being explored.
 * Initial Call to dfs:
 * 
 * dfs(target, 0, [])
 * Initiates the depth-first search by calling dfs with the initial parameters:
 * target (the original target sum), 0 (starting index in candidates), and an
 * empty list [] (initial empty combination).
 * Return Result List:
 * 
 * return res
 * Returns the list res containing all valid combinations found during the
 * depth-first search process.
 */
