class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts) return 1.0;

        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        double currProbSum = 1.0;
        double res = 0.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = currProbSum / maxPts;
            if (i < k) currProbSum += dp[i];
            else res += dp[i];
            if (i - maxPts >= 0) currProbSum -= dp[i - maxPts];
        }
        return res;
    }
}