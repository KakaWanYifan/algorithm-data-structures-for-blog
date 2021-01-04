package ch01;

import java.util.Arrays;

/**
 * 对数器
 */
public class Comparator {

    public static void main(String[] args) {
        int testTimes = 5000;
        int maxSize = 100;
        int maxValue = 100;
        boolean isSuccess = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = genRandomArr(maxSize,maxValue);
            int[] arr2 = copyArr(arr1);
            // 用已知方法对数组进行排序
            knownFunc(arr1);
            // 选择排序
            SelectionSort.selectionSort(arr2);
            if (isEqual(arr1,arr2) == false){
                // 只要有一个测试没过，就失败。
                isSuccess = false;
                break;
            }
        }
        System.out.print(isSuccess);
    }

    /**
     * 生成随机长度的随机无序数组
     * @param maxSize 数组的最大长度
     * @param maxValue 数组的最大值
     * @return 随机长度的随机无序数组
     */
    public static int[] genRandomArr(int maxSize,int maxValue){
        int[] arr = new int[(int)(Math.random() * maxSize)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * maxValue);
        }
        return arr;
    }

    /**
     * 复制数组
     * @param arr
     * @return
     */
    public static int[] copyArr(int[] arr){
        if (null == arr){
            return null;
        }

        int[] rnt = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rnt[i] = arr[i];
        }
        return rnt;
    }

    /**
     * 已知函数，这里用Java自带的方法
     * @param arr 需要排序的数组
     */
    public static void knownFunc(int[] arr){
        Arrays.sort(arr);
    }

    /**
     * 判断arr1和arr2是否一致
     * @param arr1 参与比较的数组一
     * @param arr2 参与比较的数组二
     * @return 比较结果
     */
    public static boolean isEqual(int[] arr1,int[] arr2){
        // 先做null的判断
        if ((null == arr1 && null != arr2) || (null != arr1 && null == arr2)){
            return false;
        }
        if (null == arr1 && null == arr2){
            return true;
        }

        // 再做长度的判断
        if (arr1.length != arr2.length){
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            // 只要有一个不相等，就false
            if (arr1[i] != arr2[i]){
                return false;
            }
        }

        return true;
    }
}
