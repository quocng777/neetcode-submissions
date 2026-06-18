class MinStack {
    private Stack<Integer> values;
    private Stack<Integer> mins;

    public MinStack() {
        values = new Stack();
        mins = new Stack();
    }
    
    public void push(int val) {
        values.push(val);
        if (mins.empty() || mins.peek() >= val) {
            mins.push(val);
        }
    }
    
    public void pop() {
        if (mins.peek().equals(values.peek())) {
            mins.pop();
        }
        values.pop();
    }
    
    public int top() {
        return values.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}
