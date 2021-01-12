package Ch07;

import java.util.HashSet;
import java.util.Stack;

// 深度优先遍历
public class DFS {

    /**
     * 深度优先
     * @param node 出发节点
     */
    public static void dfs(Node node){

        // 做一个是否为空的判断
        if (null == node){
            return;
        }
        // 定义一个栈
        Stack<Node> stack = new Stack<>();
        // 用一个set来记录已经遍历过的节点
        HashSet<Node> set = new HashSet<>();
        // 进栈
        stack.add(node);
        // 记录
        set.add(node);
        while (!stack.empty()){
            // 栈，后进先出
            Node cur = stack.pop();
            // 遍历 next
            for (Node iter: cur.nexts){
                // 这个节点没有被遍历过
                if (!set.contains(iter)) {
                    // 把cur压回栈
                    stack.add(cur);
                    // 把当前节点压回栈
                    stack.add(iter);
                    // 记录
                    set.add(iter);
                    // break，不再循环遍历，从iter出发
                    break;
                }
            }
        }
        System.out.print(set);
    }
}
