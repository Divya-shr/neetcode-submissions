class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
        int index,
        int[] nums,
        List<Integer> current,
        List<List<Integer>> result
    ) {

        // We've processed every number
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Choice 1: Include nums[index]
        current.add(nums[index]);

        backtrack(index + 1, nums, current, result);

        // Undo the choice
        current.remove(current.size() - 1);

        // Choice 2: Don't include nums[index]
        backtrack(index + 1, nums, current, result);
    }
}