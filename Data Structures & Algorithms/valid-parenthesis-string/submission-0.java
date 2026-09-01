class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else { // '*'
                // '*' can be ')' or '(' or empty
                low--;
                high++;
            }

            // Even treating '*' optimally, too many ')' exist
            if (high < 0) {
                return false;
            }

            // We cannot have fewer than 0 unmatched '('
            low = Math.max(low, 0);
        }

        return low == 0;
    }
}