class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixArr = new int[nums.length];
        int[] sufixArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefixArr[i] = i > 0 ? prefixArr[i - 1] * nums[i - 1] : 1;
            sufixArr[nums.length - 1 - i] = i > 0 ? sufixArr[nums.length - i] * nums[nums.length - i] : 1; 
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = prefixArr[i] * sufixArr[i];
        }
        return nums;
    }
}  
