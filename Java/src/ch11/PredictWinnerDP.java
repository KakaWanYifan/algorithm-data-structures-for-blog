package ch11;

public class PredictWinnerDP {

    public static int predictWinner(int[] arr){
        Integer[][] dp = new Integer[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i][i] = arr[i];
        }
        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = i+1;j< arr.length;j++){
                dp[i][j]=Math.max(arr[i]-dp[i+1][j],arr[j]-dp[i][j-1]);
            }
        }
        return dp[0][arr.length-1];
    }

    public static void main(String[] args) {
        int[] arr = {1,5,8,6};
        if (predictWinner(arr) >= 0){
            System.out.println("玩家一获胜");
        }else{
            System.out.println("玩家二获胜");
        }


        arr = new int[]{7, 13, 1, 5};
        if (predictWinner(arr) >= 0){
            System.out.println("玩家一获胜");
        }else{
            System.out.println("玩家二获胜");
        }

        arr = new int[]{1, 13, 1};
        if (predictWinner(arr) >= 0){
            System.out.println("玩家一获胜");
        }else{
            System.out.println("玩家二获胜");
        }
    }

}
