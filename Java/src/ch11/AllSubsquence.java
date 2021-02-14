package ch11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AllSubsquence {

    public static ArrayList<String> process(Queue<Character> queue){
        ArrayList<String> rnt = new ArrayList<>();
        if (queue.isEmpty()){
            rnt.add("");
            return rnt;
        }
        Character t = queue.poll();
        String s_yes = t.toString();
        String s_no = "";
        for (String str : process(queue)){
            rnt.add(s_yes + str);
            rnt.add(s_no + str);
        }
        return rnt;
    }


    public static void main(String[] args) {
        char[] str = "abc".toCharArray();
        Queue<Character> queue = new LinkedList<>();
        for (Character c : str){
            queue.offer(c);
        }
        ArrayList<String> ans = process(queue);
        System.out.println(ans);
    }
}
