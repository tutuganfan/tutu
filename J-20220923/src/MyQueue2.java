import java.util.Stack;

class MyQueue2 {

    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public MyQueue2() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }

    //
    public int pop() {
        if(empty()) {
            return -1;
        }
        if(s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        //
        return s2.pop();
    }
    
    public int peek() {
        if(empty()) {
            return -1;
        }
        if(s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        //
        return s2.peek();
    }

    //如果两个栈 都是空的 呢么队列就是空的
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
