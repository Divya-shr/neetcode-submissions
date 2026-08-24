public class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> pairs = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
        );

        for (char c : s.toCharArray()) {
            if (pairs.containsKey(c)) {
                // closing bracket: check top of stack matches
                if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
                    return false;
                }
            } else {
                // opening bracket
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}