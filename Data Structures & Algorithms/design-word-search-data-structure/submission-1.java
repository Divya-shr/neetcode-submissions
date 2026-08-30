class WordDictionary {

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {

        // Reached the end of the word
        if (index == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(index);

        // Normal character
        if (c != '.') {
            int childIndex = c - 'a';

            if (node.children[childIndex] == null) {
                return false;
            }

            return dfs(
                word,
                index + 1,
                node.children[childIndex]
            );
        }

        // '.' can match any character
        for (TrieNode child : node.children) {
            if (child != null &&
                dfs(word, index + 1, child)) {
                return true;
            }
        }

        return false;
    }
}