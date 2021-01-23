package ch01;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println(Arrays.toString(arr));
        // 只有数组不为空，并且数组的长度大于1，这时候的排序才有意义
        if (null != arr && arr.length > 1){
            arr = bubbleSort(arr);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr){
        // 第一轮 从index为0的数字，到index为n-1的数字，进行比较，冒泡
        // 第一轮 从index为0的数字，到index为n-2的数字，进行比较，冒泡
        for (int i = 0; i < arr.length; i++) {
            // 定义是否完成，初始状态为完成，后面只要有数据交换，就定义为没有完成。
            boolean isComplete = true;

            int maxIndex = arr.length - i - 1;
            for (int j = 0; j < maxIndex; j++) {
                if (arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                    isComplete = false;
                }
            }
            // 如果已经完成了，break
            if (isComplete){
                break;
            }
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
