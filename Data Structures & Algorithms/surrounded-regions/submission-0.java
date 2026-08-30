class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Add all O's on the left and right edges
        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') {
                board[r][0] = 'S';
                queue.offer(new int[]{r, 0});
            }

            if (cols > 1 && board[r][cols - 1] == 'O') {
                board[r][cols - 1] = 'S';
                queue.offer(new int[]{r, cols - 1});
            }
        }

        // Add all O's on the top and bottom edges
        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') {
                board[0][c] = 'S';
                queue.offer(new int[]{0, c});
            }

            if (rows > 1 && board[rows - 1][c] == 'O') {
                board[rows - 1][c] = 'S';
                queue.offer(new int[]{rows - 1, c});
            }
        }

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        // Mark every O connected to an edge as safe
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= rows ||
                    nc < 0 || nc >= cols ||
                    board[nr][nc] != 'O') {
                    continue;
                }

                board[nr][nc] = 'S';
                queue.offer(new int[]{nr, nc});
            }
        }

        // Capture surrounded regions and restore safe regions
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'S') {
                    board[r][c] = 'O';
                }
            }
        }
    }
}