class Solution {
    public void dfs(int i, int j, int[][] newGrid) {
        int n = newGrid.length;
        if (i < 0 || j < 0 || i >= n || j >= n || newGrid[i][j] == 0) {
            return;
        }
        newGrid[i][j] = 0;
        dfs(i + 1, j, newGrid);
        dfs(i - 1, j, newGrid);
        dfs(i, j + 1, newGrid);
        dfs(i, j - 1, newGrid);
    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] newGrid = new int[n * 3][n * 3];
        for (int i = 0; i < n * 3; i++) {
            for (int j = 0; j < n * 3; j++) {
                newGrid[i][j] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '/') {
                    newGrid[i * 3][j * 3 + 2] = 0;
                    newGrid[i * 3 + 1][j * 3 + 1] = 0;
                    newGrid[i * 3 + 2][j * 3] = 0;
                }
                if (c == '\\') {
                    newGrid[i * 3][j * 3] = 0;
                    newGrid[i * 3 + 1][j * 3 + 1] = 0;
                    newGrid[i * 3 + 2][j * 3 + 2] = 0;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n * 3; i++) {
            for (int j = 0; j < n * 3; j++) {
                if (newGrid[i][j] == 1) {
                    ans++;
                    dfs(i, j, newGrid);
                }
            }
        }

        return ans;
    }
}
