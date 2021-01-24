package ch05;

import java.util.Arrays;

public class NetherlandsFlag_QuickSort {


    /**
     * 荷兰国旗过程
     * @param arr 需要进行荷兰国旗过程的数组
     * @param L 左边界
     * @param R 右边界
     * @return 荷兰国旗过程之后的新的边界
     */
    public static int[] netherlandsFlag(int[] arr,int L,int R){

        // 小于边界
        // 小于边界的起始位置在左边界的左
        int less = L - 1;
        // 大于边界
        // 大于边界本来是应该在右边界的右，我们这里，暂时把Arr[R]包裹进去，后面再换一下。
        int more = R;
        // index指针，用来遍历
        int index = L;
        // index只能没有和大于边界相遇
        while (index < more) {
            // 这一段过程就是荷兰国旗过程了
            // 对着逻辑敲代码
            if (arr[index] == arr[R]) {
                index = index + 1;
            } else if (arr[index] < arr[R]) {
                swap(arr, less + 1, index);
                less = less + 1;
                index = index + 1;
            } else {
                swap(arr, index, more-1);
                more = more - 1;
            }
        }
        // 把Arr[R]移过去
        swap(arr, more, R);

        return new int[] { less + 1, more };
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

    /**
     * 快速排序
     * @param arr 参与排序的数组
     * @param L 左边界
     * @param R 右边界
     */
    public static int[] quickSort(int[] arr, int L, int R) {
        if (L >= R) {
            return arr;
        }
        int[] equalArea = netherlandsFlag(arr, L, R);
        quickSort(arr, L, equalArea[0] - 1);
        quickSort(arr, equalArea[1] + 1, R);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println(Arrays.toString(arr));
        // 只有数组不为空，并且数组的长度大于1，这时候的排序才有意义
        if (null != arr && arr.length > 1){
            arr = quickSort(arr,0,arr.length-1);
        }
        System.out.println(Arrays.toString(arr));
    }
}
