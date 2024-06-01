import java.util.Stack;

class MinStack {

    private Stack<Integer> stack1;
    private Stack<Integer> minStack;

    public MinStack() {
        stack1 = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack1.push(val);
        if(minStack.empty()) {
            minStack.push(val);
        }else {
            int x = minStack.peek();
            if(val <= x) {
                minStack.push(val);
            }
        }
    }
    
    public void pop() {
        if(!stack1.empty()) {
            int x = stack1.pop();
            if(x == minStack.peek()) {
                minStack.pop();
            }
        }
    }
    //只针对 普通的栈来说的 获取普通栈的栈顶元素 相当于peek函数
    public int top() {
        if(!stack1.empty()) {
            return stack1.peek();
        }
        return -1;//不要抛异常
    }
    
    public int getMin() {
        if(minStack.empty()) {
            return -1;
        }
        return minStack.peek();
    }
}