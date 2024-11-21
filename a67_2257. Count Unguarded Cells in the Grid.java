class Solution {
    public void markGuarded(int row, int col, int[][] grid) {
        //top
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][col] == 2 || grid[i][col] == 3) {
                break;
            }
            grid[i][col] = 1;
        }

        // Down
        for (int i = row + 1; i < grid.length; i++) {
            if (grid[i][col] == 2 || grid[i][col] == 3) {
                break;
            }
            grid[i][col] = 1; 
        }

        // Left
        for (int j = col - 1; j >= 0; j--) {
            if (grid[row][j] == 2 || grid[row][j] == 3) {
                break;
            }
            grid[row][j] = 1;
        }

        // Right
        for (int j = col + 1; j < grid[0].length; j++) {
            if (grid[row][j] == 2 || grid[row][j] == 3) {
                break;
            }
            grid[row][j] = 1;
        }
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] guard : guards) {
            int i = guard[0];
            int j = guard[1];
            grid[i][j] = 2; // Guard
        }
        for (int[] wall : walls) {
            int i = wall[0];
            int j = wall[1];
            grid[i][j] = 3; // Wall
        }

        for (int[] guard : guards) {
            int i = guard[0];
            int j = guard[1];
            markGuarded(i, j, grid);
        }
        
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
