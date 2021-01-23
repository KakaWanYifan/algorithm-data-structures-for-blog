package ch05;

public class MergeSort_NO_Recur {

    /**
     * 归并排序
     * @param arr 参与归并排序的数组
     * @return 排序之后的数组
     */
    public int[] mergeSort(int[] arr){
        // 获取数组的长度
        int N = arr.length;
        // 当前归并的数组长度
        int mergeSize = 1;
        // 如果不是所有的数组都归并，就进入循环
        while (mergeSize < N) {
            // 当前左组的，第一个位置
            int L = 0;
            while (L < N) {
                if (mergeSize >= N - L) {
                    break;
                }
                int M = L + mergeSize - 1;
                int R = M + Math.min(mergeSize, N - M - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            // 防止溢出
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }
}
