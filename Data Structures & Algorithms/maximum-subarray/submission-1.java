class Solution {
    public int maxSubArray(int[] nums) {
        int current = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either start a new subarray or extend the current one
            current = Math.max(nums[i], current + nums[i]);

            maxSum = Math.max(maxSum, current);
        }

        return maxSum;
    }
}