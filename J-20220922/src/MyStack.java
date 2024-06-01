import java.util.Arrays;
import java.util.Stack;

/**
 * @Author 12629
 * @Description：
 */
public class MyStack {

    public int[] elem;
    public int usedSize;
    public static final int DEFAULT_SIZE = 10;

    public MyStack() {
        this.elem = new int[DEFAULT_SIZE];
    }

    /**
     * 压栈
     * @param val
     * @return
     */
    public int push(int val) {
        if(isFull()) {
            elem = Arrays.copyOf(elem,2*elem.length);
        }
        this.elem[usedSize] = val;
        usedSize++;
        return val;
    }

    public boolean isFull() {
        return usedSize == elem.length;
    }

    public int pop() {
        if(empty()) {
            throw new MyEmptyStackException("栈为空！");
        }
        /*int ret = elem[usedSize-1];
        usedSize--;
        return ret;*/
        return elem[--usedSize];
    }

    public boolean empty() {
        return usedSize == 0;
    }

    public int peek() {
        if(empty()) {
            throw new MyEmptyStackException("栈为空！");
        }
        return elem[usedSize-1];
    }

}
