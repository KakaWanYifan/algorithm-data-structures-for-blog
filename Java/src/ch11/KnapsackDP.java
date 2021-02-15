package ch11;

public class KnapsackDP {

    public static void main(String[] args) {
        double[] wArr = {9.0, 2.0, 2.0, 2.0, 2.0, 2.0};
        double[] pArr = {10.0, 2.1, 2.1, 2.1, 2.1, 2.1};

        int[] wArr_int = new int[wArr.length];
        for (int i = 0; i < wArr.length; i++) {
            wArr_int[i] = (int) (wArr[i] * 10);
        }
        int[] pArr_int = new int[pArr.length];
        for (int i = 0; i < pArr.length; i++) {
            pArr_int[i] = (int) (pArr[i] * 10);
        }

        int rest = 10 * 10;

        int[][] dp = new int[wArr_int.length + 1][rest + 1];
        for (int index = wArr_int.length - 1; index >= 0; index--) {
            for (int r = 0; r <= rest; r++) {
                int p1 = dp[index + 1][r];
                int p2 = 0;
                int next = r - wArr_int[index] < 0 ? -1 : dp[index + 1][r - wArr_int[index]];
                if (next != -1) {
                    p2 = pArr_int[index] + next;
                }
                dp[index][r] = Math.max(p1, p2);
            }
        }


        System.out.println(dp[0][rest] / 10.0);
    }
}
