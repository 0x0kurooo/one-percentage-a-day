class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] parcific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Start from the water try to reach to the middle
        for (int row = 0; row < rows; row++) {
            dfs(heights, parcific, row, 0);
            dfs(heights, atlantic, row, cols - 1);
        }
        for (int col = 0; col < cols; col++) {
            dfs(heights, parcific, 0, col);
            dfs(heights, atlantic, rows-1, col);
        }
    
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < rows; row ++) {
            for (int col = 0; col < cols; col ++) {
                if (parcific[row][col] && atlantic[row][col]) {
                    result.add(List.of(row, col));
                }
            }
        }

        return result;
    }

    public void dfs(int[][] heights, boolean[][] visited, int row, int col) {
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] direction : directions) {
            int nr = row + direction[0];
            int nc = col + direction[1];

            if (nr < 0 || nr >= heights.length || nc < 0 || nc >= heights[0].length) {
                continue;
            }
            
            if (heights[nr][nc] >= heights[row][col]) {
                dfs(heights, visited, nr, nc);
            }
        }
    }
}