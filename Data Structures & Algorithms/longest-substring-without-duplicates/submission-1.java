class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();
        int l = 0, r = 0;
        int res = 0;
        while (r < s.length()) {
            char rChar = s.charAt(r);
            if (!map.containsKey(rChar)) {
                res = Math.max(r - l + 1, res);
            } else {
                int duplicatedIdx = map.get(rChar);
                while(l <= duplicatedIdx) map.remove(s.charAt(l++));
            }
            map.put(rChar, r);
            r++;
        }
        return res;
    }
}
