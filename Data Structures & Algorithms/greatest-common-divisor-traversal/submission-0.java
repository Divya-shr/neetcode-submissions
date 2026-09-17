class Solution {

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;

        // One element is always connected to itself
        if (n == 1) {
            return true;
        }

        // If any number is 1, it cannot connect to anything else
        for (int num : nums) {
            if (num == 1) {
                return false;
            }
        }

        // parent[i] = parent of index i
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // factorIndex[p] = index of a number that contains prime p
        int[] factorIndex = new int[100001];
        Arrays.fill(factorIndex, -1);

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            // Factorize nums[i]
            for (int p = 2; p * p <= num; p++) {
                if (num % p == 0) {

                    // Connect current index with previous
                    // number that had this prime factor
                    if (factorIndex[p] != -1) {
                        union(i, factorIndex[p], parent, rank);
                    } else {
                        factorIndex[p] = i;
                    }

                    // Remove all copies of this prime
                    while (num % p == 0) {
                        num /= p;
                    }
                }
            }

            // num > 1 means num itself is a prime factor
            if (num > 1) {
                if (factorIndex[num] != -1) {
                    union(i, factorIndex[num], parent, rank);
                } else {
                    factorIndex[num] = i;
                }
            }
        }

        // Check whether every index belongs
        // to the same connected component
        int root = find(0, parent);

        for (int i = 1; i < n; i++) {
            if (find(i, parent) != root) {
                return false;
            }
        }

        return true;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }

        return parent[x];
    }

    private void union(int a, int b, int[] parent, int[] rank) {
        int rootA = find(a, parent);
        int rootB = find(b, parent);

        if (rootA == rootB) {
            return;
        }

        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }
}
