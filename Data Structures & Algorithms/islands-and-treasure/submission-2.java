class Solution {
    int INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][];
        for (int row = 0; row < rows; row ++) {
            visited[row] = new boolean[cols];
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        // Init the queue with all treasures indices
        for (int row = 0; row < rows; row ++) {
            for (int col = 0; col < cols; col ++) {
                if (grid[row][col] == 0) {
                    visited[row][col] = true;
                    queue.offer(List.of(row, col));
                }
            }
        }

        // Do the bfs for each level of distance
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int dist = 1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                List<Integer> curr = queue.poll();
                int row = curr.get(0);
                int col = curr.get(1);

                for (int[] direction : directions) {
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];
                    if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length) {
                        continue;
                    }
                    if (grid[nextRow][nextCol] == -1) {
                        continue;
                    }
                    if (visited[nextRow][nextCol]) {
                        continue;
                    }
                    
                    grid[nextRow][nextCol] = dist;
                    visited[nextRow][nextCol] = true;
                    queue.offer(List.of(nextRow, nextCol));
                }
            }

            dist += 1;
        }
    }
}
