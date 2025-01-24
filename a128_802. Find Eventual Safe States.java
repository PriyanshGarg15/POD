class Solution 
{
    public boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited)
    {
        visited[node] = true;
        pathVisited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, pathVisited)) {
                    return true;
                }
            } else if (pathVisited[neighbor]) {
                return true;
            }
        }
        pathVisited[node] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, pathVisited);
            }
        }
        for (int i = 0; i < V; i++) {
            if (!pathVisited[i]) {
                safeNodes.add(i);
            }
        }


        return safeNodes;
    }
}
