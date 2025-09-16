class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> numStack = new Stack<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while(!numStack.isEmpty()) {
                int stackNum = numStack.pop();
                int gcdNum = getGCD(num, stackNum);
                if(gcdNum > 1) {
                    num = num/gcdNum * stackNum;
                } else {
                    numStack.push(stackNum);
                    break;
                }
            }
            numStack.push(num);
        }
        return new ArrayList<>(numStack);
    }

    int getGCD(int a, int b) {
        if(a > b) {
            return getGCD(b, a);
        }
        return b%a==0 ? a : getGCD(b%a, a);
    }
}