package ch10;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    /**
     * 广度优先
     * @param node 出发节点
     * @return
     */
    public static HashSet<Node> bfs(Node node){
        // 做一个是否为空的判断
        if (null == node){
            return null;
        }
        // 定义一个队列
        Queue<Node> queue = new LinkedList<>();
        // 用一个set来记录已经遍历过的节点
        HashSet<Node> set = new HashSet<>();
        // 节点进入队列
        queue.add(node);
        // 节点添加进set
        set.add(node);
        // 打印
        System.out.println(node);
        // 只要队列不为空
        while (!queue.isEmpty()){
            // 队列是先进先出
            Node cur = queue.poll();
            // 遍历nexts
            for (Node iter : cur.nexts){
                if (!set.contains(iter)){
                    // 添加进队列，下次要从这个出发，进行遍历
                    queue.add(iter);
                    // 如果不在set中，说明之前没有遍历过，添加进set
                    set.add(iter);
                    // 打印
                    System.out.println(iter);
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
        HashSet<Node> set = bfs(g.nodes.get(1));
        System.out.println(set);
    }

}
