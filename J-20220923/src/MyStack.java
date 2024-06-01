import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> qu1;
    private Queue<Integer> qu2;

    public MyStack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }
    
    public void push(int x) {
        if(!qu1.isEmpty()) {
            qu1.offer(x);
        }else if(!qu2.isEmpty()) {
            qu2.offer(x);
        }else {
            //两个队列都为空的时候
            qu1.offer(x);
        }
    }
    
    public int pop() {
        if(empty()) {
            return -1;//
        }
        if(!qu1.isEmpty()) {
            int size = qu1.size();
            for (int i = 0; i < size-1; i++) {

                qu2.offer(qu1.poll());
            }
            return qu1.poll();
        }else {
            int size = qu2.size();
            for (int i = 0; i < size-1; i++) {

                qu1.offer(qu2.poll());
            }
            return qu2.poll();
        }
    }
    //peek
    public int top() {
        if(empty()) {
            return -1;//
        }
        if(!qu1.isEmpty()) {
            int size = qu1.size();
            int ret = -1;
            for (int i = 0; i < size; i++) {
                ret = qu1.poll();
                qu2.offer(ret);
            }
            return ret;
        }else {
            int size = qu2.size();
            int ret = -1;
            for (int i = 0; i < size; i++) {
                ret =  qu2.poll();
                qu1.offer(ret);
            }
            return ret;
        }
    }

    //两个队列都为空 那么就是栈为空
    public boolean empty() {
        return qu1.isEmpty() && qu2.isEmpty();
    }
}