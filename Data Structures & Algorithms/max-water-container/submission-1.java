public class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int res = 0;
        
        while (left < right) {
            int width = right - left;
            int h = Math.min(heights[left], heights[right]);
            res = Math.max(res, h * width);
            
            // Move the pointer pointing to the shorter bar
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return res;
    }
}