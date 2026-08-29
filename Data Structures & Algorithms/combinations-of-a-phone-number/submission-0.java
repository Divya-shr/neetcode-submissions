class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] phone = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(digits, 0, new StringBuilder(), phone, result);

        return result;
    }

    private void backtrack(String digits, int index,
                           StringBuilder current,
                           String[] phone,
                           List<String> result) {

        // We have chosen a letter for every digit
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = phone[digits.charAt(index) - '0'];

        // Try every letter for the current digit
        for (char letter : letters.toCharArray()) {
            current.append(letter);

            // Move to the next digit
            backtrack(digits, index + 1, current, phone, result);

            // Undo choice
            current.deleteCharAt(current.length() - 1);
        }
    }
}