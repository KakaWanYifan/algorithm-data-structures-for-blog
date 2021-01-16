class DoubleNode:
    def __init__(self, data):
        """

        :param data:
        """
        self.data = data
        self.next = None
        self.prev = None


class DoubleLink:
    def __init__(self):
        self.head = None
        self.tail = None

    def addAtHead(self, data):
        """

        :param data:
        :return:
        """
        curr = DoubleNode(data)

        if self.head is None:
            self.head = curr
            self.tail = curr
        else:
            curr.next = self.head
            self.head.prev = curr
            self.head = curr

    def removeAtHead(self):
        """

        :return:
        """
        if self.head is None:
            return None
        curr = self.head
        self.head = self.head.next
        self.head.prev = None
        curr.next = None
        return curr

    def addAtTail(self, data):
        """

        :param data:
        :return:
        """
        curr = DoubleNode(data)

        if self.tail is None:
            self.tail = curr
            self.head = curr
        else:
            self.tail.next = curr
            curr.prev = self.tail
            self.tail = curr

    def removeAtTail(self):
        """

        :return:
        """
        if self.tail is None:
            return None

        curr = self.tail
        self.tail = self.tail.prev
        self.tail.next = None
        curr.prev = None

        return curr

    def output(self):
        rnt = ""
        temp = self.head;
        while temp is not None:
            rnt = rnt + str(temp.data) + " "
            temp = temp.next

        print(rnt)


if __name__ == '__main__':
    doubleLink = DoubleLink()
    for i in range(10):
        doubleLink.addAtHead(9 - i)

    doubleLink.output()
    print(doubleLink.removeAtHead().data)
    print(doubleLink.removeAtTail().data)
    doubleLink.output()
    doubleLink.addAtTail(10)
    doubleLink.addAtTail(11)
    doubleLink.addAtTail(12)
    doubleLink.output()