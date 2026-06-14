class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    while(j < nums.length - 1 && nums[j + 1] == nums[j]) {
                        j++;
                    }
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
            while(i < nums.length - 2 && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return res;
    }
}
