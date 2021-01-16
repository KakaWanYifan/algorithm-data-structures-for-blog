# 链表的节点
class Node:
    def __init__(self, data):
        """

        :param data:
        """
        self.data = data
        self.next = None


def reverse(currNode):
    """
    反转
    :param currNode: 当前节点
    :return:
    """
    # 如果当前节点是None或者当前节点的下一个节点是None
    if currNode is None or currNode.next is None:
        # 返回当前节点，这个节点不用反转
        return currNode

    # 下一个节点
    nextNode = currNode.next
    # 反转之后的下一个一个
    newNextNode = reverse(nextNode)
    # 下一个节点
    nextNode.next = currNode
    # 当前节点的next指向None
    currNode.next = None

    return newNextNode


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

