class Solution {
    public String largestGoodInteger(String num) {
        String maxGood = "";
        for (int i = 0; i < num.length() - 2; i++) {
            String curr = num.substring(i, i + 3);
            if (curr.charAt(0) == curr.charAt(1) && curr.charAt(1) == curr.charAt(2)) {
                if (maxGood.isEmpty() || curr.charAt(0) > maxGood.charAt(0)) {
                    maxGood = curr;
                }
            }
        }
        return maxGood;        
    }
}