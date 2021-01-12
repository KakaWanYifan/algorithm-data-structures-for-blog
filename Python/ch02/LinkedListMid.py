# 链表的节点
class Node:
    def __init__(self, data):
        """

        :param data:
        """
        self.data = data
        self.next = None


def getLinkedListMid(head):
    """
    获取中间节点
    :param head: 链表的head
    :return: 中间节点
    """
    rnt = []

    if None == head:
        return None

    # 如果前面的没有命中，说明链表不为空

    # 先让快指针开始跑
    fastNode = head
    fastTimes = 0
    # 只要fastNode的next的next不是空，就说明还可以进行遍历。
    # 为了避免fateNode.next就是空，导致空指针异常，先判断fastNode的next
    while (fastNode is not None) and (fastNode.next is not None) and (fastNode.next.next is not None):
        # 遍历
        fastNode = fastNode.next.next
        # 次数加一
        fastTimes = fastTimes + 1

    # 然后慢指针
    midNode = head
    for i in range(fastTimes):
        midNode = midNode.next

    rnt.append(midNode)

    # 奇数偶数特殊处理
    # 如果fastNode的next不为空，说明是偶数个节点，那么中间节点就有两个。
    # 否则，奇数个节点，中间节点只有一个。
    if fastNode.next is not None:
        rnt.append(midNode.next)

    return rnt


if __name__ == '__main__':
    test = None
    print('当链表为空，中间节点是   ', getLinkedListMid(test))

    test = Node(1)
    midNodeList = getLinkedListMid(test)
    print('当链表长度为1，中间节点个数是   ', len(midNodeList), '   中间节点是   ', midNodeList[0].data)

    test = Node(1)
    test.next = Node(2)
    midNodeList = getLinkedListMid(test)
    print('当链表长度为2，中间节点个数是   ', len(midNodeList), '   中间节点是   ', midNodeList[0].data, ',', midNodeList[1].data)

    test = Node(1)
    test.next = Node(2)
    test.next.next = Node(3)
    test.next.next.next = Node(4)
    test.next.next.next.next = Node(5)
    test.next.next.next.next.next = Node(6)
    midNodeList = getLinkedListMid(test)
    print('当链表长度为6，中间节点个数是   ', len(midNodeList), '   中间节点是   ', midNodeList[0].data, ',', midNodeList[1].data)

    test = Node(1)
    test.next = Node(2)
    test.next.next = Node(3)
    test.next.next.next = Node(4)
    test.next.next.next.next = Node(5)
    test.next.next.next.next.next = Node(6)
    test.next.next.next.next.next.next = Node(7)
    midNodeList = getLinkedListMid(test)
    print('当链表长度为7，中间节点个数是   ', len(midNodeList), '   中间节点是   ', midNodeList[0].data)
