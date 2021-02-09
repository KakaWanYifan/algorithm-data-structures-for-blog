package ch09;

import java.util.Arrays;

public class HeapSort {

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     *
     * @param arr
     * @return
     */
    public static int[] heapSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        // 1、建堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            heapify(arr, arr.length - 1, i);
        }

        // 2、排序
        int k = arr.length - 1;
        while (k > 0) {
            // 将堆顶元素（最大）与最后一个元素交换位置
            swap(arr, 0, k);
            // 将剩下元素重新堆化，堆顶元素变成最大元素
            k = k - 1;
            heapify(arr, k, 0);
        }
        return arr;
    }

    private static void heapify(int[] arr, int n, int i) {
        while (true) {
            // 最大值位置
            int maxPos = i;
            // 与左子节点（i * 2 + 1）比较，获取最大值位置
            if (i * 2 + 1 <= n && arr[i] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            // 最大值与右子节点（i * 2 + 2）比较，获取最大值位置
            if (i * 2 + 2 <= n && arr[maxPos] < arr[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            // 最大值是当前位置结束循环
            if (maxPos == i) {
                break;
            }
            // 与子节点交换位置
            swap(arr, i, maxPos);
            // 以交换后子节点位置接着往下查找
            i = maxPos;
        }
    }


    public static void main(String[] args) {
        int[] arr = {33, 99, 27, 9, 58, 6, 55, 38, 57, 34, 98, 75, 61, 86, 9, 22, 79, 80, 2, 0, 13, 39, 76, 62, 80, 34, 9, 32, 90, 95, 4, 32, 56, 11, 93, 4, 77, 57, 34, 71, 69, 44, 66, 100, 0, 29, 10, 23, 76, 77, 74, 40, 96, 31, 17, 57, 29, 53, 19, 15, 89, 31, 83, 85, 38, 9, 32, 58, 6, 41, 36, 56, 91, 99, 80, 12, 20, 17, 66, 29, 67, 93, 82, 2, 24, 49, 100, 22, 35, 94, 72, 21, 55, 25, 38, 79, 93, 28, 100};
        System.out.println(Arrays.toString(arr));
        // 只有数组不为空，并且数组的长度大于1，这时候的排序才有意义
        if (null != arr && arr.length > 1){
            heapSort(arr);
        }
        System.out.println(Arrays.toString(arr));
    }
}