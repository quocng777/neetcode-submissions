class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixArr = new int[nums.length];
        int[] sufixArr = new int[nums.length];
        prefixArr[0] = 1;
        sufixArr[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefixArr[i] = prefixArr[i - 1] * nums[i - 1];
            sufixArr[nums.length - 1 - i] = sufixArr[nums.length - i] * nums[nums.length - i]; 
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = prefixArr[i] * sufixArr[i];
        }
        return nums;
    }
}  
