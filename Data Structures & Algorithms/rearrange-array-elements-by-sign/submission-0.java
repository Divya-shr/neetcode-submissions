class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int positive = 0;
        int negative = 1;

        for (int num : nums) {
            if (num > 0) {
                result[positive] = num;
                positive += 2;
            } else {
                result[negative] = num;
                negative += 2;
            }
        }

        return result;
    }
}