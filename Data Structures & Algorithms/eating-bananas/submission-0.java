class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        int res = right;
        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int totalHours = 0;
            for (int i = 0; i < piles.length; i++) {
                totalHours += Math.ceil((double)piles[i] / mid);
            }
            if (totalHours <= h) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }
}
