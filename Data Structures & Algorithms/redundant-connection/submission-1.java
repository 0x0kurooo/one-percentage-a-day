class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> neighbor = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> neighbors = neighbor.computeIfAbsent(edge[0], k -> new ArrayList<>());
            neighbors.add(edge[1]);

            List<Integer> neighbors2 = neighbor.computeIfAbsent(edge[1], k -> new ArrayList<>());
            neighbors2.add(edge[0]);
        }

        for (int i = edges.length - 1; i >= 0; i--) {
            int[] edge = edges[i];
            if (isConnected(neighbor, edges.length, edge)) {
                return edge;
            }
        }

        return edges[0];
    }

    private boolean isConnected(Map<Integer, List<Integer>> neighbor, int n, int[] edge) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new ArrayDeque<>();
        visited[1] = true;
        queue.add(1);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;

            List<Integer> neighbors = neighbor.get(node);
            for (int nei : neighbors) {
                if (node == edge[0] && nei == edge[1] || node == edge[1] && nei == edge[0]) {
                    continue;
                }
                if (visited[nei]) {
                   continue;
                }
                queue.offer(nei);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) return false;
        }

        return true;
    }
}
