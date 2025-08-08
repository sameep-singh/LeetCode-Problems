class Solution {
    public double soupServings(int n) {
        if (n >= 4800) return 1.0;
        int s = (n + 24) / 25;
        double[][] dp = new double[s + 1][s + 1];
        for (double[] r : dp) java.util.Arrays.fill(r, -1);
        return f(s, s, dp);
    }
    private double f(int a, int b, double[][] dp) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;
        if (dp[a][b] != -1) return dp[a][b];
        return dp[a][b] = 0.25 * (
            f(Math.max(a-4,0), b, dp) +
            f(Math.max(a-3,0), Math.max(b-1,0), dp) +
            f(Math.max(a-2,0), Math.max(b-2,0), dp) +
            f(Math.max(a-1,0), Math.max(b-3,0), dp)
        );
    }
}
