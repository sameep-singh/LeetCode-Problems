class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long current = 0;
        for (int num : nums) {
            if (num == 0) {
                current++;
                ans += current;
            } else {
                current = 0;
            }
        }
        return ans; 
    }
}