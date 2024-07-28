class Solution {
    static class Edge {
        int target;
        long weight;
        Edge(int target, long weight) {
            this.target = target;
            this.weight = weight;
        }
    }
    
    static class Node implements Comparable<Node> {
        int vertex;
        long distance;
        Node(int vertex, long distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node other) {
            return Long.compare(this.distance, other.distance);
        }
    }

    // Memoization table for storing shortest distances
    public Map<Integer, long[]> memo = new HashMap<>();

    // Method to perform Dijkstra's algorithm with memoization
    public long[] dijkstra(List<List<Edge>> graph, int source) {
        if (memo.containsKey(source)) {
            return memo.get(source);
        }

        int V = graph.size(); // Number of vertices
        long[] dist = new long[V]; // Array to store the shortest distance to each vertex
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int u = currentNode.vertex;

            for (Edge edge : graph.get(u)) {
                int v = edge.target;
                long weight = edge.weight;

                // If a shorter path to v is found
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        memo.put(source, dist);
        return dist;
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = 26; // Number of characters in the alphabet
        List<List<Edge>> graph = new ArrayList<>(n);

        // Initialize the graph with empty lists for each character
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph based on the original, changed, and cost arrays
        for (int i = 0; i < original.length; i++) {
            graph.get(original[i] - 'a').add(new Edge(changed[i] - 'a', cost[i]));
        }

        long totalCost = 0;
        // For each character in the source, find the minimum cost to convert it to the corresponding character in target
        for (int i = 0; i < source.length(); i++) {
            char srcChar = source.charAt(i);
            char tgtChar = target.charAt(i);
            if (srcChar == tgtChar) continue;
            long[] distances = dijkstra(graph, srcChar - 'a');
            long costToConvert = distances[tgtChar - 'a'];
            if (costToConvert == Long.MAX_VALUE) {
                return -1; // If it's impossible to convert one character to another
            }
            totalCost += costToConvert;
        }

        return totalCost;
    }
}
