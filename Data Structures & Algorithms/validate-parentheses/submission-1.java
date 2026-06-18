class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '{' || cur == '[') {
                stack.push(cur);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char peek = stack.pop();
                if (
                    (peek == '(' && cur == ')')
                    || (peek == '{' && cur == '}')
                    || (peek == '[' && cur == ']')
                ) {
                    continue;
                }
                else {
                    return false;
                }
            } 
        }
        return stack.empty();
    }
}
