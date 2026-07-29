/*
Question need to be clarify
- Is the island guaranty exists?
- The grid value is either 0 else 1 right
- Size of the grid
*/

class Solution {
    int max = 0;
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                   bfs(grid, row, col);
                }
            }
        }

        return max;
    }

    public void bfs(int[][] grid, int row, int col) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(row, col));
        grid[row][col] = 0; 
        int area = 0;
        
        while (!queue.isEmpty()) {
            List<Integer> curr = queue.poll();
            row = curr.get(0);
            col = curr.get(1);
            area += 1;

            // Explore the next neigboh
            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                
                if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length) {
                    continue;
                }
                if (grid[nextRow][nextCol] == 0) {
                    continue;
                }
                grid[nextRow][nextCol] = 0; 
                queue.offer(List.of(nextRow, nextCol));
            }
        }

        max = Math.max(max, area);
    }
}
