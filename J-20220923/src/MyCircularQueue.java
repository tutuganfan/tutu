class MyCircularQueue {

    private int[] elem;
    public int front;//队头
    public int rear;//队尾

    public MyCircularQueue(int k) {
        elem = new int[k];
    }

    //入队列
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        elem[rear] = value;
        rear = (rear+1) % elem.length;
        return true;
    }

    public boolean isFull() {
        if((rear+1) % elem.length == front) {
            return true;
        }
        return false;
    }

    
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        front = (front+1) % elem.length;
        return true;
    }

    public boolean isEmpty() {
        if(front == rear) {
            return true;
        }
        return false;
    }
    //获取队头元素
    public int Front() {
        if(isEmpty()) {
            return -1;
        }
        return elem[front];
    }
    
    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        int index = rear == 0 ? elem.length-1 : rear-1;
        return elem[index];
    }
}