class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length, N = 1; 
        while (N < n) N <<= 1;
        int[] seg = new int[N << 1];
        for (int i = 0; i < n; i++) seg[N + i] = baskets[i];
        for (int i = N - 1; i > 0; i--) seg[i] = Math.max(seg[i << 1], seg[i << 1 | 1]);

        int unplaced = 0;
        for (int x : fruits) {
            if (seg[1] < x) { unplaced++; continue; }
            int idx = 1;
            while (idx < N) idx = (seg[idx << 1] >= x) ? idx << 1 : idx << 1 | 1;
            seg[idx] = -1;
            for (idx >>= 1; idx > 0; idx >>= 1) seg[idx] = Math.max(seg[idx << 1], seg[idx << 1 | 1]);
        }
        return unplaced;
    }
}
