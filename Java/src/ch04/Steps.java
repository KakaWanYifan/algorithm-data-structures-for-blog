package ch04;

public class Steps {

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
        return (jump(n-1) + jump(n-2));
    }

    public static void main(String[] args) {
        int total = jump(6);
        System.out.println(total);
    }
}
