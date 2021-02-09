package ch09;

import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        q.offer(3);
        q.offer(1);
        q.offer(4);
        q.offer(1);
        q.offer(5);
        q.offer(9);
        q.offer(2);
        q.offer(6);

        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());

    }
}
