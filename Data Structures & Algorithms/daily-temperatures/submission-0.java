class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.empty()) {
                stack.push(i);
                continue;
            }
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                int colderDay = stack.pop();
                result[colderDay] = i - colderDay;
            }
            stack.push(i);
        }

        while(!stack.empty()) {
            int i = stack.pop();
            result[i] = 0;
        }

        return result;
    }
}
