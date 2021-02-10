package ch10;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFindExample {

    // 节点
    public static class Node<V> {
        V value;
        public Node(V v) {
            value = v;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    // 并查集
    public static class UnionFind<V> {
        // 并查集中的所有节点
        public HashMap<V, Node<V>> nodes;
        // 节点和节点之间的UP关系
        public HashMap<Node<V>, Node<V>> ups;
        // 家族的大小
        public HashMap<Node<V>, Integer> sizeMap;

        /**
         * 构造方法
         * @param values
         */
        public UnionFind(List<V> values) {
            nodes = new HashMap<>();
            ups = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V cur : values) {
                Node<V> node = new Node<>(cur);
                nodes.put(cur, node);
                // 一开始自己就是一个家族，那么自己就是自己的UP
                ups.put(node, node);
                // 大小就是1
                sizeMap.put(node, 1);
            }
        }

        // 找家族的大代表
        public Node<V> findTop(Node<V> cur) {
            Stack<Node<V>> path = new Stack<>();
            // 只要自己不是自己的代表，就一直网上找
            while (cur != ups.get(cur)) {
                path.push(cur);
                cur = ups.get(cur);
            }
            while (!path.isEmpty()) {
                ups.put(path.pop(), cur);
            }
            return cur;
        }

        /**
         * 是否是同一个集合 查
         * @param a
         * @param b
         * @return
         */
        public boolean isSameSet(V a, V b) {
            // 看看TOP代表是不是同一位
            return findTop(nodes.get(a)) == findTop(nodes.get(b));
        }

        /**
         * 两个集合合并 并
         * @param a
         * @param b
         */
        public void union(V a, V b) {
            // a节点的家族的代表
            Node<V> aHead = findTop(nodes.get(a));
            // b节点的家族的代表
            Node<V> bHead = findTop(nodes.get(b));
            // 如果代表不是同一位，合并
            if (aHead != bHead) {
                // a家族的大小
                int aSetSize = sizeMap.get(aHead);
                // b家族的大小
                int bSetSize = sizeMap.get(bHead);
                // 如果a家族大于等于b家族
                if (aSetSize >= bSetSize){
                    // 直接把b家族的代表的代表设置为a家族的代表
                    ups.put(bHead,aHead);
                    // 家族的大小
                    sizeMap.put(aHead,aSetSize + bSetSize);
                    // 一个家族，一个代表，一个大小
                    sizeMap.remove(bHead);
                }else{
                    // 把if反过来就是else
                    ups.put(aHead,bHead);
                    sizeMap.put(bHead,aSetSize + bSetSize);
                    sizeMap.remove(aHead);
                }
            }
        }

    }


    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        UnionFind<Integer> unionFind = new UnionFind<Integer>(l);
        System.out.println(unionFind.nodes);
        System.out.println(unionFind.ups);
        System.out.println(unionFind.sizeMap);
        System.out.println(unionFind.isSameSet(1,2));
        unionFind.union(1,2);
        System.out.println(unionFind.isSameSet(1,2));
        System.out.println(unionFind.nodes);
        System.out.println(unionFind.ups);
        System.out.println(unionFind.sizeMap);
    }
}
