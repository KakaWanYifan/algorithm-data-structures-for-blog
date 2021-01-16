package ch02;

/**
 * 我的LinkedList
 */
public class MyLinkedList {

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

    //链表的头节点指针
    private Node head;
    //链表的尾节点指针
    private Node last;
    //链表实际长度
    private int size;

    /**
     * 构造方法
     */
    public MyLinkedList() {
        // 一个空的List
    }

    /**
     * get方法
     * @param index
     * @return index位置的节点
     * @throws Exception
     */
    public Node get(int index) throws Exception {
        if (index<0 || index>=size) {
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node temp = head;
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }


    /**
     * add方法
     * @param index
     * @param element
     * @throws Exception
     */
    public void add(int index, int element) throws Exception {

        if (index<0 || index>size) {
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }

        Node insertedNode = new Node(element);
        if(size == 0){
            //空链表
            head = insertedNode;
            last = insertedNode;
        } else if(index == 0){
            //插入头部
            insertedNode.next = head;
            head = insertedNode;
        }else if(size == index){
            //插入尾部
            last.next = insertedNode;
            last = insertedNode;
        }else {
            //插入中间
            Node prevNode = get(index-1);
            insertedNode.next = prevNode.next;
            prevNode.next = insertedNode;
        }
        size++;
    }

    /**
     * 在尾部添加节点
     * @param element
     * @throws Exception
     */
    public void add(int element) throws Exception{
        Node insertedNode = new Node(element);

        //插入尾部
        last.next = insertedNode;
        last = insertedNode;

        size++;
    }


    /**
     * remove
     * @param index
     * @return 被删除的节点
     * @throws Exception
     */
    public Node remove(int index) throws Exception {
        if (index<0 || index>=size) {
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node removedNode = null;
        if(index == 0){
            //删除头节点
            removedNode = head;
            head = head.next;
            if(size == 1){
                last = null;
            }
        }else if(index == size-1){
            //删除尾节点
            Node prevNode = get(index-1);
            removedNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        }else {
            //删除中间节点
            Node prevNode = get(index-1);
            Node nextNode = prevNode.next.next;
            removedNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size--;
        return removedNode;
    }

    /**
     * remove第一个节点
     * @return
     * @throws Exception
     */
    public Node remove() throws Exception{
        if (size < 1) {
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node removedNode = head;
        head = head.next;
        if(size == 1){
            last = null;
        }
        size--;
        return removedNode;
    }

    /**
     * 输出链表
     */
    public void output(){
        String rnt = "";
        Node temp = head;
        while (temp!=null) {
            rnt = rnt + temp.data + " ";
            temp = temp.next;
        }
        System.out.println(rnt);
    }

    public static void main(String[] args) throws Exception {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(0,1);
        myLinkedList.add(1,2);
        myLinkedList.add(2,3);
        myLinkedList.output();
        myLinkedList.remove();
        myLinkedList.remove();
        myLinkedList.output();
        myLinkedList.add(4);
        myLinkedList.add(5);
        myLinkedList.add(6);
        myLinkedList.output();
        myLinkedList.remove(1);
        myLinkedList.remove(1);
        myLinkedList.output();
        System.out.println(myLinkedList.get(1).data);
    }
}