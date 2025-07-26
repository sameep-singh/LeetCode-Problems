class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
        for (int[] p : conflictingPairs) adj[Math.max(p[0], p[1])].add(Math.min(p[0], p[1]));

        long ans = 0, a = 0, b = 0, maxB = 0;
        long[] bonus = new long[n + 1];

        for (int r = 1; r <= n; r++) {
            for (int l : adj[r]) { if (l > a) { b = a; a = l; } else if (l > b) b = l; }
            ans += r - a;
            if (a > 0) bonus[(int)a] += a - b;
        }
        for (long x : bonus) maxB = Math.max(maxB, x);
        return ans + maxB;
    }
}