package ch11;

import java.util.Arrays;

public class PocketMoneyDP  {

    public static void main(String[] args) {
        int[] arr = {1,2,5,10,20,50};
        int total = 100;
        int[][] dp = new int[arr.length + 1][total+1];

        // 根据之前的递归代码，我们知道"dp[arr.length][0] = 1"
        // if (index == arr.length){
        //     return rest == 0 ? 1:0;
        // }
        dp[arr.length][0] = 1;

        // 根据我们的递推代码
        // ways = ways + process(arr,index+1,rest-(zhang*arr[index]),memory);
        // 所以，我们可以通过第N行，推出第N-1行；通过第N-1行，推出第N-2行。
        // arr.length行在上一步已经填好了
        for (int index = arr.length-1;index >= 0;index--){
            for (int rest = 0; rest <= total; rest++) {
                // 把dp[index][rest]填好
                int ways = 0;
                for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
                    ways = ways + dp[index+1][rest - (zhang * arr[index])];
                }
                dp[index][rest] = ways;
            }
        }

        // 最终要 0-total 的值
        System.out.println(dp[0][total]);
    }

}
