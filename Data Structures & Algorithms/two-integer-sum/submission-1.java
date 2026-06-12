class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [][] arrays = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arrays[i][0] = nums[i];
            arrays[i][1] = i;
        }

        Arrays.sort(arrays, Comparator.comparingInt(a -> a[0]));

        int i = 0, j = nums.length - 1;
        while(i < j) {
            int sum = arrays[i][0] + arrays[j][0];
            if (sum == target) {
                return new int[]{Math.min(arrays[i][1], arrays[j][1]), Math.max(arrays[i][1], arrays[j][1])};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }
}
