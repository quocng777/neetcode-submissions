class Solution {
    public boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        s = new String(chars);
        chars = t.toCharArray();
        Arrays.sort(chars);
        t = new String(chars);
        if (s.equals(t)) {
            return true;
        }
        return false;
    }
}
