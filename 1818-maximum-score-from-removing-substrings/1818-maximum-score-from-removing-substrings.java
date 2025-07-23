class Solution {
    public int maximumGain(String s, int x, int y) {
        if (y > x) { 
            int t = x; x = y; y = t; 
            s = s.replace('a', '#').replace('b', 'a').replace('#', 'b'); 
        }

        int ans = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == 'a' && c == 'b') {
                sb.deleteCharAt(sb.length() - 1);
                ans += x;
            } else sb.append(c);
        }
        StringBuilder temp = new StringBuilder();
        for (char c : sb.toString().toCharArray()) {
            if (temp.length() > 0 && temp.charAt(temp.length() - 1) == 'b' && c == 'a') {
                temp.deleteCharAt(temp.length() - 1);
                ans += y;
            } else temp.append(c);
        }
        return ans;  
    }
}