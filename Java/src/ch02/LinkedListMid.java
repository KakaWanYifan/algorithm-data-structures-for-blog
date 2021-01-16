package ch02;

/**
 * 快慢指针，中间节点
 */
public class LinkedListMid {

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
     * 获取中间节点
     * @param head head节点
     * @return 中间节点列表，可能存在多个中间节点，所以是list。
     */
    public static String getLinkedListMid(Node head){

        String rnt = "";

        // head == null   没有节点，自然没有中间节点，返回null
        if (head == null){
            return null;
        }

        // 如果前面的没命中，链表不为空

        // 先让快指针开始跑
        Node fastNode = head;
        int fastTimes = 0;
        // 只要fastNode的next的next不是空，就说明还可以进行遍历。
        // 为了避免fateNode.next就是空，导致空指针异常，先判断fastNode的next
        while (null != fastNode  && null != fastNode.next && null != fastNode.next.next){
            // 遍历
            fastNode = fastNode.next.next;
            // 次数加一
            fastTimes = fastTimes + 1;
        }


        // 然后慢指针
        Node midNode = head;
        for (int i = 0; i < fastTimes; i++) {
            midNode = midNode.next;
        };
        rnt = rnt + midNode.data;

        // 奇数偶数特殊处理
        // 如果fastNode的next不为空，说明是偶数个节点，那么中间节点就有两个。
        // 否则，奇数个节点，中间节点只有一个。
        if (fastNode.next != null){
            rnt = rnt + " " + midNode.next.data;
        }

        return rnt;
    }

    public static void main(String[] args) {
        String midNode = "";

        Node test = null;
        System.out.print("当链表为空，中间节点是   ");
        System.out.print(getLinkedListMid(test));
        System.out.print("\n");

        test = new Node(1);
        midNode = getLinkedListMid(test);
        System.out.print("当链表长度为1，中间节点是   ");
        System.out.print(midNode);
        System.out.print("\n");

        test = new Node(1);
        test.next = new Node(2);
        midNode = getLinkedListMid(test);
        System.out.print("当链表长度为2，中间节点是   ");
        System.out.print(midNode);
        System.out.print("\n");

        test = new Node(1);
        test.next = new Node(2);
        test.next.next = new Node(3);
        test.next.next.next = new Node(4);
        test.next.next.next.next = new Node(5);
        test.next.next.next.next.next = new Node(6);
        midNode = getLinkedListMid(test);
        System.out.print("当链表长度为6，中间节点是   ");
        System.out.print(midNode);
        System.out.print("\n");


        test = new Node(1);
        test.next = new Node(2);
        test.next.next = new Node(3);
        test.next.next.next = new Node(4);
        test.next.next.next.next = new Node(5);
        test.next.next.next.next.next = new Node(6);
        test.next.next.next.next.next.next = new Node(7);
        midNode = getLinkedListMid(test);
        System.out.print("当链表长度为7，中间节点是   ");
        System.out.print(midNode);
        System.out.print("\n");

    }

}
