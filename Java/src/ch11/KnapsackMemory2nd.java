package ch11;

public class KnapsackMemory2nd {

    /**
     *
     * @param wArr 投资数额
     * @param pArr 投资收益
     * @param index
     * @param rest 剩余可用资金
     * @return -1 该投资不可行
     */
    public static int process(int[] wArr , int[] pArr, int index, int rest,int[][] memory) {
        // 该投资不可行
        if (rest < 0) {
            return -1;
        }
        if (memory[index][rest] != -1){
            return memory[index][rest];
        }
        // 没有更多投资项目
        if (index == wArr.length) {
            memory[index][rest] = 0;
            return memory[index][rest];
        }
        // 投资该项目
        int p1 = 0;
        int next = process(wArr, pArr, index + 1, rest - wArr[index],memory);
        if (next != -1) {
            p1 = pArr[index] + next;
        }

        // 不投资该项目
        int p2 = process(wArr, pArr, index + 1, rest,memory);

        memory[index][rest] = Math.max(p1, p2);
        return memory[index][rest];
    }

    public static void main(String[] args) {
        double[] wArr = {9.0,2.0,2.0,2.0,2.0,2.0};
        double[] pArr = {10.0,2.1,2.1,2.1,2.1,2.1};

        int[] wArr_int = new int[wArr.length];
        for (int i = 0; i < wArr.length; i++) {
            wArr_int[i] = (int) (wArr[i] * 10);
        }
        int[] pArr_int = new int[pArr.length];
        for (int i = 0; i < pArr.length; i++) {
            pArr_int[i] = (int) (pArr[i] * 10);
        }

        int rest = 10 * 10;

        // 记忆
        // -1代表没有记忆
        // 一开始没有记忆
        int[][] memory = new int[wArr.length + 1][rest + 1];
        for (int i = 0; i < memory.length; i++) {
            for (int j = 0; j < memory[i].length; j++) {
                memory[i][j] = -1;
            }
        }
        System.out.println(process(wArr_int,pArr_int,0,rest,memory)/10.0);
    }

}
