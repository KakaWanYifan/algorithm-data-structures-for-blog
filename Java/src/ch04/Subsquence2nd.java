package ch04;

import java.util.ArrayList;

public class Subsquence2nd {

    /**
     * @param str   固定参数
     * @param index 来到了str[index]字符，index是位置
     * @param ans
     * @param path  之前已经决定的不能改变，即使path
     * @return
     */
    public static void process(char[] str, int index, ArrayList<String> ans, String path) {
        if (index == str.length) {
            ans.add(path);
            return;
        }
        // 要了index位置的字符
        process(str, index + 1, ans, path + String.valueOf(str[index]));
        // 没有要index位置的字符
        process(str, index + 1, ans, path);
    }


    public static void main(String[] args) {
        char[] str = "abc".toCharArray();
        String path = "";
        ArrayList<String> ans = new ArrayList<>();
        process(str, 0, ans, path);
        System.out.println(ans);
    }
}