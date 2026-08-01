class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<List<Integer>> queue = new LinkedList<>();

        int totalOranges = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    totalOranges++;
                } else if (grid[row][col] == 2) {
                    queue.offer(List.of(row, col));
                }
            }
        }
        if (totalOranges == 0) return 0;

        int[][] directions = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        int minutes = -1;
        int rottenOranges = 0;

        while (!queue.isEmpty()) {
            int oranges = queue.size();
            minutes++;

            for (int i = 0; i < oranges; i++) {
                List<Integer> index = queue.poll();
                int row = index.get(0);
                int col = index.get(1);

                for (int[] direction : directions) {
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];

                    if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] == 1) {
                        grid[nextRow][nextCol] = 2;
                        rottenOranges++;
                        queue.offer(List.of(nextRow, nextCol));
                    }
                }
            }
        }

        if (rottenOranges < totalOranges) {
            return -1;
        }

        return minutes;
    }
}
