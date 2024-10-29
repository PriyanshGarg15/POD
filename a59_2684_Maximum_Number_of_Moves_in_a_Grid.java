class Solution {
     public int[][] directions = {{-1, 1}, {0, 1}, {1, 1}}; 
     public int[][] memo; 
     public int maxMoves(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        memo = new int[rows][cols];
        int maxMoves = 0;

        for (int row = 0; row < rows; row++) {
            maxMoves = Math.max(maxMoves, dfs(grid, row, 0));
        }

        return maxMoves;
    }

    public int dfs(int[][] grid, int row, int col) {
        if (col == grid[0].length - 1) return 0; 
        if (memo[row][col] != 0) return memo[row][col];

        int maxMove = 0;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < grid.length && newCol < grid[0].length && grid[newRow][newCol] > grid[row][col]) {
                maxMove = Math.max(maxMove, 1 + dfs(grid, newRow, newCol));
            }
        }

        memo[row][col] = maxMove;
        return maxMove;
    }
}
