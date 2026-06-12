class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            List<String> curList = map.getOrDefault(sorted, new ArrayList());
            curList.add(strs[i]);
            map.put(sorted, curList);
        }
        return map.values().stream().toList();
    }
}
