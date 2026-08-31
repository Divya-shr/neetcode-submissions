class Solution {
    public String foreignDictionary(String[] words) {
        List<Integer>[] graph = new ArrayList[26];
        int[] indegree = new int[26];
        boolean[] present = new boolean[26];

        for (int i = 0; i < 26; i++) {
            graph[i] = new ArrayList<>();
        }

        // Find all characters that exist
        for (String word : words) {
            for (char c : word.toCharArray()) {
                present[c - 'a'] = true;
            }
        }

        // Build graph from adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int len = Math.min(w1.length(), w2.length());
            boolean foundDifference = false;

            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (c1 != c2) {
                    int u = c1 - 'a';
                    int v = c2 - 'a';

                    // Avoid duplicate edges
                    if (!graph[u].contains(v)) {
                        graph[u].add(v);
                        indegree[v]++;
                    }

                    foundDifference = true;
                    break;
                }
            }

            // Invalid prefix case: ["abc", "ab"]
            if (!foundDifference && w1.length() > w2.length()) {
                return "";
            }
        }

        // Topological sort
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < 26; i++) {
            if (present[i] && indegree[i] == 0) {
                queue.offer(i);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.append((char) ('a' + curr));

            for (int next : graph[curr]) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // Cycle detected
        int charCount = 0;

        for (boolean exists : present) {
            if (exists) {
                charCount++;
            }
        }

        if (result.length() != charCount) {
            return "";
        }

        return result.toString();
    }
}
