package Ch01;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println(Arrays.toString(arr));
        // 只有数组不为空，并且数组的长度大于1，这时候的排序才有意义
        if (null != arr && arr.length > 1){
            arr = selectionSort(arr);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     * @param arr 需要排序的数组
     * @return 排序之后的数组
     */
    public static int[] selectionSort(int[] arr){
        // 第一轮是 from 0 to n-1
        // 第二轮是 from 1 to n-1
        // 第三轮是 from 2 to n-1
        for (int i = 0; i < arr.length; i++) {
            // 最小值的位置
            int minIndex = i;
            // 从第i+1个数到第n个数
            for (int j = i+1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j:minIndex;
            }
            swap(arr,i,minIndex);
        }
        return arr;
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
