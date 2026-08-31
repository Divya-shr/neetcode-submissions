class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        // {water level required, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        boolean[][] visited = new boolean[n][n];

        pq.offer(new int[]{grid[0][0], 0, 0});

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int time = current[0];
            int r = current[1];
            int c = current[2];

            if (visited[r][c]) {
                continue;
            }

            visited[r][c] = true;

            // Reached bottom-right
            if (r == n - 1 && c == n - 1) {
                return time;
            }

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= n ||
                    nc < 0 || nc >= n ||
                    visited[nr][nc]) {
                    continue;
                }

                // Water must be high enough for both the current
                // path and the next cell.
                int newTime = Math.max(time, grid[nr][nc]);

                pq.offer(new int[]{newTime, nr, nc});
            }
        }

        return -1;
    }
}