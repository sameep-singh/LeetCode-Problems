class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> needTeach = new HashSet<>();
        
        for (int[] f : friendships) {
            Set<Integer> set = new HashSet<>();
            for (int lan : languages[f[0] - 1]) set.add(lan);
            boolean can = false;
            for (int lan : languages[f[1] - 1]) 
                if (set.contains(lan)) { can = true; break; }
            if (!can) {
                needTeach.add(f[0] - 1);
                needTeach.add(f[1] - 1);
            }
        }

        int[] freq = new int[n + 1];
        int max = 0;
        for (int u : needTeach)
            for (int lan : languages[u])
                max = Math.max(max, ++freq[lan]);

        return needTeach.size() - max;
        
    }
}