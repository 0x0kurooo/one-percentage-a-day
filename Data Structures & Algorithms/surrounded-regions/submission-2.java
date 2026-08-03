class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row ++) {
            for (int col = 0; col < cols; col ++) {
                if (board[row][col] == 'O') {
                    dfs(board, row, col, visited);
                }
            }
        }

        for (int row = 0; row < rows; row ++) {
            for (int col = 0; col < cols; col ++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
            }
        }
        for (int row = 0; row < rows; row ++) {
            for (int col = 0; col < cols; col ++) {
                if (board[row][col] == 'T') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    public char dfs(char[][] board, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return 'T';
        }

        if (board[row][col] != 'O' || visited[row][col]) {
            return board[row][col];
        }

        visited[row][col] = true;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        for (int[] direction : directions) {
            int nr = row + direction[0];
            int nc = col + direction[1];
            char next = dfs(board, nr, nc, visited);
            if (next == 'T') {
                board[row][col] = 'T';
            }
        }

        visited[row][col] = false;
        return board[row][col];
    }
}
