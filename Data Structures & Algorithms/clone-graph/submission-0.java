class Solution {
    Map<Node, Node> cloneMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    public Node dfs(Node node) {
        if (node == null) return null;
        if (cloneMap.get(node) != null) {
            return cloneMap.get(node);
        }
        
        Node clone = new Node(node.val);
        cloneMap.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor));
        }

        return clone;
    }
}