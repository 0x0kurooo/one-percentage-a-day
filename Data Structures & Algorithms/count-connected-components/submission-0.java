class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>())
                .add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>())
                .add(edge[0]);
        }

        int components = 0;
        boolean[] visited = new boolean[n];
        for (int node = 0; node < n; node++) {
            if (visited[node]) continue;
            dfs(node, graph, visited, -1);
            components ++;
        }

        return components;
    }

    public void dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited, int prev) {
        if (visited[node]) return;

        visited[node] = true;
        List<Integer> neighbors = graph.computeIfAbsent(node, k -> List.of());
        for (int neighbor : neighbors) {
            if (neighbor == prev) continue; // prevent go back to prev
            dfs(neighbor, graph, visited, node);
        }
    }
}
