class Solution 
{
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) 
    {
        int[] answer = new int[queries.length];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(i + 1);
        }
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            graph.get(u).add(v);
            answer[i] = bfsShortestPath(graph, n);
        }

        return answer;
    }
    public int bfsShortestPath(List<List<Integer>> graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        queue.add(0);
        visited[0] = true;
        distance[0] = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1;
                    if (neighbor == n - 1) {
                        return distance[neighbor];
                    }
                }
            }
        }
        return -1;
    }
}
