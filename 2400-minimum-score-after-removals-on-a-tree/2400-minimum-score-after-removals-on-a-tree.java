import java.util.*;

class Solution {
    int[] xor; Set<Integer>[] desc; List<Integer>[] g;

    void dfs(int u, int p, int[] nums) {
        xor[u] = nums[u]; desc[u].add(u);
        for (int v : g[u]) if (v != p) {
            dfs(v, u, nums);
            xor[u] ^= xor[v];
            desc[u].addAll(desc[v]);
        }
    }

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) { g[e[0]].add(e[1]); g[e[1]].add(e[0]); }
        xor = new int[n]; desc = new HashSet[n];
        for (int i = 0; i < n; i++) desc[i] = new HashSet<>();
        dfs(0, -1, nums);

        int total = xor[0], ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) for (int j = i + 1; j < n; j++) {
            int x1, x2, x3;
            if (desc[i].contains(j)) { x1 = xor[j]; x2 = xor[i] ^ xor[j]; x3 = total ^ xor[i]; }
            else if (desc[j].contains(i)) { x1 = xor[i]; x2 = xor[j] ^ xor[i]; x3 = total ^ xor[j]; }
            else { x1 = xor[i]; x2 = xor[j]; x3 = total ^ xor[i] ^ xor[j]; }
            ans = Math.min(ans, Math.max(x1, Math.max(x2, x3)) - Math.min(x1, Math.min(x2, x3)));
        }
        return ans;
    }
}
