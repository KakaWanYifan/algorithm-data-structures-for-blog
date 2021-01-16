package bak.ch01;

/**
 * 用异或运算做互换
 */
public class XORSwap {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        System.out.println(arr[0]);
        System.out.println(arr[0]);

        arr[0] = arr[0] ^ arr[0];
        arr[0] = arr[0] ^ arr[0];
        arr[0] = arr[0] ^ arr[0];

        System.out.println(arr[0]);
        System.out.println(arr[0]);
    }
}
