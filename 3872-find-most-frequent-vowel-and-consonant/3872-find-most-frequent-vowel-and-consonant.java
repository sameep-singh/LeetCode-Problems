class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        int maxVowel = 0, maxConso = 0;
        for (char ch : s.toCharArray()) {
            int i = ch - 'a';
            freq[i]++;
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                maxVowel = Math.max(maxVowel, freq[i]);
            else
                maxConso = Math.max(maxConso, freq[i]);
        }
        return maxVowel + maxConso;     
    }
}