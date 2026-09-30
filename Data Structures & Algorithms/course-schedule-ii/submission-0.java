class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> prere = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            prere.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            indegree[pre[0]] ++;
            prere.get(pre[1]).add(pre[0]);
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i ++) {
                int course = queue.poll();
                List<Integer> children = prere.get(course);
                for (int child: children) {
                    indegree[child] --;
                    if (indegree[child] == 0) {
                        queue.offer(child);
                    }
                }
                result.add(course);
            }
        }

        
        if (result.size() == numCourses) {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i ++) {
                res[i] = result.get(i);
            }
            return res;
        }

        return new int[] {};
    }

}
