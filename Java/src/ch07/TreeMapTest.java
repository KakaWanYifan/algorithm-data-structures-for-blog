package ch07;

import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<Integer,String> treeMap = new java.util.TreeMap<Integer,String>();
        treeMap.put(3,"三");
        treeMap.put(1,"一");
        treeMap.put(4,"四");
        // treeMap.put(5,"五");
        treeMap.put(9,"九");
        treeMap.put(2,"二");
        treeMap.put(6,"六");

        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.lastKey());

        System.out.println(treeMap.floorKey(5));
        System.out.println(treeMap.ceilingKey(5));

    }

}
