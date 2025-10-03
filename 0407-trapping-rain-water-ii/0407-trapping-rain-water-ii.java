import java.util.*;

class Solution {
    public int trapRainWater(int[][] h) {
        int m = h.length, n = h[0].length;
        if (m < 3 || n < 3) return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] v = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{h[i][0], i, 0});
            pq.offer(new int[]{h[i][n - 1], i, n - 1});
            v[i][0] = v[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new int[]{h[0][j], 0, j});
            pq.offer(new int[]{h[m - 1][j], m - 1, j});
            v[0][j] = v[m - 1][j] = true;
        }
        int res = 0;
        int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            int ht = c[0], x = c[1], y = c[2];
            for (int[] dir : d) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || v[nx][ny]) continue;
                res += Math.max(0, ht - h[nx][ny]);
                pq.offer(new int[]{Math.max(ht, h[nx][ny]), nx, ny});
                v[nx][ny] = true;
            }
        }
        return res;
    }
}
