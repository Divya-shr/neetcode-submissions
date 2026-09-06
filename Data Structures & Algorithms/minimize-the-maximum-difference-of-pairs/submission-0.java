class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canMakePairs(nums, p, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canMakePairs(int[] nums, int p, int maxDiff) {
        int pairs = 0;
        int i = 0;

        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                pairs++;
                i += 2;
            } else {
                i++;
            }

            if (pairs >= p) {
                return true;
            }
        }

        return false;
    }
}