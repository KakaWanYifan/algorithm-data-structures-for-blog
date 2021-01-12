package ch02;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArray {

    public static void main(String[] args) {
        // func1();
        func2();
    }

    public static void func1(){
        // 初始化一个长度为5的ArrayList
        ArrayList<Integer> a = new ArrayList<Integer>(5);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        System.out.println(a);
        a.add(6);
        System.out.println(a);
    }

    public static void func2(){
        int[] a = new int[5];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 5;
        System.out.println(Arrays.toString(a));
        a[5] = 6;
        System.out.println(a);

    }

}
