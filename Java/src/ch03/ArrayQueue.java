package ch03;

import java.util.Stack;

public class ArrayQueue {

    // 数组
    private int[] array;
    // 队头
    private int head;
    // 队尾
    private int tail;

    public ArrayQueue(int capacity) {
        this.array = new int[capacity];
    }


    /**
     * 出队
     * @return 出队的元素
     * @throws Exception 队列是空的
     */
    public int deQueue() throws Exception {
        if (tail == head){
            throw new Exception("队列是空的");
        }
        // 即将出队的元素
        int data = array[head];
        // head指针后移
        head = (head + 1) % array.length;
        return data;
    }

    /**
     * 入队
     * @param data 入队的元素
     * @throws Exception 队列是满的
     */
    public void enQueue(int data) throws Exception {
        if ((tail + 1) % array.length == head){
            throw new Exception("队列是满的");
        }
        array[tail] = data;
        tail =(tail+1)%array.length;
    }


    /**
     * 输出队列
     */
    public void output(){
        String rnt = "";
        for(int i=head; i!=tail; i=(i+1)%array.length){
            rnt = rnt + array[i] + " ";
        }
        System.out.println(rnt);
    }

    public static void main(String[] args) throws Exception {
        ArrayQueue arrayQueue = new ArrayQueue(6);
        arrayQueue.enQueue(1);
        arrayQueue.enQueue(2);
        arrayQueue.enQueue(3);
        arrayQueue.enQueue(4);
        arrayQueue.enQueue(5);
        arrayQueue.deQueue();
        arrayQueue.deQueue();
        arrayQueue.deQueue();
        arrayQueue.enQueue(6);
        arrayQueue.enQueue(7);
        arrayQueue.enQueue(8);
        arrayQueue.output();
    }
}



