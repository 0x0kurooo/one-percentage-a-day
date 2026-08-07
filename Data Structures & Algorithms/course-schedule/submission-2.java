class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            graph.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(pre[1]);
        }

        // -1 for false, 0 is not compute yet and 1 is computed
        int[] state = new int[numCourses];
        boolean[] visiting = new boolean[numCourses];
        for (int[] pre : prerequisites) {
            if (!dfs(pre[0], graph, visiting, state)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(
        int course,
        Map<Integer, List<Integer>> graph,
        boolean[] visiting, 
        int[] state
    ) {
        if (state[course] != 0) {
            return state[course] == 1;
        }
        // Cycle detected
        if (visiting[course]) {
            return false;
        }

        if (graph.get(course) == null) {
            state[course] = 1;
            return true;
        }

        visiting[course] = true;
        for (int pre : graph.computeIfAbsent(course, k -> List.of())) {
            if (!dfs(pre, graph, visiting, state)) {
                state[course] = -1;
                return false;
            }
        }

        visiting[course] = false;
        state[course] = 1;
        return true;
    }
}