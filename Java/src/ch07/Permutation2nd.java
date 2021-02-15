package ch07;

import java.util.ArrayList;
import java.util.HashMap;

public class Permutation2nd {
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
        // 假设就甲乙丙三人
        HashMap<Character,Boolean> visit = new HashMap<>();
        visit.put('甲',false);
        visit.put('乙',false);
        visit.put('丙',false);
        for (int i = 0; i < str.size(); i++) {
            // 如果没有出现过
            if (visit.get(str.get(i)) == false){
                visit.put(str.get(i),true);
                ArrayList<Character> temp = (ArrayList<Character>) str.clone();
                temp.remove(i);
                process(temp, ans, path + String.valueOf(str.get(i)));
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<Character> l = new ArrayList<>();
        l.add('甲');
        l.add('甲');
        l.add('乙');
        ArrayList<String> ans = new ArrayList<>();
        String path = "";
        process(l, ans, path);
        System.out.println(ans);
    }
}
