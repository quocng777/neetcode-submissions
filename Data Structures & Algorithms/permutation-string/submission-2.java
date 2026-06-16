class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap();
        int l = 0;
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        Map<Character, Integer> curMap = new HashMap();
        for (int r = 0; r < s2.length(); r++) {
            if (!map.containsKey(s2.charAt(r))) {
                curMap.clear();
                l = r + 1;
                continue;
            }
            if (map.get(s2.charAt(r)) == curMap.get(s2.charAt(r))) {
                while(s2.charAt(l) != s2.charAt(r)) {
                    curMap.put(s2.charAt(l), curMap.get(s2.charAt(l)) - 1);
                    l++;
                }
                l++;
                continue;
            }
            curMap.put(s2.charAt(r), curMap.getOrDefault(s2.charAt(r), 0) + 1);
            if (r - l + 1 == s1.length()) {
                return true;
            }
        }

        return false;
    }
}