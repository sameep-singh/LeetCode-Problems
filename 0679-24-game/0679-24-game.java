class Solution {
    public boolean judgePoint24(int[] cards) {
        return helper(new double[]{cards[0], cards[1], cards[2], cards[3]});
    }
    
    private boolean helper(double[] nums) {
        int n = nums.length;
        if (n == 1) return Math.abs(nums[0] - 24) < 1e-6;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                double[] next = new double[n - 1];
                int idx = 0;
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) next[idx++] = nums[k];
                }
                for (double x : ops(nums[i], nums[j])) {
                    next[n - 2] = x;
                    if (helper(next)) return true;
                }
            }
        }
        return false;
    }
    
    private double[] ops(double a, double b) {
        return new double[]{a + b, a - b, b - a, a * b, a / b, b / a};
    }
}
