package ch09;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapComparator {

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
        TreeMap<C,String> treeMap = new TreeMap<C,String>(new com());
        treeMap.put(new C("c1",3),"三");
        treeMap.put(new C("c2",1),"一");
        treeMap.put(new C("c3",4),"四");
        treeMap.put(new C("c4",5),"五");
        // treeMap.put(new C("c5",9),"九");
        treeMap.put(new C("c6",2),"二");
        treeMap.put(new C("c7",6),"六");

        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.lastKey());

        System.out.println(treeMap.floorKey(new C("c5",9)));
        System.out.println(treeMap.ceilingKey(new C("c5",9)));

    }


}
