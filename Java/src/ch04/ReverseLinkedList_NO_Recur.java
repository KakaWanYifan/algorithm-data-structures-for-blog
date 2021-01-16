package ch04;

public class ReverseLinkedList_NO_Recur {
    /**
     * 链表节点
     */
    private static class Node {
        // 节点的值
        int data;
        // next
        Node next;

        /**
         * 构造方法
         * @param data
         */
        Node(int data) {
            this.data = data;
        }
    }

    /**
     * 反转链表
     * @param head head节点
     * @return
     */
    public static Node reverse(Node head){
        // 前一个节点
        Node prev = null;
        // 下一个节点
        Node next = null;
        // 当前节点
        Node curr = head;
        // 如果当前节点不等于空，说明还没反转完
        while (curr != null){
            // 把当前节点的下一个节点，赋值给next
            next = curr.next;

            // 当前节点的下一个节点赋值为prev，反转
            curr.next = prev;

            // 为下一轮循环做准备
            // 把当前节点作为前一个节点
            // 把下一个节点作为当前节点
            prev = curr;
            curr = next;
        }
        // 如果当前节点是空的话，那么前一个节点就一定是反转之后链表的head
        return prev;

    }

    /**
     * 输出链表
     * @param head
     */
    public static void print(Node headNode){
        String rnt = "";
        while (headNode!=null) {
            rnt = rnt + headNode.data + " ";
            headNode = headNode.next;
        }
        System.out.println(rnt);
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next.next = new Node(9);

        print(head);

        Node reHead = reverse(head);

        print(reHead);
    }
}
