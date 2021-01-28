package ch06;

import java.util.Arrays;

/**
 * 插入排序
 */
public class BinaryInsertionSort {

    public static void main(String[] args) {
        int[] arr = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println(Arrays.toString(arr));
        // 只有数组不为空，并且数组的长度大于1，这时候的排序才有意义
        if (null != arr && arr.length > 1){
            arr = binaryInsertionSort(arr);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     * @param arr
     * @return
     */
    public static int[] binaryInsertionSort(int[] arr){
        // i从1开始，先做到前2个数有序。
        // 为什么不是先做到前1个数有序？一个数字，不用排序了。
        for (int i = 1; i < arr.length; i++) {
            // 保存当前值
            int key = arr[i];
            // 利用二分查找定位插入位置
			int index = binarySearchLastLE(arr, key, 0, i - 1) + 1;
            // 将目标插入位置，同一时候右移目标位置右边的元素
            for (int j = i; j > index; j--) {
                arr[j] = arr[j - 1];
            }
            arr[index] = key;
        }

        return arr;
    }

    /**
     * 二分查找最后一个小于等于的位置
     * @param sortedArr
     * @param num
     * @param from
     * @param to
     * @return
     */
    private static int binarySearchLastLE(int[] sortedArr, int num, int from, int to) {
        int index = -1;
        // 最左边数字的index
        int lIndex = from;
        // 最右边数字的index
        int rIndex = to;
        // 中间数字的index
        int midIndex = 0;
        // 一定是 lIndex <= rIndex
        while (lIndex <= rIndex){
            // 中间的index
            // 不写作 (lIndex + rIndex)/2 的原因是这样不容易溢出
            midIndex = lIndex + (rIndex - lIndex) / 2;
            if (sortedArr[midIndex] <= num){
                index = midIndex;
                lIndex = midIndex + 1;
            }else{
                // 反之，如果中间的数字比要找的数字小，说明在右侧
                rIndex = midIndex - 1;
            }
        }
        return index;
    }

    /**
     * 互换
     * @param arr 数组
     * @param i 需要互换的元素的index
     * @param j 需要互换的元素的index
     */
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
