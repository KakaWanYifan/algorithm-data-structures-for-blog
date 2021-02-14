package ch11;

public class PredictWinner {

    public static int predictWinner(int[] arr,int L,int R){
        if (L == R){
            return arr[L];
        }
        return Math.max(arr[L] - predictWinner(arr,L+1,R),arr[R] - predictWinner(arr,L,R-1));
    }

    public static void main(String[] args) {
        int[] arr = {1,5,8,6};
        if (predictWinner(arr,0,arr.length-1) >= 0){
            System.out.println("玩家一获胜");
        }else{
            System.out.println("玩家二获胜");
        }


        arr = new int[]{7, 13, 1, 5};
        if (predictWinner(arr,0,arr.length-1) >= 0){
            System.out.println("玩家一获胜");
        }else{
            System.out.println("玩家二获胜");
        }

        arr = new int[]{1, 13, 1};
        if (predictWinner(arr,0,arr.length-1) >= 0){
            System.out.println("玩家一获胜");
        }else{
            System.out.println("玩家二获胜");
        }
    }

}
