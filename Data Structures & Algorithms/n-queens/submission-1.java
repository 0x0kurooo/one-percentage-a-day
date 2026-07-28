class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][];
        for (int i = 0; i < n; i++) {
            board[i] = new char[n];
            Arrays.fill(board[i], '.');
        }
        
        backtrack(0, n, board);
        return result;
    }

    public void backtrack(int row, int n, char[][] board) {
        if (row >= n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
                solution.add(sb.toString());
            }
            result.add(solution);
            return;
        }

        for (int col = 0; col < n; col ++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(row + 1, n, board);
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;
        // Safe when row has no queen
        for (int i = 0; i < n; i ++) {
            if (board[row][i] == 'Q') return false;
        }
        // Safe when col has no queen
        for (int i = 0; i < n; i ++) {
            if (board[i][col] == 'Q') return false;
        }
        
        // Check four diagnals
        int[][] directions = {{1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        for (int[] direction : directions) {
            int currRow = row + direction[0];
            int currCol = col + direction[1];
            while (currRow >= 0 && currRow < n && currCol >= 0 && currCol < n) {
                if (board[currRow][currCol] == 'Q') return false;
                currRow += direction[0];
                currCol += direction[1];
            }
        }

        return true;
    }
}
