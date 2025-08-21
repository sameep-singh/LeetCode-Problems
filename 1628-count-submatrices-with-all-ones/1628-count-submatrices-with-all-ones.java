class Solution {
    public int numSubmat(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int rectangleCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1 && i > 0) {
                    mat[i][j] += mat[i - 1][j];
                }
            }

            for (int j = 0; j < cols; j++) {
                int minHeight = mat[i][j];
                for (int k = j; k >= 0 && minHeight > 0; k--) {
                    minHeight = Math.min(minHeight, mat[i][k]);
                    rectangleCount += minHeight;
                }
            }
        }
        return rectangleCount;
    }
}