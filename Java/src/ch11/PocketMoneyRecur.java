package ch11;

public class PocketMoneyRecur {

    public static int process(int[] arr,int index,int rest){
        // 如果没有货币可选了
        if (index == arr.length){
            // 恰好换完了，那么这也是一种方法，啥也不换
            // 否则，不是方法
            return rest == 0 ? 1:0;
        }
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            ways = ways + process(arr,index+1,rest-(zhang*arr[index]));
        }
        return ways;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,10,20,50};
        int total = 100;
        System.out.println(process(arr,0,total));
    }
}
