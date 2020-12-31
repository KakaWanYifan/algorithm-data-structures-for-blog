package Ch01;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println(Arrays.toString(arr));
        // 只有数组不为空，并且数组的长度大于1，这时候的排序才有意义
        if (null != arr && arr.length > 1){
            arr = insertionSort(arr);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     * @param arr
     * @return
     */
    public static int[] insertionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int maxIndex = i;
            for (int j = maxIndex; j > 0; j--) {
                if (arr[j] < arr[j-1]){
                    swap(arr,j,j-1);
                }else{
                    break;
                }
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
