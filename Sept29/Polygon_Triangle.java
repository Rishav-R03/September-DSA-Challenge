class Polygon_Triangle {
    int n;
    private int dp[][];

    public int getMinimumArea(int n, int[] values) {
        dp = new int[n][n];
        return helper(0, n - 1, values);
    }

    public int helper(int i, int j, int[] values) {
        if (j - i < 2) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < n - 1; k++) {
            min = Math.min(min, values[i] * values[j] * values[k] + helper(i, k, values) + helper(k, n - 1, values));
        }
        return dp[i][j];
    }
}