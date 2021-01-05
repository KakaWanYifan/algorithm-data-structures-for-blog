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

        // 如果前面的条件都没有命中，说明左侧递减，右侧递增。
        // 所以，必存在极值在中间区域
        // 左边是left
        int left = 1;
        // 右边是T-2
        int right = arr.length - 2;
        // 中间
        int mid = 0;
        while (left != right) {
            mid = (left + right) / 2;
            // 如果中间值比中间偏左的值大，是递增。
            // 且已知左侧递减，又中间递增。
            // 所以必存在极值在左侧和中间的之间区域。
            // 所以把右侧边界移动到中间。
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            // 如果中间值比中间偏右的值大，是递减。
            // 且已知右侧递增，又中间递减。
            // 所以必存在极值在中间和右侧的之间区域。
            // 所以把左侧边界移动到中间。
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                // 如果前面的都有命中的话，说明拿到了局部最小值
                return mid;
            }
        }
        return left;
    }
}
