class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = map.getOrDefault(nums[i], 0);
            map.put(nums[i], cur + 1);
        }
        return map.keySet().stream()
            .sorted(Comparator.comparingInt(map::get).reversed())
            .limit(k)
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
