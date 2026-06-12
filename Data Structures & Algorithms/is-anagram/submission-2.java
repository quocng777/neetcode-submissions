class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sChar == tChar) {
                continue;
            }
            int quan = map.getOrDefault(sChar, 0);
            map.put(sChar, quan + 1);
            if (quan == -1) {
                map.remove(sChar);
            }
            quan = map.getOrDefault(tChar, 0);
            if (quan == 1) {
                map.remove(tChar);
            } else {
                map.put(tChar, quan - 1);
            }
        }
        return (map.keySet().size() == 0);
    }
}
