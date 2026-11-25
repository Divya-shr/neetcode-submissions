class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        int count = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int[] stack = new int[m * n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    boolean valid = true;
                    int top = 0;

                    stack[top++] = i * n + j;
                    grid2[i][j] = 0;

                    while (top > 0) {
                        int cell = stack[--top];
                        int r = cell / n;
                        int c = cell % n;

                        if (grid1[r][c] == 0) {
                            valid = false;
                        }

                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            if (nr >= 0 && nr < m &&
                                nc >= 0 && nc < n &&
                                grid2[nr][nc] == 1) {

                                grid2[nr][nc] = 0;
                                stack[top++] = nr * n + nc;
                            }
                        }
                    }

                    if (valid) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}