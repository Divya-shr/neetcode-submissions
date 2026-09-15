class Solution {
    public boolean makesquare(int[] matchsticks) {

        int total = 0;

        for (int stick : matchsticks) {
            total += stick;
        }

        // A square must have 4 equal sides
        if (total % 4 != 0) {
            return false;
        }

        int sideLength = total / 4;

        // Sort so we try the largest sticks first
        Arrays.sort(matchsticks);

        int[] sides = new int[4];

        return backtrack(matchsticks, matchsticks.length - 1, sides, sideLength);
    }

    private boolean backtrack(
            int[] matchsticks,
            int index,
            int[] sides,
            int sideLength) {

        // All matchsticks have been used
        if (index < 0) {
            return sides[0] == sideLength &&
                   sides[1] == sideLength &&
                   sides[2] == sideLength &&
                   sides[3] == sideLength;
        }

        int stick = matchsticks[index];

        for (int i = 0; i < 4; i++) {

            // Don't put stick on a side if it becomes too long
            if (sides[i] + stick > sideLength) {
                continue;
            }

            // Put stick on this side
            sides[i] += stick;

            // Recursively place the remaining sticks
            if (backtrack(matchsticks, index - 1, sides, sideLength)) {
                return true;
            }

            // Undo the choice
            sides[i] -= stick;
        }

        return false;
    }
}