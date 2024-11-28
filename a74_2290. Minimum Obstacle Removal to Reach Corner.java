import java.util.PriorityQueue;

class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dir = {-1, 0, 1, 0, -1};
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[]{0, 0, 0}); // {cost, x, y}
        visited[0][0] = true;
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int cost = curr[0];
            int x = curr[1];
            int y = curr[2];
            if (x == m - 1 && y == n - 1) {
                return cost;
            }
            for (int i = 0; i < 4; ++i) {
                int newX = x + dir[i];
                int newY = y + dir[i + 1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    if (grid[newX][newY] == 1) {
                        minHeap.offer(new int[]{cost + 1, newX, newY});
                    } else {
                        minHeap.offer(new int[]{cost, newX, newY});
                    }
                }
            }
        }
        return 0;
    }
}
