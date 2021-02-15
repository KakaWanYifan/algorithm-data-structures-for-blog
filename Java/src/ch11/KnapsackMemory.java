package ch11;

import java.util.HashMap;

public class KnapsackMemory {

    /**
     *
     * @param wArr 投资数额
     * @param pArr 投资收益
     * @param index
     * @param rest 剩余可用资金
     * @return -1 该投资不可行
     */
    public static double process(double[] wArr , double[] pArr, int index, double rest,HashMap<String,Double> memory) {
        String key = index + "-" + rest;
        if (memory.containsKey(key)){
            return memory.get(key);
        }
        // 该投资不可行
        if (rest < 0) {
            return -1;
        }
        // 没有更多投资项目
        if (index == wArr.length) {
            memory.put(key, 0.0);
            return memory.get(key);
        }
        // 投资该项目
        double p1 = 0;
        double next = process(wArr, pArr, index + 1, rest - wArr[index],memory);
        if (next != -1) {
            p1 = pArr[index] + next;
        }

        // 不投资该项目
        double p2 = process(wArr, pArr, index + 1, rest,memory);

        memory.put(key,Math.max(p1, p2));
        return memory.get(key);
    }

    public static void main(String[] args) {
        double[] wArr = {9.0,2.0,2.0,2.0,2.0,2.0};
        double[] pArr = {10.0,2.1,2.1,2.1,2.1,2.1};
        // 记忆
        HashMap<String,Double> memory = new HashMap<>();
        System.out.println(process(wArr,pArr,0,10,memory));
    }

}
