public class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[m][n];
        minHeap.offer(new int[]{0, 0, 0});

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int cost = current[0], x = current[1], y = current[2];
            if (visited[x][y]) continue;
            visited[x][y] = true;
            if (x == m - 1 && y == n - 1) return cost;
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    int newCost = cost + (grid[x][y] == i + 1 ? 0 : 1);
                    minHeap.offer(new int[]{newCost, newX, newY});
                }
            }
        }

        return -1;
    }
}
