class Solution {

    public List<List<Integer>> combinationSum2(
        int[] candidates,
        int target
    ) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(
            0,
            target,
            candidates,
            new ArrayList<>(),
            result
        );

        return result;
    }

    private void backtrack(
        int start,
        int target,
        int[] candidates,
        List<Integer> current,
        List<List<Integer>> result
    ) {
        // Found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicates at the same recursion level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Since the array is sorted, no later value can work
            if (candidates[i] > target) {
                break;
            }

            // Choose candidates[i]
            current.add(candidates[i]);

            // i + 1 because each element can only be used once
            backtrack(
                i + 1,
                target - candidates[i],
                candidates,
                current,
                result
            );

            // Undo choice
            current.remove(current.size() - 1);
        }
    }
}