package ch10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopologySort {

    /**
     * 拓扑排序
     * @param graph 进行排序的图
     * @return 排序后的节点
     */
    public static ArrayList<Node> topologySort(Graph graph){
        ArrayList<Node> rnt = new ArrayList<>();
        // 用一个Map，来记录所有的剩余入度
        HashMap<Node,Integer> inMap = new HashMap<>();
        // 入度为0的点，进入队列
        Queue<Node> zeroInQueue = new LinkedList<>();

        // 遍历节点
        for (Node iter: graph.nodes.values()) {
            // 记录初始阶段的所有节点及其入度
            inMap.put(iter,iter.in);
            // 如果该节点的入度是0
            if (iter.in == 0){
                // 加入队列
                zeroInQueue.add(iter);
            }
        }

        // 如果队列不为空
        while (!zeroInQueue.isEmpty()){
            // 队列，先进先出
            Node cur = zeroInQueue.poll();
            // 记录
            rnt.add(cur);
            // 遍历队列的nexts
            for (Node iter: cur.nexts) {
                // 入度减一
                inMap.put(iter,inMap.get(iter) - 1);
                // 如果入度等于0
                if (inMap.get(iter) == 0){
                    // 加入zeroInQueue队列
                    zeroInQueue.add(iter);
                }
            }
        }
        return rnt;
    }

    public static void main(String[] args) {
        Integer[][] m = {{null,1,2},
                {null,2,3},
                {null,3,4},
                {null,4,5},
                {null,2,6},
                {null,3,6},
                {null,4,6},
                {null,5,6}
        };
        Graph g = Converter.FromMatrixToGraph(m);
        ArrayList<Node> list = topologySort(g);
        System.out.println(list);
    }
}
