package bak.ch02;

/**
 * 两类节点
 */
public class Nodes {

    /**
     * 单向链表的节点
     */
    public class Node{
        // 节点的值
        public int value;
        // 下一个节点
        public Node next;

        /**
         * 构造方法
         * @param data 节点的值
         */
        public Node (int data){
            value = data;
        }
    }

    /**
     * 双向链表的节点
     */
    public class DulNode{
        // 节点的值
        public int value;
        // 前一个节点
        public DulNode prev;
        // 下一个节点
        public DulNode next;

        /**
         *
         * @param data
         */
        public DulNode (int data){
            value = data;
        }
    }

}
