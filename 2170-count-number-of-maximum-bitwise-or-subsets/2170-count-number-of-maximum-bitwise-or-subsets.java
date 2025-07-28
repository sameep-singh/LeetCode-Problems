class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int max=0,res=0;
        for(int x : nums) max|=x;
        for(int i=1;i<1<<n;i++)
        {
            int or=0;
            for(int j=0;j<n;j++)
            {
                if(((i>>j)&1)==1)or=or|nums[j];
            }
            if(or==max)res++;
        }
        return res;
    }
}