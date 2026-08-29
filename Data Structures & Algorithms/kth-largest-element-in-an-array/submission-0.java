class Solution {

    public int findKthLargest(int[] nums, int k) {

        // kth largest = (n - k)th smallest
        int target = nums.length - k;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == target) {
                return nums[pivotIndex];
            }

            if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        return -1; // Will never happen for valid input
    }

    private int partition(int[] nums, int left, int right) {

        int pivot = nums[right];

        int storeIndex = left;

        for (int i = left; i < right; i++) {

            if (nums[i] <= pivot) {
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        }

        swap(nums, storeIndex, right);

        return storeIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}