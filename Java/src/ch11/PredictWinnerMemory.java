package ch11;

public class PredictWinnerMemory {

    public static int predictWinner(int[] arr,int L,int R,Integer[][] memory){
        if (null != memory[L][R]){
            return memory[L][R];
        }
        if (L == R){
            memory[L][R] = arr[L];
            return memory[L][R];
        }
        int a = 0;
        if (null != memory[L+1][R]){
            a = memory[L+1][R];
        }else {
            a = predictWinner(arr,L+1,R,memory);
        }
        int b = 0;
        if (null !=  memory[L][R-1]){
            b = memory[L][R-1];
        }else {
            b = predictWinner(arr,L,R-1,memory);
        }
        memory[L][R] = Math.max(arr[L] - a,arr[R] - b);
        return memory[L][R];
    }

    public static void main(String[] args) {
        int[] arr = {1,5,8,6};
        Integer[][] memory = new Integer[arr.length][arr.length];
        if (predictWinner(arr,0,arr.length-1,memory) >= 0){
            System.out.println("玩家一获胜");
        }else{
            System.out.println("玩家二获胜");
        }


        arr = new int[]{7, 13, 1, 5};
        memory = new Integer[arr.length][arr.length];
        if (predictWinner(arr,0,arr.length-1,memory) >= 0){
            System.out.println("玩家一获胜");
        }else{
            System.out.println("玩家二获胜");
        }

        arr = new int[]{1, 13, 1};
        memory = new Integer[arr.length][arr.length];
        if (predictWinner(arr,0,arr.length-1,memory) >= 0){
            System.out.println("玩家一获胜");
        }else{
            System.out.println("玩家二获胜");
        }
    }

}
