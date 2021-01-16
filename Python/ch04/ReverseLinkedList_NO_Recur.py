# 链表的节点
class Node:
    def __init__(self, data):
        """

        :param data:
        """
        self.data = data
        self.next = None


def reverse(head):
    """
    反转链表
    :param head:
    :return: 
    """
    # 上一个节点
    prev = None;
    # 下一个节点
    next = None;
    # 当前节点
    curr = head;
    # 如果当前节点不等于空，说明还没反转完
    while curr is not None:
        # 把当前节点的下一个节点，赋值给next
        next = curr.next;

        # 当前节点的下一个节点赋值为prev，反转
        curr.next = prev;

        # 为下一轮循环做准备
        # 把当前节点作为前一个节点
        # 把下一个节点作为当前节点
        prev = curr
        curr = next

    # 如果当前节点是空的话，那么前一个节点就一定是反转之后链表的head
    return prev


def output(headNode):
    """
    输出节点
    :param headNode: 头节点
    :return:
    """
    rnt = []
    while headNode is not None:
        rnt.append(headNode.data)
        headNode = headNode.next
    print(rnt)


if __name__ == '__main__':
    head = Node(0)
    head.next = Node(1)
    head.next.next = Node(2)
    head.next.next.next = Node(3)
    head.next.next.next.next = Node(4)
    head.next.next.next.next.next = Node(5)
    head.next.next.next.next.next.next = Node(6)
    head.next.next.next.next.next.next.next = Node(7)
    head.next.next.next.next.next.next.next.next = Node(8)
    head.next.next.next.next.next.next.next.next.next = Node(9)

    output(head)

    reHead = reverse(head)

    output(reHead)

