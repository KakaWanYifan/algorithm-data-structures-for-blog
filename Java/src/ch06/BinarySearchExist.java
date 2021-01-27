package ch06;

public class BinarySearchExist {

    /**
     * 二分法查找是否存在
     * @param sortedArr 排序之后的数组
     * @param num 需要查找的数
     * @return 是否存在
     */
    public static boolean binarySearchExist(int[] arr,int target){
        // 最左边数字的index
        int lIndex = 0;
        // 最右边数字的index
        int rIndex = arr.length - 1;
        // 中间数字的index
        int midIndex = 0;
        // 一定是 lIndex < rIndex
        // 不能是 lIndex != rIndex
        while (lIndex < rIndex){
            // 中间的index
            // 不写作 (lIndex + rIndex)/2 的原因是这样不容易溢出
            midIndex = lIndex + (rIndex - lIndex) / 2;
            if (arr[midIndex] == target){
                // 如果中间的数字就是要找的数字
                return true;
            }else if (arr[midIndex] > target){
                // 如果中间的数字比要找的数字大，说明在左侧。
                rIndex = midIndex - 1;
            }else{
                // 反之，如果中间的数字比要找的数字小，说明在右侧
                lIndex = midIndex + 1;
            }
        }
        return (arr[lIndex] == target);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,7,11,13,17,19,23,29,31,37};
        int num = 8;
        System.out.print(binarySearchExist(arr,num));
    }

}
