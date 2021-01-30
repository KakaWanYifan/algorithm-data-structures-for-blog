package ch07;

import java.util.HashMap;

public class HashSteps {

    public static HashMap<Integer, Integer> hashSteps = new HashMap<>();
    /**
     * 跳
     * @param n
     * @return 方法数
     */
    public static int jump(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        if (hashSteps.containsKey(n)){
            return hashSteps.get(n);
        }
        int res= jump(n-1) + jump(n-2);
        hashSteps.put(n,res);
        return res;
    }

    public static void main(String[] args) {
        int total = jump(6);
        System.out.println(total);
    }
}
