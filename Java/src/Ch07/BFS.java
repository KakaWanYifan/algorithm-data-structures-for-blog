package Ch07;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// 广度优先
public class BFS {

    /**
     * 广度优先
     * @param node 出发节点
     */
    public static void bfs(Node node){
        // 做一个是否为空的判断
        if (null == node){
            return;
        }
        // 定义一个队列
        Queue<Node> queue = new LinkedList<>();
        // 用一个set来记录已经遍历过的节点
        HashSet<Node> set = new HashSet<>();
        // 节点进入队列
        queue.add(node);
        // 节点添加进set
        set.add(node);
        // 只要队列不为空
        while (!queue.isEmpty()){
            // 队列是先进先出
            Node cur = queue.poll();
            // 遍历nexts
            for (Node iter : cur.nexts){
                if (!set.contains(iter)){
                    // 如果不在set中，说明之前没有遍历过，添加进set
                    set.add(iter);
                    // 添加进队列，下次要从这个出发，进行遍历
                    queue.add(iter);
                }
            }
        }
        System.out.print(set);
    }
}
