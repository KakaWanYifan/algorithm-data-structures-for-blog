package ch05;

import java.util.Arrays;

public class MergeSort {

    /**
     * 归并排序
     * @param arr 参与归并排序的数组
     * @param L 左指针【两个指针其实在这里起到了分组的作用】
     * @param R 右指针【两个指针其实在这里起到了分组的作用】
     * @return 排序之后的数组
     */
    public static int[] mergeSort(int[] arr,int L,int R) throws Exception {

        // 如果左指针等于右指针，说明已经拆分到不可以拆分了，这时候arr就是只有一个元素的数组
        // 递归中的BaseCase
        if (L == R){
            return arr;
        }

        // 如果L不等于R，说明不止一个数，那么，递归吧
        // 中间
        int M = (L+R)/2;
        // 递归
        mergeSort(arr, L, M);
        mergeSort(arr,M+1,R);
        // 合并操作
        merge(arr, L, M, R);
        return arr;
    }

    /**
     * 归并操作
     * @param arr
     * @param L L到M 左侧
     * @param M M+1到R 右侧
     * @param R
     */
    private static void merge(int[] arr, int L, int M, int R) {
        // 辅助数组 大小是 R-L+1，即归并之后的数组的大小
        int[] help = new int[R - L + 1];
        // 辅助数组的指针
        int helpPoint = 0;

        // 指针一，第一个数组的指针
        int p1 = L;
        // 指针二，第二个数组的指针
        int p2 = M + 1;
        // 如果指针一和指针二都没结束
        while (p1 <= M && p2 <= R) {
            // 谁小放谁
            // 这里就有一个`i++`的技巧
            help[helpPoint++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        // 要么p1越界了，要么p2越界了
        while (p1 <= M) {
            help[helpPoint++] = arr[p1++];
        }

        while (p2 <= R) {
            help[helpPoint++] = arr[p2++];
        }

        // 归并之后，把数据从辅助数组中塞回去
        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println(Arrays.toString(arr));
        // 只有数组不为空，并且数组的长度大于1，这时候的排序才有意义
        if (null != arr && arr.length > 1){
            arr = mergeSort(arr,0,arr.length-1);
        }
        System.out.println(Arrays.toString(arr));
    }

}
