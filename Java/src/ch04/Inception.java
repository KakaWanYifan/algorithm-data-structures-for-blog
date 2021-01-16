package ch04;

public class Inception {

    public static class Cobb{
        // top:陀螺
        // 陀螺是否会停止
        boolean topStop;

        // 上一层梦的Cobb
        Cobb prev;

        /**
         * 构造方法
         * @param topStop 陀螺是否会停止
         */
        public Cobb(boolean topStop) {
            this.topStop = topStop;
        }

    }

    /**
     * 回到上一层
     * @param cobb 男主角
     * @return 几层梦
     */
    public static int GoBack(Cobb cobb){
        if (cobb.topStop == false){
            // 回到上一层
            cobb = cobb.prev;
            // 递归
            return GoBack(cobb) + 1;
        }else{
            // 如果陀螺停了，说明在第0层
            return 0;
        }
    }

    public static void main(String[] args) {
        // 定义Cobb的梦
        // 假的Cobb，他的陀螺不会停
        Cobb fakeCobb = new Cobb(false);
        fakeCobb.prev = new Cobb(false);
        fakeCobb.prev.prev = new Cobb(false);
        fakeCobb.prev.prev.prev = new Cobb(false);
        fakeCobb.prev.prev.prev.prev = new Cobb(false);
        fakeCobb.prev.prev.prev.prev.prev = new Cobb(false);
        fakeCobb.prev.prev.prev.prev.prev.prev = new Cobb(false);

        // 真实的Cobb，他的陀螺会停
        Cobb realCobb = new Cobb(true);
        fakeCobb.prev.prev.prev.prev.prev.prev.prev = realCobb;

        // 递归，求Cobb梦的大小
        // fackCobb开始GoBack
        int DreamSize = GoBack(fakeCobb);
        System.out.println(DreamSize);

    }
}
