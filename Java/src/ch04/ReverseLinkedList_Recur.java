package ch04;

public class ReverseLinkedList_Recur {

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
    public static Node reverse(Node currNode){
        if (currNode == null || currNode.next == null)
            return currNode;
        Node nextNode = currNode.next;
        Node newNextNode = reverse(nextNode);
        nextNode.next = currNode;
        currNode.next = null;
        return newNextNode;
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
