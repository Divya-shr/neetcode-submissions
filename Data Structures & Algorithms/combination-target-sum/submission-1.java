class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, target, nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
        int index,
        int target,
        int[] nums,
        List<Integer> current,
        List<List<Integer>> result
    ) {
        // Found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // No more numbers or target became negative
        if (index == nums.length || target < 0) {
            return;
        }

        // Choice 1: Include nums[index]
        // Stay at the same index because we can reuse the number.
        current.add(nums[index]);

        backtrack(
            index,
            target - nums[index],
            nums,
            current,
            result
        );

        // Undo choice
        current.remove(current.size() - 1);

        // Choice 2: Skip nums[index]
        backtrack(
            index + 1,
            target,
            nums,
            current,
            result
        );
    }
}