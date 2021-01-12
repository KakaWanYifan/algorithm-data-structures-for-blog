package bak.ch02;

import bak.ch02.Nodes.Node;

/**
 * 删除给定的值
 */
public class DeleteGivenValue {

    /**
     * 删除给定的值
     * @param head 头节点
     * @param givenValue 给定的值
     * @return 删除之后的链表的头
     */
    public static Node deleteGivenValue(Node head,int givenValue){

        // 先处理头节点就需要删除的情况
        while (head != null){
            // 如果头节点就是给定的值需要删除
            if (head.value == givenValue){
                // 把head的next赋值给head，用这种方法删除
                head = head.next;
            // 否则的话，说明head不用删除
            }else{
                break;
            }
        }

        // 前一个节点
        Node prev = null;
        // 下一个节点
        Node next = null;
        // 当前节点
        Node curr = head;

        while (curr != null){

            // 更新next
            next = curr.next;

            // 如果curr就是要删除的
            if (curr.value == givenValue){
                // 前一个节点的next赋值成next
                // 如果是head节点，其prev是NULL，但是因为有前面的处理，所以head节点肯定不会进入
                prev.next = next;
                curr = curr.next;
            }else {
                prev = curr;
            }
            // 为下一轮做准备
            curr = curr.next;
        }

        return head;
    }

}
