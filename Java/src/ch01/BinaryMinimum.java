package ch01;

/**
 * 二分法 局部最小
 */
public class BinaryMinimum {

    public static void main(String[] args) {
        int[] arr = {3,1,4, 1, 5, 9, 2, 6, 5, 3,5};
        int index = binaryMinimumIndex(arr);
        System.out.println(index);
        System.out.println(arr[index]);
    }

    /**
     * 二分法 局部最小
     * @param arr
     * @return
     */
    public static int binaryMinimumIndex(int[] arr){

        // 如果数组的长度是1
        if (arr.length == 1){
            // 那么，局部最小值就是index为0值
            return 0;
        }

        // 如果arr[0] 小于 arr[1]
        if (arr[0] < arr[1]){
            // 那么，arr[0]就是局部最小值
            return 0;
        }

        // 如果arr[T-1] 小于 arr[T-2]
        if (arr[arr.length - 1] < arr[arr.length - 2]){
            // 那么，arr[T-1]就是局部最小值
            return arr.length - 1;
        }

        // 左边是left
        int left = 1;
        // 右边是T-2
        int right = arr.length - 2;
        // 中间
        int mid = 0;
        while (left != right) {
            mid = (left + right) / 2;
            // 如果中间值比左边值大，那么说明从中间到左边，是递增。
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            // 如果中间值比右边值大，那么说明从中间到右边，是递增。
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                // 都不是的话，说明拿到了局部最小值
                return mid;
            }
        }
        return left;
    }
}
