class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int minVal = Integer.MAX_VALUE;
        int countNeg = 0;
        long sum = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                sum += Math.abs(matrix[i][j]);
                minVal = Math.min(minVal, Math.abs(matrix[i][j]));
                if (matrix[i][j] < 0) {
                    countNeg++;
                }
            }
        }
        if (countNeg % 2 == 0) {
            return sum;
        }
        return sum - 2 * minVal;
    }
}
