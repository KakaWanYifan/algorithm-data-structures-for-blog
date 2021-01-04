package ch01;

/**
 * 统计二进制中一的个数
 */
public class CountBitOne {

    public static void main(String[] args) {
        System.out.println(countBitOne(0));
        System.out.println(countBitOne(1));
        System.out.println(countBitOne(2));
        System.out.println(countBitOne(3));
    }

    /**
     * 统计二进制中一的个数
     * @param N 给定的一个数
     * @return 给定的数中，转换成二进制的时候，1的个数
     */
    public static int countBitOne(int N){
        int count = 0;
        while (N != 0){
            int rightOne = N & ((~N) + 1);
            count++;
            N = N ^ rightOne;
        }
        return count;
    }
}
