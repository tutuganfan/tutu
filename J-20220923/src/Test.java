import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 12629
 * @Description：
 */
public class Test {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        System.out.println(queue.poll());//出队！ 1
        System.out.println(queue.peek());//出队！ 2
        System.out.println(queue.empty());
        System.out.println(queue.getUsedSize());
        //System.out.println(queue.peek());//获取队头元素 但是不删除
        //System.out.println(queue.isEmpty());
    }
}
