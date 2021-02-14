package ch11;

import java.util.ArrayList;

public class AllPermutation {
    /**
     * @param str   固定参数
     * @param index 来到了str[index]字符，index是位置
     * @param ans
     * @param path  之前已经决定的不能改变，即使path
     * @return
     */
    public static void process(ArrayList<Character> str, ArrayList<String> ans, String path) {
        if (str.isEmpty()) {
            ans.add(path);
            return;
        }
        for (int i = 0; i < str.size(); i++) {
            ArrayList<Character> temp = (ArrayList<Character>) str.clone();
            temp.remove(i);
            process(temp, ans, path + String.valueOf(str.get(i)));
        }
    }


    public static void main(String[] args) {
        ArrayList<Character> l = new ArrayList<>();
        l.add('甲');
        l.add('乙');
        l.add('丙');
        ArrayList<String> ans = new ArrayList<>();
        String path = "";
        process(l, ans, path);
        System.out.println(ans);
    }
}
