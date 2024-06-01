import java.util.Arrays;

/**
 * @Author 12629
 * @Description：
 */
public class TestHeap {

    public int[] elem;

    public int usedSize;//有效的数据个数

    public static final int DEFAULT_SIZE = 10;

    public TestHeap() {
        elem = new int[DEFAULT_SIZE];
    }

    public void initElem(int[] array) {
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
    }

    /**
     * 时间复杂度：O(n)
     */
    public void createHeap() {
        for (int parent = (usedSize-1-1)/2; parent >= 0 ; parent--) {
            //统一的调整方案
            shiftDown(parent,usedSize);
        }
    }

    /**
     *
     * @param parent 每棵子树的根节点
     * @param len  每棵子树调整的结束位置 不能>len
     *             时间复杂度：O(log n)
     */
    private void shiftDown(int parent,int len) {
        int child = 2*parent+1;
        //1. 必须保证有左孩子
        while (child < len) {
            //child+1 < len && 保证有右孩子
            if(child+1 < len && elem[child] < elem[child+1]) {
                child++;
            }
            //child下标 一定是左右孩子 最大值的下标
           /* if(elem[child] < elem[child+1] && child+1 < len ) {
                child++;
            }*/
            if(elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    public void offer(int val) {
        if(isFull()) {
            //扩容
            elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[usedSize] = val;
        usedSize++;
        //想办法让他再次变成大根堆
        shiftUp(usedSize-1);
    }

    private void shiftUp(int child) {
        int parent = (child-1) / 2;
        while (child > 0) {//parent >= 0
            if (elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }

    public boolean isFull() {
        return usedSize == elem.length;
    }


    public int pop() {
        if(isEmpty()) {
            return -1;
        }
        int tmp = elem[0];
        elem[0] = elem[usedSize-1];
        elem[usedSize-1] = tmp;
        usedSize--;
        //保证他仍然是一棵大根堆
        shiftDown(0,usedSize);
        return tmp;
    }
    public boolean isEmpty() {
        return usedSize == 0;
    }

    public int peek() {
        if(isEmpty()) {
            return -1;
        }
        return elem[0];
    }


    /**
     * 时间复杂度：
     *  O(n) + O(n*logn) 约等于 O(nlogn)
     *  空间复杂度：O(1)
     */
    public void heapSort() {
        //1.建立大根堆 O(n)
        createHeap();
        //2.然后排序
        int end = usedSize-1;
        while (end > 0) {
            int tmp = elem[0];
            elem[0] = elem[end];
            elem[end] = tmp;
            shiftDown(0,end);
            end--;
        }
    }
}
