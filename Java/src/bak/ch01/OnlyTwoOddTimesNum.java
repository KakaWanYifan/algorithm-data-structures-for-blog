package ch01;

import java.util.Arrays;

/**
 * 唯二的奇数次的代码
 */
public class OnlyTwoOddTimesNum {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,0,9,8,7,6,5,4,3,2};
        int[] rnt = onlyTwoOddTimesNum(arr);
        System.out.println(Arrays.toString(rnt));
    }

    /**
     * 唯二的奇数次的数字
     * @param arr
     * @return 唯二的奇数次的数字
     */
    public static int[] onlyTwoOddTimesNum(int[] arr){
        int eor = 0;
        for (int iter:arr) {
            eor = eor ^ iter;
        }
        // eor != 0
        // eor 必定有一个位置是 1
        // 提取出最右侧的 1
        int rightOne = eor & (~eor + 1);
        // eor'
        int eor2nd = 0;
        for (int iter: arr) {
            // 如果iter与rightOne之后不等于0，说明与right在同一个地方有1
            if ((iter & rightOne) != 0){
                // 异或进 eor'
                eor2nd = eor2nd ^ iter;
            }
        }
        int[] rnt = {eor2nd,(eor^eor2nd)};
        return rnt;
    }
}
