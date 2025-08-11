class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int mod = 1000000007;
        ArrayList<Integer> powers = new ArrayList<>();
        for (int i = 0; i <= 31; i++)
            if ((n & (1 << i)) != 0) powers.add(1 << i);
        
        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            long prod = 1;
            for (int i = queries[q][0]; i <= queries[q][1]; i++)
                prod = (prod * powers.get(i)) % mod;
            ans[q] = (int) prod;
        }
        return ans;
    }
}
