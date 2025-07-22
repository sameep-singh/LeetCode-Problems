class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int maxSum = 0;
        int i = 0;;

        for(int j = 0; j < nums.length; j++) {
            while(set.contains(nums[j])) {
                set.remove(nums[i]);
                sum -= nums[i];
                i++;

            }
            set.add(nums[j]);
            sum += nums[j];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;        
    }
}