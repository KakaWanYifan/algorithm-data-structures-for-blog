package ch02;

public class ReverseList {

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

    /**
     * 单向列表的反转
     * @param head 头节点
     * @return 反转之后链表的head
     */
    public static Node reverseLinkedList(Node curr){
        // 前一个节点
        Node prev = null;
        // 下一个节点
        Node next = null;
        // 如果当前节点不等于空，说明还没反转完
        while (curr != null){
            // 把当前节点的下一个节点，赋值给next
            next = curr.next;

            // 当前节点的下一个节点赋值为prev，反转
            curr.next = prev;

            // 把当前节点作为前一个节点
            // 把下一个节点作为当前节点
            // 进入下一轮的循环
            prev = curr;
            curr = next;
        }
        // 如果当前节点是空的话，那么前一个节点就一定是反转之后链表的head
        return prev;
    }

    /**
     * 双向链表的反正
     * @param head 头节点
     * @return 反转之后链表的head
     */
    public static DulNode reverseLinkedList(DulNode curr){
        // 前一个节点
        DulNode prev = null;
        // 下一个节点
        DulNode next = null;
        // 如果当前节点不等于空，说明还没反转完
        while (curr != null){
            // 把当前节点的下一个节点，赋值给next
            next = curr.next;

            // 当前节点的下一个节点赋值为prev
            // 当前节点的前一个节点赋值为next
            // 反转
            curr.next = prev;
            curr.prev = next;

            // 把当前节点作为前一个节点
            // 把下一个节点作为当前节点
            // 进入下一轮的循环
            prev = curr;
            curr = next;
        }
        // 如果当前节点是空的话，那么前一个节点就一定是反转之后链表的head
        return prev;
    }
}
