class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int[] pre : prerequisites) {
            List<Integer> pres = preMap.computeIfAbsent(pre[0],  k -> new ArrayList<>());
            pres.add(pre[1]);
        }
        
        boolean[] visited = new boolean[numCourses];
        // -1 for false, 0 is not compute yet and 1 is computed
        int[] canFinish = new int[numCourses];
        for (int course = 0; course < numCourses; course ++) {
            if (!preMap.containsKey(course)) {
                canFinish[course] = 1;
            }
        }

        for (int[] pre : prerequisites) {
            if (!dfs(pre[0], preMap, visited, canFinish)) {
                return false;
            }
        }
        
        return true;
    }

    public boolean dfs(int course, Map<Integer, List<Integer>> preMap, boolean[] visited, int[] canFinish) {
        if (visited[course]) {
            return false; // We found the loop
        }
        if (canFinish[course] != 0) {
            return canFinish[course] == 1;
        }

        List<Integer> prerequisites = preMap.get(course);
        if (prerequisites == null) {
            return true;
        }

        visited[course] = true;

        for (int pre : prerequisites) {
            if (!dfs(pre, preMap, visited, canFinish)) {
                canFinish[course] = -1;
                return false;
            }
        }

        visited[course] = false;
        canFinish[course] = 1;
        return true;
    }
}