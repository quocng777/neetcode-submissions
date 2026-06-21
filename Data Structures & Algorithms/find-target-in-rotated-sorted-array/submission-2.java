class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[lo] <= nums[mid]) {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1; // target is in the sorted left half
                } else {
                    lo = mid + 1; // target must be in the right half
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1; // target is in the sorted right half
                } else {
                    hi = mid - 1; // target must be in the left half
                }
            }
        }

        return -1;
    }
}