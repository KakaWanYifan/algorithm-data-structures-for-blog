package ch10;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim {

    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> prim(Graph graph) {
        // 选择的边
        Set<Edge> rnt = new HashSet<>();
        // 解锁的边进入小根堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        // 被解锁的点
        HashSet<Node> nodeSet = new HashSet<>();
        // 被解锁过的边
        Set<Edge> edgeSet = new HashSet<>();
        // 遍历所有的点
        for (Node node : graph.nodes.values()) {
            // node 是开始点
            if (!nodeSet.contains(node)) {
                nodeSet.add(node);
                // 由一个点，解锁所有相连的边
                for (Edge edge : node.edges) {
                    if (!edgeSet.contains(edge)) {
                        edgeSet.add(edge);
                        priorityQueue.add(edge);
                    }
                }
                while (!priorityQueue.isEmpty()) {
                    // 弹出解锁的边中，最小的边
                    Edge edge = priorityQueue.poll();
                    // 可能的一个新的点
                    Node toNode = edge.to;
                    // 不含有的时候，就是新的点
                    if (!nodeSet.contains(toNode)) {
                        nodeSet.add(toNode);
                        rnt.add(edge);
                        for (Edge nextEdge : toNode.edges) {
                            if (!edgeSet.contains(nextEdge)) {
                                edgeSet.add(nextEdge);
                                priorityQueue.add(nextEdge);
                            }
                        }
                    }
                }
            }
        }
        return rnt;
    }

    public static void main(String[] args) {
        // 1 恒山
        // 2 华山
        // 3 嵩山
        // 4 泰山
        // 5 衡山
        Integer[][] m = {
                {50, 1, 2}, {50, 2, 1},
                {20, 1, 3}, {20, 3, 1},
                {10, 1, 4}, {10, 4, 1},
                {2, 2, 3}, {2, 3, 2},
                {5, 3, 4}, {5, 4, 3},
                {100, 2, 5}, {100, 5, 2},
                {20, 4, 5}, {20, 5, 4}};
        Graph g = Converter.FromMatrixToGraph(m);
        System.out.println(Prim.prim(g));
    }

}
