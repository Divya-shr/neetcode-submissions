class Solution {

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word; // Stores complete word at the end of a Trie path
    }

    private TrieNode root = new TrieNode();
    private List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        // Build Trie
        for (String word : words) {
            addWord(word);
        }

        int rows = board.length;
        int cols = board[0].length;

        // DFS from every cell
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root);
            }
        }

        return result;
    }

    private void addWord(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.word = word;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node) {

        // Out of bounds
        if (r < 0 || r >= board.length ||
            c < 0 || c >= board[0].length) {
            return;
        }

        char ch = board[r][c];

        // Already visited
        if (ch == '#') {
            return;
        }

        // No matching Trie path
        TrieNode next = node.children[ch - 'a'];

        if (next == null) {
            return;
        }

        // Found a complete word
        if (next.word != null) {
            result.add(next.word);

            // Prevent finding the same word again
            next.word = null;
        }

        // Mark current cell as visited
        board[r][c] = '#';

        // Explore four directions
        dfs(board, r + 1, c, next);
        dfs(board, r - 1, c, next);
        dfs(board, r, c + 1, next);
        dfs(board, r, c - 1, next);

        // Backtrack
        board[r][c] = ch;
    }
}