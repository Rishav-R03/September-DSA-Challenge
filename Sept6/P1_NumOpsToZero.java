/**
 * You are given a 2D array queries, where queries[i] is of the form [l, r].
 * Each queries[i] defines an array of integers nums consisting of elements
 * ranging from l to r, both inclusive.
 * In one operation, you can:
 * Select two integers a and b from the array.
 * Replace them with floor(a / 4) and floor(b / 4).
 */

class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int i = 0; i < queries.length; i++) {
            long start = queries[i][0], end = queries[i][1];
            long ops = 0;
            for (long d = 1, prev = 1; d < 17; d++) {
                long cur = prev * 4;
                long l = Math.max(start, prev);
                long r = Math.min(end, cur - 1);
                if (r >= l) {
                    ops += (r - l + 1) * d;
                }
                prev = cur;
            }
            ans += (ops + 1) / 2;
        }
        return ans;
    }
}