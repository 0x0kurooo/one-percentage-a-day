class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>())
                .add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>())
                .add(edge[0]);
        }

        boolean[] visiting = new boolean[n];
        for (int node = 0; node < n; node ++) {
            int nodes = dfs(node, graph, visiting, -1);
            if (nodes == n) {
                return true;
            }
        }

        return false;
    }

    public int dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visiting, int prev) {
        if (visiting[node]) {
            return -1;
        }
        
        int nodeCount = 1;
        visiting[node] = true;
        List<Integer> neighbors = graph.computeIfAbsent(node, k -> List.of());

        System.out.println("Start dfs: " + node + ". Neighbors: " + neighbors);
        for (int neighbor : neighbors) {
            if (prev == neighbor) continue;
            int c = dfs(neighbor, graph, visiting, node);
            if (c < 0) {
                return -1;
            }
            nodeCount += c;
        }
        System.out.println("dfs:" + node + ". Node count: " + nodeCount);
        // visiting[node] = false;
        return nodeCount;
    }

    /*
    Valid tree mean:
    - Dont have the loop inside the graph
    - Every node is connected with each other
    */ 
}
