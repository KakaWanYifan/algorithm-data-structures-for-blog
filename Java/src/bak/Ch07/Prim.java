package bak.Ch07;

import java.util.*;

public class Prim {
    /**
     * 最小生成树的 Prim算法
     * @param graph 图
     * @return 最小生成树
     */
    public  static HashMap<Node, HashSet<Edge>> prim(Graph graph){
        HashMap<Node,HashSet<Edge>> rnt = new HashMap<>();
        // 遍历所有的节点，每个节点都可以作为起始节点
        for (Node node:graph.nodes.values()){
            // 已经连通的node
            HashSet<Node> nodeSet = new HashSet<>();
            // 已经选择的edge
            HashSet<Edge> edgeSet = new HashSet<>();

            // 第一个节点被选择
            nodeSet.add(node);
            // 可以选择的边，小根堆
            // 第一个节点的所有的边，都加入可选边啊
            PriorityQueue<Edge> edgeQueue = new PriorityQueue<>(node.edges);
            // 只要还右边可选，就进入循环
            while (!edgeQueue.isEmpty()){
                // 可选边中的最小边
                Edge edge = edgeQueue.poll();
                // toNode 该节点或许能加入
                Node toNode = edge.to;
                // 如果没有加入过
                if (!nodeSet.contains(toNode)){
                    // 添加进已连通的node
                    nodeSet.add(toNode);
                    // 添加进已选择的edge
                    edgeSet.add(edge);
                    // 把新的可选边，加入队列
                    edgeQueue.addAll(toNode.edges);
                }
            }
            rnt.put(node,edgeSet);
        }
        return rnt;
    }
}
