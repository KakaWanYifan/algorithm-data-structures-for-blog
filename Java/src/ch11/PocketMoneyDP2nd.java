package ch11;

public class PocketMoneyDP2nd {

    public static void main(String[] args) {
        int[] arr = {1,2,5,10,20,50};
        int total = 100;
        int[][] dp = new int[arr.length + 1][total+1];

        dp[arr.length][0] = 1;

        for (int index = arr.length-1;index >= 0;index--){
            for (int rest = 0; rest <= total; rest++) {
                // a
                dp[index][rest] = dp[index + 1][rest];
                if (rest - arr[index] >= 0){
                    // 问号 = a + 星号
                    dp[index][rest] = dp[index][rest] + dp[index][rest-arr[index]];
                }
            }
        }

        // 最终要 0-total 的值
        System.out.println(dp[0][total]);
    }

}
