package ch06;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 对数器
 */
public class Comparator_BinarySearch {

    public static void main(String[] args) throws Exception {
        int testTimes = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean isSuccess = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = genRandomArr(maxSize,maxValue);
            if (null == arr || arr.length < 1){
                continue;
            }
            Arrays.sort(arr);
            int target = (int)(Math.random() * maxValue);

            ArrayList<Integer> aList = new ArrayList<Integer>();
            boolean a = searchExist(arr,target);
            aList.add(a?1:0);
            aList.add(searchFirstE(arr,target));
            aList.add(searchLastE(arr,target));
            aList.add(searchFirstGE(arr,target));
            aList.add(searchLastLE(arr,target));

            ArrayList<Integer> bList = new ArrayList<Integer>();
            boolean b = BinarySearchExist.binarySearchExist(arr,target);
            bList.add(b?1:0);
            bList.add(BinarySearchFirstE.binarySearchFirstE(arr,target));
            bList.add(BinarySearchLastE.binarySearchLastE(arr,target));
            bList.add(BinarySearchFirstGE.binarySearchFirstGE(arr,target));
            bList.add(BinarySearchLastLE.binarySearchLastLE(arr,target));

            if(!isEqual(aList,bList)){
                System.out.println(Arrays.toString(arr));
                System.out.println(target);
                System.out.println(aList);
                System.out.println(bList);
                isSuccess = false;
                break;
            }
        }
        System.out.print(isSuccess);
    }

    public static boolean isEqual(ArrayList<Integer> a,ArrayList<Integer> b){
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != b.get(i)){
                return false;
            }
        }
        return true;
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

    public static boolean searchExist(int[] arr,int target){
        boolean isExist = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]  == target){
                isExist = true;
                break;
            }
        }
        return isExist;
    }

    public static int searchFirstE(int[] arr,int target){
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]  == target){
                index = i;
                break;
            }
        }
        return index;
    }

    public static int searchLastE(int[] arr,int target){
        int index = -1;
        boolean getEqual = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]  == target){
                getEqual = true;
            }
            if (getEqual == true){
                if (i == arr.length - 1){
                    index = i;
                    break;
                }else{
                    if (arr[i + 1] > target){
                        index = i;
                        break;
                    }
                }
            }
        }
        return index;
    }

    public static int searchFirstGE(int[] arr,int target){
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]  >= target){
                index = i;
                break;
            }
        }
        return index;
    }

    public static int searchLastLE(int[] arr,int target){
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]  > target){
                index = i-1;
                break;
            }
            if (i == arr.length - 1){
                index = i;
            }
        }
        return index;
    }

}
