package ch01;

/**
 * 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 15, 19, 26, 27, 36, 38, 44, 46, 47, 48, 50};
        int num = 18;
        System.out.print(binarySearchExist(arr,num));
    }

    /**
     * 二分法查找是否存在
     * @param sortedArr 排序之后的数组
     * @param num 需要查找的数
     * @return 是否存在
     */
    public static boolean binarySearchExist(int[] sortedArr,int num){
        // 最左边数字的index
        int lIndex = 0;
        // 最右边数字的index
        int rIndex = sortedArr.length - 1;
        // 中间数字的index
        int midIndex = 0;
        while (lIndex != rIndex){
            // 中间的index
            // 不写作 (lIndex + rIndex)/2 的原因是这样不容易溢出
            midIndex = lIndex + (rIndex - lIndex) / 2;
            if (sortedArr[midIndex] == num){
                // 如果中间的数字就是要找的数字
                return true;
            }else if (sortedArr[midIndex] > num){
                // 如果中间的数字比要找的数字大，说明在左侧。
                rIndex = midIndex - 1;
            }else{
                // 反之，如果中间的数字比要找的数字小，说明在右侧
                lIndex = midIndex + 1;
            }
        }
        return (sortedArr[lIndex] == num);
    }

}
