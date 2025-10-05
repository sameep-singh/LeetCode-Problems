class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pac = new boolean[m][n], atl = new boolean[m][n];
        Queue<int[]> pq = new LinkedList<>(), aq = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0});
            aq.offer(new int[]{i, n - 1});
            pac[i][0] = atl[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new int[]{0, j});
            aq.offer(new int[]{m - 1, j});
            pac[0][j] = atl[m - 1][j] = true;
        }
        
        bfs(heights, pq, pac);
        bfs(heights, aq, atl);
        
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pac[i][j] && atl[i][j]) res.add(Arrays.asList(i, j));
        return res;
    }

    void bfs(int[][] h, Queue<int[]> q, boolean[][] vis) {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int m = h.length, n = h[0].length;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int r = cur[0] + d[0], c = cur[1] + d[1];
                if (r < 0 || c < 0 || r >= m || c >= n || vis[r][c] || h[r][c] < h[cur[0]][cur[1]]) continue;
                vis[r][c] = true;
                q.offer(new int[]{r, c});
            }
        }
    }
}
