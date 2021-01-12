package ch02;

import ch02.Nodes.Node;
import ch02.Nodes.DulNode;

/**
 *
 */
public class ReverseLinkedList {

    /**
     * 单向列表的反转
     * @param head 头节点
     * @return 反转之后链表的head
     */
    public static Node reverseLinkedList(Node head){
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
     * 双向链表的反正
     * @param head 头节点
     * @return 反转之后链表的head
     */
    public static DulNode reverseLinkedList(DulNode head){
        // 前一个节点
        DulNode prev = null;
        // 下一个节点
        DulNode next = null;
        // 当前节点
        DulNode curr = head;
        // 如果当前节点不等于空，说明还没反转完
        while (curr != null){
            // 把当前节点的下一个节点，赋值给next
            next = curr.next;

            // 当前节点的下一个节点赋值为prev
            // 当前节点的前一个节点赋值为next
            // 反转
            curr.next = prev;
            curr.prev = next;

            // 为下一轮循环做准备
            // 把当前节点作为前一个节点
            // 把下一个节点作为当前节点
            prev = curr;
            curr = next;
        }
        // 如果当前节点是空的话，那么前一个节点就一定是反转之后链表的head
        return prev;
    }

}
