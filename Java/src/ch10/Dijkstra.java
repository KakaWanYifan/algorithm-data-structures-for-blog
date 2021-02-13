package ch10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class Dijkstra {

    /**
     * Dijkstra 算法
     *
     * @param from from节点
     * @return from节点到其他节点的距离，表格
     */
    public static HashMap<Node, Integer> dijkstra(Node from) {
        // 最后要返回的表，记录从from节点到其他节点的最小距离
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        // 从from节点到from节点的距离为0
        distanceMap.put(from, 0);
        // 已经求过距离的节点，放在recordNodes中，登记
        HashSet<Node> recordNodes = new HashSet<>();

        // 找到在未登记的节点中，距离最小的节点
        Node minNode = getMinDistanceInUnrecordedNode(distanceMap, recordNodes);
        // 如果minNode不是空的，说明找到了距离最小点
        while (minNode != null) {
            // 获取距离
            Integer distance = distanceMap.get(minNode);
            // 遍历距离最小点的边
            for (Edge edge : minNode.edges) {
                // 边的to节点
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    // 如果to节点不在distanceMap中
                    distanceMap.put(toNode, distance + edge.weight);
                } else {
                    // 否则记录
                    distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            // 登记
            recordNodes.add(minNode);
            // 循环
            minNode = getMinDistanceInUnrecordedNode(distanceMap, recordNodes);
        }
        return distanceMap;
    }

    /**
     * 在未登记的节点中，找距离最小的节点
     *
     * @param distanceMap 距离表
     * @param recordNodes 登记节点
     * @return
     */
    public static Node getMinDistanceInUnrecordedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> recordNodes) {
        // 距离最小的节点
        Node minNode = null;
        // 最小距离，一开始初始化未最大值
        Integer minDistance = Integer.MAX_VALUE;
        // 遍历距离表
        for (Entry<Node, Integer> iter : distanceMap.entrySet()) {
            // iter 节点
            Node node = iter.getKey();
            // iter 距离
            Integer distance = iter.getValue();
            // 如果这个节点没有登记，并且距离比minDistance还要小
            if (!recordNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }

    public static void main(String[] args) {
        // 1 恒山
        // 2 华山
        // 3 嵩山
        // 4 泰山
        // 5 衡山
        Integer[][] m = {
                {3, 1, 2}, {3, 2, 1},
                {1, 1, 3}, {1, 3, 1},
                {2, 1, 4}, {2, 4, 1},
                {1, 2, 3}, {1, 3, 2},
                {5, 3, 4}, {5, 4, 3},
                {9, 2, 5}, {9, 5, 2},
                {2, 3, 5}, {2, 5, 3},
                {6, 4, 5}, {6, 5, 4}};
        Graph g = Converter.FromMatrixToGraph(m);
        // 从华山派出发
        System.out.println(dijkstra(g.nodes.get(2)));
    }
}
