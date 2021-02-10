package ch09;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueComparator {

    public static class C {
        public String k;
        public Integer v;
        public C(String key, int value){
            k = key;
            v = value;
        }

        @Override
        public String toString() {
            return "C{" +
                    "k='" + k + '\'' +
                    ", v=" + v +
                    '}';
        }
    }

    static class com implements Comparator<C> {

        @Override
        public int compare(C o1, C o2) {
            return o2.v - o1.v;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<C> q = new PriorityQueue<C>(new com());
        q.offer(new C("c1",3));
        q.offer(new C("c2",1));
        q.offer(new C("c3",4));
        q.offer(new C("c4",5));
        q.offer(new C("c5",9));

        System.out.println(q.poll().toString());
        System.out.println(q.poll().toString());
        System.out.println(q.poll().toString());
        System.out.println(q.poll().toString());
        System.out.println(q.poll().toString());

    }
}
