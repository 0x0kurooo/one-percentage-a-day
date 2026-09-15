class Node {
    int val;
    List<Node> neighbors;

    public Node(int node) {
        this.val = node;
        this.neighbors = new ArrayList<>();
    }
}

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }

        Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodes.put(i, new Node(i));
        }

        for (int[] edge : edges) {
            Node node = nodes.get(edge[0]);
            Node neighbor = nodes.get(edge[1]);
            node.neighbors.add(neighbor);
            neighbor.neighbors.add(node);
        }

        int[] degree = new int[n];
        for (Node node : nodes.values()) {
            degree[node.val] = node.neighbors.size();
        }

        // initial leaves
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        int remaining = n;
        while (remaining > 2) {
            int leafCount = queue.size();
            remaining -= leafCount;

            for (int i = 0; i < leafCount; i++) {
                int leafVal = queue.poll();
                Node leaf = nodes.get(leafVal);

                // For each neighbor, reduce degree
                for (Node nei : leaf.neighbors) {
                    degree[nei.val]--;
                    if (degree[nei.val] == 1) {
                        queue.offer(nei.val);
                    }
                }
            }
        }

        result.addAll(queue);
        return result;
    }
}