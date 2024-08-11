class Solution {
    public final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int m;
    public int n;

    public void DFS(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0)
            return;

        visited[i][j] = true; // mark visited
        for (int[] dir : directions) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            DFS(grid, new_i, new_j, visited);
        }
    }

    public int numberOfIslandsDFS(int[][] grid) {
        boolean[][] visited = new boolean[m][n];
        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) { // DFS
                    islands++;
                    DFS(grid, i, j, visited);
                    
                }
            }
        }

        return islands;
    }

    public int minDays(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int islands = numberOfIslandsDFS(grid);


        if (islands > 1 || islands == 0) {
            return 0;
        } 
        else {
            // Check for 1 move
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        grid[i][j] = 0;
                        
                        islands = numberOfIslandsDFS(grid);
                        
                        grid[i][j] = 1; 

                        if (islands > 1 || islands == 0) {
                            return 1;
                        }
                    }
                }
            }
        }

        return 2;
    }
}
