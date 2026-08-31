class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);

        // dp[i] = true if s[0...i-1] can be segmented
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String word : words) {
                int len = word.length();

                if (len <= i &&
                    dp[i - len] &&
                    s.substring(i - len, i).equals(word)) {

                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}