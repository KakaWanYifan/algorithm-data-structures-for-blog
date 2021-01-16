# 链表的节点
class Node:
    def __init__(self, data):
        """
        构造方法
        :param data:
        """
        self.data = data
        self.next = None


def reverse(currNode):
    """
    反转链表
    :param currNode: 当前节点
    :return: 
    """
    # 上一个节点
    prevNode = None
    # 下一个节点
    nextNode = None
    # 如果当前节点不等于空，说明还没反转完
    while currNode is not None:
        # 把当前节点的下一个节点，赋值给next
        nextNode = currNode.next

        # 当前节点的next指针，指向prevNode，反转
        currNode.next = prevNode

        # 为下一轮循环做准备
        # 把当前节点作为前一个节点
        # 把下一个节点作为当前节点
        prevNode = currNode
        currNode = nextNode

    # 如果当前节点是空的话，那么前一个节点就一定是反转之后链表的head
    return prevNode


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

    test = [1,2,3,4,5]
    test.sort()
