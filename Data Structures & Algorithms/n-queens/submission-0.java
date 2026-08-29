
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        // Initially, every cell is empty.
        for (int r = 0; r < n; r++) {
            Arrays.fill(board[r], '.');
        }

        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>(); // row - col
        Set<Integer> diag2 = new HashSet<>(); // row + col

        backtrack(0, n, board, cols, diag1, diag2, result);

        return result;
    }

    private void backtrack(
            int row,
            int n,
            char[][] board,
            Set<Integer> cols,
            Set<Integer> diag1,
            Set<Integer> diag2,
            List<List<String>> result) {

        // All rows have a queen
        if (row == n) {
            List<String> solution = new ArrayList<>();

            for (int r = 0; r < n; r++) {
                solution.add(new String(board[r]));
            }

            result.add(solution);
            return;
        }

        // Try every column in this row
        for (int col = 0; col < n; col++) {

            // Check if this position is attacked
            if (cols.contains(col)
                    || diag1.contains(row - col)
                    || diag2.contains(row + col)) {
                continue;
            }

            // Choose
            board[row][col] = 'Q';
            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);

            // Explore next row
            backtrack(
                row + 1,
                n,
                board,
                cols,
                diag1,
                diag2,
                result
            );

            // Undo choice
            board[row][col] = '.';
            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
    }
}