class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Add all treasure chests to the queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        int[][] directions = {
            {1, 0},   // down
            {-1, 0},  // up
            {0, 1},   // right
            {0, -1}   // left
        };

        // Multi-source BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // Check bounds
                if (nr < 0 || nr >= rows ||
                    nc < 0 || nc >= cols) {
                    continue;
                }

                // Only visit unvisited land
                if (grid[nr][nc] != Integer.MAX_VALUE) {
                    continue;
                }

                // Distance = current distance + 1
                grid[nr][nc] = grid[r][c] + 1;

                queue.offer(new int[]{nr, nc});
            }
        }
    }
}