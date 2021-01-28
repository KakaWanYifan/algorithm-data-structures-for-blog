package ch06;

public class BinarySearchLastLE {

    public static int binarySearchLastLE(int[] arr,int target){
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
            if (arr[midIndex] <= target){
                index = midIndex;
                lIndex = midIndex + 1;
            }else{
                // 反之，如果中间的数字比要找的数字小，说明在右侧
                rIndex = midIndex - 1;
            }
        }
        return index;
    }
}
