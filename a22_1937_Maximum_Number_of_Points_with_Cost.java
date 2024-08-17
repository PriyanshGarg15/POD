class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length, 
        n = points[0].length;
        long[][] arr = new long[m][n];
        for (int i = 0; i < n; i++) {
            arr[0][i] = points[0][i];
        }
        long max = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = 0;
                for (int k = 0; k < n; k++) {
                    max = Math.max(max, points[i][j] + arr[i - 1][k] - Math.abs(j - k));
                }
                arr[i][j] = max;
            }
        }
        
        max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(arr[m - 1][i], max);
        }

        return max;
    }
}
