class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        // Pacific: top row and left column
        for (int r = 0; r < rows; r++) {
            pacific[r][0] = true;
            pacificQueue.offer(new int[]{r, 0});
        }

        for (int c = 0; c < cols; c++) {
            if (!pacific[0][c]) {
                pacific[0][c] = true;
                pacificQueue.offer(new int[]{0, c});
            }
        }

        // Atlantic: bottom row and right column
        for (int r = 0; r < rows; r++) {
            atlantic[r][cols - 1] = true;
            atlanticQueue.offer(new int[]{r, cols - 1});
        }

        for (int c = 0; c < cols; c++) {
            if (!atlantic[rows - 1][c]) {
                atlantic[rows - 1][c] = true;
                atlanticQueue.offer(new int[]{rows - 1, c});
            }
        }

        bfs(heights, pacificQueue, pacific);
        bfs(heights, atlanticQueue, atlantic);

        List<List<Integer>> result = new ArrayList<>();

        // Cells reachable from both oceans
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void bfs(
        int[][] heights,
        Queue<int[]> queue,
        boolean[][] visited
    ) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= rows ||
                    nc < 0 || nc >= cols ||
                    visited[nr][nc]) {
                    continue;
                }

                // Reverse flow:
                // neighbor must be at least as high as current cell.
                if (heights[nr][nc] < heights[r][c]) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}