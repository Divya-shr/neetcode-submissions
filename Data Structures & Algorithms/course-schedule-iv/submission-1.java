class Solution {
    public List<Boolean> checkIfPrerequisite(
        int numCourses,
        int[][] prerequisites,
        int[][] queries
    ) {
        // graph[u] = courses that depend directly on u
        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {
            int u = pre[0];
            int v = pre[1];

            graph[u].add(v);
        }

        // isPre[u][v] = true if u is a prerequisite of v
        boolean[][] isPre = new boolean[numCourses][numCourses];

        // Run DFS from every course
        for (int i = 0; i < numCourses; i++) {
            dfs(i, i, graph, isPre);
        }

        // Answer queries
        List<Boolean> answer = new ArrayList<>();

        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];

            answer.add(isPre[u][v]);
        }

        return answer;
    }

    private void dfs(
        int start,
        int curr,
        List<Integer>[] graph,
        boolean[][] isPre
    ) {
        for (int next : graph[curr]) {

            // Already know start -> next
            if (isPre[start][next]) {
                continue;
            }

            isPre[start][next] = true;

            dfs(start, next, graph, isPre);
        }
    }
}

