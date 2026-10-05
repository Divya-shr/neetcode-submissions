class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int[] count = new int[nums.length + 1];
        int left = 0;
        int distinct = 0;
        int result = 0;

        for (int right = 0; right < nums.length; right++) {
            if (count[nums[right]] == 0) {
                distinct++;
            }

            count[nums[right]]++;

            while (distinct > k) {
                count[nums[left]]--;

                if (count[nums[left]] == 0) {
                    distinct--;
                }

                left++;
            }

            result += right - left + 1;
        }

        return result;
    }
}