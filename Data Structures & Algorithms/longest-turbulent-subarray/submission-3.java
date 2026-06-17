class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) return 1;

        int max = 1, l = 0;

        for (int r = 1; r < arr.length; r++) {
            if (arr[r] == arr[r - 1]) {
                // flat — hard reset
                l = r;
            } else if (r > 1 && 
                       (arr[r] > arr[r-1]) == (arr[r-1] > arr[r-2])) {
                // same direction as previous step — soft reset
                // e.g. 3 5 7: both going up, new window starts at r-1
                l = r - 1;
            }
            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}