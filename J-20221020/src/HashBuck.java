import java.util.Arrays;

/**
 * @Author 12629
 * @Description：
 */
public class HashBuck {

    static class Node {
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array;
    public int usedSize;

    public HashBuck() {
        array = new Node[8];
    }

    public void put(int key,int val) {
        int index = key % array.length;
        //遍历Index下标的数组，如果有相同的key那么替换
        Node cur = array[index];
        while (cur != null) {
            if(cur.key == key) {
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        //进行头插法
        Node node = new Node(key, val);
        node.next = array[index];
        array[index] = node;
        usedSize++;
        if( loadFactor() >= 0.75f) {
            //扩容
            //array = Arrays.copyOf(array,2*array.length);
            resize();
        }
    }

    private void resize() {
        Node[] newArray = new Node[2*array.length];
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while (cur != null) {
                Node curNext = cur.next;
                int newIndex = cur.key % newArray.length;
                //拿着cur节点 进行插入到新的位置
                cur.next = newArray[newIndex];
                newArray[newIndex] = cur;
                cur =  curNext;
            }
        }
        array = newArray;
    }

    private float loadFactor() {
        return usedSize*1.0f / array.length;
    }

    public int get(int key) {
        int index = key % array.length;
        Node head = array[index];
        while (head != null) {
            if(head.key == key) {
                return head.val;
            }
            head = head.next;
        }
        return -1;
    }
}
