package ch11;

public class HaNuoTa02 {

    public static void func(int N, String from, String to, String other) {
        if (N == 1) { // base
            System.out.println("Move 1 from " + from + " to " + to);
        } else {
            func(N - 1, from, other, to);
            System.out.println("Move " + N + " from " + from + " to " + to);
            func(N - 1, other, to, from);
        }
    }

    public static void main(String[] args) {
        func(3,"left","right","mid");
    }
}
