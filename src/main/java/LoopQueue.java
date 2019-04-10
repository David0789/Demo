package main.java;

/**
 *  循环队列
 */
class LoopQueue {

    private int[] list;

    private int front;

    private int tail;

    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k.
     *  构造器，设置队列长度为 k */
    public LoopQueue(int k) {
        list = new int[k];
        front = -1;
        tail = -1;
        size = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful.
     * 向循环队列插入一个元素。如果成功插入则返回真。*/
    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }

        if (isEmpty()) {
            front = 0;
            tail = -1;
        }

        tail = (tail + 1) % size;
        list[tail] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful.
     * 从循环队列中删除一个元素。如果成功删除则返回真。*/
    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }

        if (front == tail) {
            front = -1;
            tail = -1;
        } else {
            front = (front + 1) % size;
        }
        return true;
    }

    /** Get the front item from the queue.
     * 从队首获取元素。如果队列为空，返回 -1 。*/
    public int Front() {
        return isEmpty() ? -1 : list[front];
    }

    /** Get the last item from the queue.
     * 获取队尾元素。如果队列为空，返回 -1 。*/
    public int Rear() {
        return isEmpty() ? -1 : list[tail];
    }

    /** Checks whether the circular queue is empty or not.
     * 检查循环队列是否为空。*/
    public boolean isEmpty() {
        return front == -1;
    }

    /** Checks whether the circular queue is full or not.
     * 检查循环队列是否已满。*/
    public boolean isFull() {
        if (tail >= front && tail - front == size -1) {
            return true;
        } else if (tail < front && front - tail == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        LoopQueue circularLoopQueue = new LoopQueue(3); // 设置长度为 3
        circularLoopQueue.enQueue(1);  // 返回 true
        circularLoopQueue.Rear();  // 返回 3
        circularLoopQueue.isFull();  // 返回 true
        circularLoopQueue.deQueue();  // 返回 true
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */