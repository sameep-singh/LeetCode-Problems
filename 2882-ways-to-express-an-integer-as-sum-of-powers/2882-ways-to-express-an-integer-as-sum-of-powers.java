class Solution {
    public int numberOfWays(int n, int x) {
        final int MOD = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; Math.pow(i, x) <= n; i++) {
            int p = (int) Math.pow(i, x);
            for (int s = n; s >= p; s--)
                dp[s] = (dp[s] + dp[s - p]) % MOD;
        }
        return dp[n];
    }
}
