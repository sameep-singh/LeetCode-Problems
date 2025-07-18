class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length;
        int k = n / 3;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long[] prefix = new long[n];
        long sum = 0;        
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
            sum += nums[i];
        }
        prefix[k - 1] = sum;
        for (int i = k; i < 2 * k; i++) {
            if (maxHeap.peek() > nums[i]) {
                prefix[i] = prefix[i - 1] - maxHeap.peek() + nums[i];
                maxHeap.poll();
                maxHeap.add(nums[i]);
            } else {
                prefix[i] = prefix[i - 1]; 
            }
        }        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long[] suffix = new long[n];
        sum = 0;
        for (int i = n - 1; i >= n - k;i--) {
            minHeap.add(nums[i]);
            sum += nums[i];
        }
        suffix[n - k] = sum;
        for (int i = n - k - 1; i >= k; i--) {
            if (minHeap.peek() < nums[i]) {
                suffix[i] = suffix[i + 1] - minHeap.peek() + nums[i];
                minHeap.add(nums[i]);
                minHeap.poll();
            } else {
                suffix[i] = suffix[i + 1]; 
            }
        }
        long ans = Long.MAX_VALUE;
        for (int i = k - 1; i < 2 * k; i++) {
            ans = Math.min(ans, prefix[i] - suffix[i + 1]);
        }
        return ans;  
    }
}