class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            indegree[edge[1]]++;
        }
        int startPoint = 0;
        int champion = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                startPoint++;
                champion = i;
            }
        }
        return startPoint == 1 ? champion : -1;
    }
}
