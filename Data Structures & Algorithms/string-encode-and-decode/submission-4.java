class Solution {
    private static final String JOIN_STRING = "##__XXX__##";
    private static final String EMPTY_STRING = "##__EMPTY__##";

    public String encode(List<String> strs) {
        List<String> replacedList = strs.stream()
        .map(str -> str.equals("") ? EMPTY_STRING : str)
        .toList();
        return String.join(JOIN_STRING, replacedList);
    }

    public List<String> decode(String str) {
        return List.of(str.split(JOIN_STRING)).stream()
        .filter(e -> !e.equals(""))
        .map(e -> e.equals(EMPTY_STRING) ? "" : e)
        .toList();
    }
}
