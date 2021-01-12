# 我的链表容器

# 链表的节点
class Node:
    def __init__(self, data):
        """

        :param data:
        """
        self.data = data
        self.next = None


class MyLinkedList:
    def __init__(self):
        self.size = 0
        self.head = None
        self.last = None

    def get(self, index):
        """
        获取指定位置的节点
        :param index:
        :return:
        """
        if index < 0 or index >= self.size:
            raise Exception("超出链表节点范围！")
        p = self.head
        for i in range(index):
            p = p.next
        return p

    def add_data(self, element):
        """
        在尾部添加节点
        :param element:
        :return:
        """
        node = Node(element)
        # 插入尾部
        self.last.next = node
        self.last = node
        self.size += 1

    def add_index_element(self, element, index):
        """
        在指定位置添加节点
        :param element:
        :param index:
        :return:
        """
        if index < 0 or index > self.size:
            raise Exception("超出链表节点范围！")
        node = Node(element)
        if self.size == 0:
            # 空链表
            self.head = node
            self.last = node
        elif index == 0:
            # 插入头部
            node.next = self.head
            self.head = node
        elif self.size == index:
            # 插入尾部
            self.last.next = node
            self.last = node
        else:
            # 插入中间
            prev_node = self.get(index - 1)
            node.next = prev_node.next
            prev_node.next = node
        self.size += 1

    def add(self, *args):
        """
        添加节点
        :param args:
        :return:
        """
        if len(args) == 2:
            self.add_index_element(index=args[0], element=args[1])
        if len(args) == 1:
            self.add_data(element=args[0])

    def remove_head(self):
        """
        移除头部节点
        :return:
        """
        removed_node = self.head
        self.head = self.head.next
        if self.size == 1:
            self.last == Node
        self.size -= 1
        return removed_node

    def remove_index(self, index):
        """
        移除指定位置的节点
        :param index:
        :return:
        """
        if index < 0 or index >= self.size:
            raise Exception("超出链表节点范围！")
        # 暂存被删除的节点，用于返回
        if index == 0:
            # 删除头节点
            removed_node = self.head
            self.head = self.head.next
            if self.size == 1:
                self.last == Node
        elif index == self.size - 1:
            # 删除尾节点
            prev_node = self.get(index - 1)
            removed_node = prev_node.next
            prev_node.next = None
            self.last = prev_node
        else:
            # 删除中间节点
            prev_node = self.get(index - 1)
            next_node = prev_node.next.next
            removed_node = prev_node.next
            prev_node.next = next_node
        self.size -= 1
        return removed_node

    def remove(self, *args):
        """

        :param args:
        :return:
        """
        if len(args) == 1:
            self.remove_index(args[0])
        if len(args) == 0:
            self.remove_head()

    def output(self):
        rnt = []
        p = self.head
        while p is not None:
            rnt.append(p.data)
            p = p.next
        print(rnt)


myLinkedList = MyLinkedList()
myLinkedList.add(0, 1)
myLinkedList.add(1, 2)
myLinkedList.add(2, 3)
myLinkedList.output()
myLinkedList.remove()
myLinkedList.remove()
myLinkedList.output()
myLinkedList.add(4)
myLinkedList.add(5)
myLinkedList.add(6)
myLinkedList.output()
myLinkedList.remove(1)
myLinkedList.remove(1)
myLinkedList.output()
print(myLinkedList.get(1).data)
