package ch03;

/**
 * 双向链表
 */
public class DoubleLink {

    /**
     * 双向节点
     */
    public static class DoubleNode{

        // 节点的值
        int data;
        // next 节点
        DoubleNode next;
        // prev 节点
        DoubleNode prev;

        /**
         * 构造方法
         * @param data 节点的值
         */
        DoubleNode(int data){
            this.data = data;
        }
    }

    // head 节点
    public DoubleNode head;
    // tail 节点
    public DoubleNode tail;

    /**
     * 在头部添加节点
     * @param data
     */
    public void addAtHead(int data){
        // 当前操作的节点
        DoubleNode curr = new DoubleNode(data);

        // 如果头节点是NULL，说明整个链表都是NULL
        if (null == head){
            head = curr;
            tail = curr;
        }else {
            // 当前节点的next指向头节点
            curr.next = head;
            // 头节点的prev指向当前节点
            head.prev = curr;
            // 把当前节点作为头节点
            head = curr;
        }
    }

    /**
     * 移除头部节点，并返回
     * @return
     */
    public DoubleNode removeAtHead(){
        // 如果头节点是NULL，说明整个链表都是NULL
        if (null == head){
            return null;
        }

        // 如果上面的都没有命中
        // 当前要操作的节点就是头节点
        DoubleNode curr = head;
        // 设置新的头节点
        head = head.next;
        // 当前节点就是以前的头节点，next指向空
        curr.next = null;
        // 新的头节点的指针，也指向空。
        head.prev = null;
        return curr;
    }


    /**
     * 在尾部添加节点
     * @param data
     */
    public void addAtTail(int data){
        // 当前操作的节点
        DoubleNode curr = new DoubleNode(data);

        // 如果尾节点是NULL，说明整个链表都是NULL
        if (null == tail){
            tail = curr;
            head = curr;
        }else{
            // 尾节点的next 指向当前节点
            tail.next = curr;
            // 当前节点的prev 指向尾节点
            curr.prev = tail;
            // 把当前节点作为尾节点
            tail = curr;
        }
    }

    /**
     * 移除尾部节点，并返回
     * @return
     */
    public DoubleNode removeAtTail(){
        // 如果尾节点是null，说明真个链表都是空的
        if (null == tail){
            return null;
        }
        // 当前操作的节点
        DoubleNode curr = tail;
        // 把尾节点的前一个节点，作为新的尾节点
        tail = tail.prev;
        // 新的尾节点的next指向null
        tail.next = null;
        // 当前节点的前一个节点指向null
        curr.prev = null;

        return curr;
    }

    /**
     * 输出链表
     */
    public void output(){
        String rnt = "";
        DoubleLink.DoubleNode temp = head;
        while (temp!=null) {
            rnt = rnt + temp.data + " ";
            temp = temp.next;
        }
        System.out.println(rnt);
    }

    public static void main(String[] args) {
        DoubleLink doubleLink = new DoubleLink();
        for (int i = 0; i < 10; i++) {
            doubleLink.addAtHead(9-i);
        }
        doubleLink.output();
        System.out.println(doubleLink.removeAtHead().data);
        System.out.println(doubleLink.removeAtTail().data);
        doubleLink.output();
        doubleLink.addAtTail(10);
        doubleLink.addAtTail(11);
        doubleLink.addAtTail(12);
        doubleLink.output();
    }
}
