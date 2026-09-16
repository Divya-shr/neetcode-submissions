public class Solution {
    private List<List<Integer>> adj;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int minHgt = n;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int curHgt = dfs(i, -1);
            if (curHgt == minHgt) {
                result.add(i);
            } else if (curHgt < minHgt) {
                result = new ArrayList<>();
                result.add(i);
                minHgt = curHgt;
            }
        }
        return result;
    }

    private int dfs(int node, int parent) {
        int hgt = 0;
        for (int nei : adj.get(node)) {
            if (nei == parent) {
                continue;
            }
            hgt = Math.max(hgt, 1 + dfs(nei, node));
        }
        return hgt;
    }
}