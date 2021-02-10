package ch10;

import java.util.HashSet;
import java.util.Stack;

// 深度优先遍历
public class DFS {

    /**
     * 深度优先
     * @param node 出发节点
     * @return
     */
    public static HashSet<Node> dfs(Node node){

        // 做一个是否为空的判断
        if (null == node){
            return null;
        }
        // 定义一个栈
        Stack<Node> stack = new Stack<>();
        // 用一个set来记录已经遍历过的节点
        HashSet<Node> set = new HashSet<>();
        // 进栈
        stack.add(node);
        // 记录
        set.add(node);
        // 打印
        System.out.println(node);
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
                    // 打印
                    System.out.println(iter);
                    // break，不再循环遍历，从iter出发
                    break;
                }
            }
        }
        return set;
    }

    public static void main(String[] args) {
        Integer[][] m = {{null,1,2},{null,2,1},
                         {null,2,3},{null,3,2},
                         {null,1,4},{null,4,1},
                         {null,2,5},{null,5,2},
                         {null,3,6},{null,6,3},
                         {null,4,5},{null,5,4},
                         {null,5,6},{null,6,5},
                         {null,5,7},{null,7,5},
                         {null,6,8},{null,8,6},
                         {null,7,8},{null,8,7}
                        };
        Graph g = Converter.FromMatrixToGraph(m);
        HashSet<Node> set = dfs(g.nodes.get(1));
        System.out.println(set);
    }
}

