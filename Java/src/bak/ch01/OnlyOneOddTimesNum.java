package ch01;

/**
 * 唯一的出现奇数次的数字
 */
public class OnlyOneOddTimesNum {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,2,1};
        System.out.println(onlyOneOddTimesNum(arr));
    }

    /**
     * 唯一的奇数次的数字
     * @param arr
     * @return 唯一的奇数次的数字
     */
    public static int onlyOneOddTimesNum(int[] arr){
        int eor = 0;
        for (int iter:arr) {
            eor = eor^iter;
        }
        return eor;
    }
}
