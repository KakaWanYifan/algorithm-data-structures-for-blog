package ch06;

import java.util.Arrays;

public class BinarySearchFirstE {

    /**
     * 二分法查找是否存在
     * @param sortedArr 排序之后的数组
     * @param num 需要查找的数
     * @return 是否存在
     */
    public static int binarySearchFirstE(int[] arr,int target){
        // 记录位置
        int index = -1;
        // 最左边数字的index
        int lIndex = 0;
        // 最右边数字的index
        int rIndex = arr.length - 1;
        // 中间数字的index
        int midIndex = 0;
        while (lIndex <= rIndex){
            // 中间的index
            // 不写作 (lIndex + rIndex)/2 的原因是这样不容易溢出
            midIndex = lIndex + (rIndex - lIndex) / 2;
            if (arr[midIndex] == target){
                index = midIndex;
                rIndex = midIndex-1;
            }else if (arr[midIndex] > target){
                // 如果中间的数字比要找的数字大，说明在左侧。
                rIndex = midIndex - 1;
            }else{
                // 反之，如果中间的数字比要找的数字小，说明在右侧
                lIndex = midIndex + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 4, 4, 8, 8, 9, 9, 9, 10, 11, 12, 15, 18, 19, 19, 19, 21, 22, 29, 30, 30, 30, 31, 31, 33, 33, 33, 35, 36, 37, 38, 38, 39, 39, 40, 40, 41, 43, 43, 44, 46, 46, 47, 48, 49, 49, 49, 52, 52, 52, 53, 57, 59, 63, 65, 66, 68, 70, 70, 71, 71, 72, 72, 73, 74, 78, 78, 80, 82, 83, 83, 84, 84, 86, 86, 86, 86, 86, 89, 89, 90, 91, 92, 93, 94, 94, 95, 96, 97, 97, 98};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int target = 72;
        System.out.println(binarySearchFirstE(arr,target));
    }
}
