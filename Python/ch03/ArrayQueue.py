class ArrayQueue:
    array = []
    head = 0
    tail = 0

    def __init__(self, capacity):
        self.array = [None] * capacity
        self.head = 0
        self.tail = 0

    def deQueue(self):
        """
        出队
        :return: 出队的元素
        """
        if self.tail == self.head:
            raise Exception('队列是空的')
        data = self.array[self.head]
        self.head = (self.head + 1) % len(self.array)
        return data

    def enQueue(self, data):
        """
        入队
        :param data: 进入队伍的元素
        :return:
        """
        if (self.tail + 1) % len(self.array) == self.head:
            raise Exception('队列是满的')
        self.array[self.tail] = data
        self.tail = (self.tail + 1) % len(self.array)

    def output(self):
        """
        输出
        :return:
        """
        rnt = ""
        i = self.head
        while i != self.tail:
            rnt = rnt + str(self.array[i]) + " "
            i = (i + 1) % len(self.array)
        print(rnt)


if __name__ == '__main__':
    arrayQueue = ArrayQueue(6)
    arrayQueue.enQueue(1)
    arrayQueue.enQueue(2)
    arrayQueue.enQueue(3)
    arrayQueue.enQueue(4)
    arrayQueue.enQueue(5)
    arrayQueue.deQueue()
    arrayQueue.deQueue()
    arrayQueue.deQueue()
    arrayQueue.enQueue(6)
    arrayQueue.enQueue(7)
    arrayQueue.enQueue(8)
    arrayQueue.output()
