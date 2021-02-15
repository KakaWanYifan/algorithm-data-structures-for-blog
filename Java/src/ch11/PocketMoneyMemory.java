package ch11;

public class PocketMoneyMemory {

    public static int process(int[] arr,int index,int rest,int[][] memory){
        // 如果算过
        if (memory[index][rest] != -1){
            return memory[index][rest];
        }
        // 如果没有货币可选了
        if (index == arr.length){
            // 恰好换完了，那么这也是一种方法，啥也不换
            // 否则，不是方法

            // 记住
            memory[index][rest] = rest == 0 ? 1:0;
            return memory[index][rest];
        }
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            ways = ways + process(arr,index+1,rest-(zhang*arr[index]),memory);
        }

        // 记住
        memory[index][rest] = ways;
        return memory[index][rest];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,10,20,50};
        int total = 100;
        // 记忆
        // -1代表没有记忆
        // 一开始没有记忆
        int[][] memory = new int[arr.length + 1][total+1];
        for (int i = 0; i < memory.length; i++) {
            for (int j = 0; j < memory[i].length; j++) {
                memory[i][j] = -1;
            }
        }
        System.out.println(process(arr,0,total,memory));
    }
}
