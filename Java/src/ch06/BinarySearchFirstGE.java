package ch06;

import java.util.Arrays;

public class BinarySearchFirstGE {

    /**
     * 二分法查找是否存在
     * @param sortedArr 排序之后的数组
     * @param num 需要查找的数
     * @return 是否存在
     */
    public static int binarySearchFirstGE(int[] arr,int target){
        int index = -1;
        // 最左边数字的index
        int lIndex = 0;
        // 最右边数字的index
        int rIndex = arr.length - 1;
        // 中间数字的index
        int midIndex = 0;
        // 一定是 lIndex <= rIndex
        while (lIndex <= rIndex){
            // 中间的index
            // 不写作 (lIndex + rIndex)/2 的原因是这样不容易溢出
            midIndex = lIndex + (rIndex - lIndex) / 2;
            if (arr[midIndex] >= target){
                index = midIndex;
                rIndex = midIndex - 1;
            }else{
                // 反之，如果中间的数字比要找的数字小，说明在右侧
                lIndex = midIndex + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {26, 76, 81, 81, 82, 84};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int target = 19;
        System.out.println(binarySearchFirstGE(arr,target));
    }
}
