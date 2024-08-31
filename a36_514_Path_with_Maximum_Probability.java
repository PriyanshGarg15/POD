class Solution {
    static class Edge {
        int target;
        double probability;

        Edge(int target, double probability) {
            this.target = target;
            this.probability = probability;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex;
        double probability;

        Node(int vertex, double probability) {
            this.vertex = vertex;
            this.probability = probability;
        }

        @Override
        public int compareTo(Node other) {
            return Double.compare(this.probability,other.probability);
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Edge>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new Edge(v, prob));
            graph.get(v).add(new Edge(u, prob));
        }

  
        PriorityQueue<Node> pq = new PriorityQueue<>(Collections.reverseOrder()); 
        pq.add(new Node(start, 1.0));
        double[] maxProb = new double[n];
        Arrays.fill(maxProb, 0.0);
        maxProb[start] = 1.0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;
            double currentProb = current.probability;

            for (Edge edge : graph.get(u)) {
                int v = edge.target;
                double newProb = currentProb * edge.probability;
                if (newProb > maxProb[v]) {
                    maxProb[v] = newProb;
                    pq.add(new Node(v, newProb));
                }
            }
        }
        return maxProb[end];
    }
}
