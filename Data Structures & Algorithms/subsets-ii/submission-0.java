class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(0, nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
        int start,
        int[] nums,
        List<Integer> current,
        List<List<Integer>> result
    ) {
        // Add every current subset
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            // Skip duplicates at the same recursion level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose
            current.add(nums[i]);

            // Move to the next index
            backtrack(i + 1, nums, current, result);

            // Undo choice
            current.remove(current.size() - 1);
        }
    }
}