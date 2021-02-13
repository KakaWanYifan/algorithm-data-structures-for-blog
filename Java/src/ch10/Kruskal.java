package ch10;

import java.util.*;

public class Kruskal {

    public static class UnionFind {
        // key 某一个节点， value key节点往上的节点
        private HashMap<Node, Node> upsMap;
        // key 某一个集合的代表节点, value key所在集合的节点个数
        private HashMap<Node, Integer> sizeMap;

        public UnionFind(Collection<Node> nodes) {
            upsMap = new HashMap<Node, Node>();
            sizeMap = new HashMap<Node, Integer>();
            for (Node node : nodes) {
                upsMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        private Node findTop(Node n) {
            Stack<Node> path = new Stack<>();
            while (n != upsMap.get(n)) {
                path.add(n);
                n = upsMap.get(n);
            }
            while (!path.isEmpty()) {
                upsMap.put(path.pop(), n);
            }
            return n;
        }

        public boolean isSameSet(Node a, Node b) {
            return findTop(a) == findTop(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aDai = findTop(a);
            Node bDai = findTop(b);
            if (aDai != bDai) {
                int aSetSize = sizeMap.get(aDai);
                int bSetSize = sizeMap.get(bDai);
                if (aSetSize <= bSetSize) {
                    upsMap.put(aDai, bDai);
                    sizeMap.put(bDai, aSetSize + bSetSize);
                    sizeMap.remove(aDai);
                } else {
                    upsMap.put(bDai, aDai);
                    sizeMap.put(aDai, aSetSize + bSetSize);
                    sizeMap.remove(bDai);
                }
            }
        }
    }

    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> kruskal(Graph graph) {
        UnionFind unionFind = new UnionFind(graph.nodes.values());
        // 从小的边到大的边，依次弹出，小根堆！
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge : graph.edges) { // M 条边
            priorityQueue.add(edge);  // O(logM)
        }
        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!unionFind.isSameSet(edge.from, edge.to)) {
                result.add(edge);
                unionFind.union(edge.from, edge.to);
            }
        }
        return result;
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
        System.out.println(Kruskal.kruskal(g));
    }

}
