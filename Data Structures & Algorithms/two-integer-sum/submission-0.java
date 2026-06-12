class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int head = 0, tail = sorted.length - 1;
        while(head < tail) {
            int sum = sorted[head] + sorted[tail];
            if (sum < target) {
                head++;
                continue;
            } else if (sum > target) {
                tail--;
                continue;
            }
            break;
        }
        int a = -1, b = -1, i = 0;
        while(a == -1 || b == -1) {
            if (nums[i] == sorted[head] && a == -1) {
                a = i;
            } else if (nums[i] == sorted[tail] && b == -1) {
                b = i;
            }
            i++;
        }
        int[] result = {a, b};
        Arrays.sort(result);
        return result;
    }
}
