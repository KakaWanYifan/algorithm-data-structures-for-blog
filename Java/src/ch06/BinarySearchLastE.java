package ch06;

import java.util.Arrays;

public class BinarySearchLastE {

    public static int binarySearchLastE(int[] sortedArr,int num){
        // 记录第一个位置
        int index = -1;
        // 最左边数字的index
        int lIndex = 0;
        // 最右边数字的index
        int rIndex = sortedArr.length - 1;
        // 中间数字的index
        int midIndex = 0;
        // 一定是 lIndex < rIndex
        // 不能是 lIndex != rIndex
        while (lIndex <= rIndex){
            // 中间的index
            // 不写作 (lIndex + rIndex)/2 的原因是这样不容易溢出
            midIndex = lIndex + (rIndex - lIndex) / 2;
            if (sortedArr[midIndex] == num){
                index = midIndex;
                lIndex = midIndex + 1;
            }else if (sortedArr[midIndex] > num){
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
        int[] arr = {2, 3, 5, 9, 9, 10, 10, 10, 10, 11, 11, 13, 14, 16, 18, 21, 25, 27, 27, 31, 35, 36, 37, 37, 38, 39, 39, 39, 39, 39, 41, 42, 42, 42, 43, 44, 44, 45, 45, 48, 48, 48, 48, 49, 49, 51, 53, 53, 54, 55, 56, 56, 56, 57, 59, 60, 60, 62, 62, 67, 67, 67, 72, 77, 77, 78, 82, 83, 84, 86, 88, 94, 94, 95, 98, 98, 99};
        System.out.println(Arrays.toString(arr));
        int target = 37;
        System.out.println(binarySearchLastE(arr,target));
    }
}
