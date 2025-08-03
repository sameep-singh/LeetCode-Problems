import java.util.*;
public class Solution {
    public int maxTotalFruits(int[][] f, int s, int k) {
        int l = 0, sum = 0, ans = 0;
        for (int r = 0; r < f.length; r++) {
            sum += f[r][1];
            while (l <= r && 
                Math.min(Math.abs(s - f[l][0]) + (f[r][0] - f[l][0]),
                         Math.abs(s - f[r][0]) + (f[r][0] - f[l][0])) > k)
                sum -= f[l++][1];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
