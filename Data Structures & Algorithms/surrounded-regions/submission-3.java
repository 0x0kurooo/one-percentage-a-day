class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row ++) {
            dfs(board, row, 0);
            dfs(board, row, cols - 1);
        }

        for (int col = 0; col < cols; col ++) {
            dfs(board, 0, col);
            dfs(board, rows - 1, col);
        }

        System.out.println(Arrays.deepToString(board));

        for (int row = 0; row < rows; row ++) {
            for (int col = 0; col < cols; col ++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == 'T') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        if (board[row][col] != 'O') {
            return;
        }

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        board[row][col] = 'T';
        for (int[] direction : directions) {
            int nr = row + direction[0];
            int nc = col + direction[1];
            if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) {
               continue;
            }

            if (board[nr][nc] == 'O') {
                dfs(board, nr, nc);
            }
        }
    }
}
