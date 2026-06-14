class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int l = 0, r = 0;
        int res = Integer.MAX_VALUE;
        while (r < nums.length) {
            sum += nums[r];
            if (sum >= target) {
                res = Math.min(res, r - l + 1);
                while(sum - nums[l] >= target) {
                    sum = sum - nums[l];
                    l++;
                    res = Math.min(res, r - l + 1);
                }
            }
            r++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}