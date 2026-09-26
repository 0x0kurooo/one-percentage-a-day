class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];

        // Travel through the matrix
        // We have 4 directions: right, down, left, up
        // Also need to trace the visited in the matrix

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0;
        int col = 0;
        int counter = 0;

        int directionIdx = 0;

        while (counter < n * m) {
            int num = matrix[row][col];
            result.add(num);

            int[] currDir = directions[directionIdx];
            int nextRow = row + currDir[0];
            int nextCol = col + currDir[1];
            boolean isOutOfBound = nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m;

            if (isOutOfBound || visited[nextRow][nextCol]) {
                directionIdx = (directionIdx + 1) % 4; // Move to next direction
                currDir = directions[directionIdx];
            }

            visited[row][col] = true;
            row = row + currDir[0];
            col = col + currDir[1];
            counter++;
        }

        return result;
    }
}
