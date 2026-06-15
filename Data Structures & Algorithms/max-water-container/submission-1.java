class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int cur = 0;
        for (int i = 0; i < heights.length - 1; i++) {
            if (cur > heights[i]) {
                continue;
            }
            cur = heights[i];
            for (int j = i + 1; j < heights.length; j++) {
                max = Math.max(Math.min(cur, heights[j]) * (j - i), max);
            }
        }
        return max;
    }
}
