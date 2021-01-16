class ArrayStack:
    def __init__(self, capacity):
        """

        :param capacity: 长度
        """
        self.array = [None] * capacity
        self.size = 0

    def resize(self):
        """
        数组扩容
        :return:
        """
        array_new = [None] * len(self.array) * 2
        # 从旧数组拷贝到新数组
        for i in range(self.size):
            array_new[i] = self.array[i]
        self.array = array_new

    def push(self, data):
        """
        在尾部放入新元素
        :param data:
        :return:
        """
        # 如果实际元素达到数组容量上线，数组扩容
        if self.size >= len(self.array):
            self.resize()
        # 在尾部放入新元素
        self.array[self.size] = data
        self.size = self.size + 1

    def pop(self):
        if self.size <= 0:
            return None
        index = self.size - 1
        self.size = self.size - 1
        return self.array[index]

    def output(self):
        """
        输出数组
        :return:
        """
        print(self.array[:self.size])


if __name__ == '__main__':
    arrayStack = ArrayStack(3)
    print(arrayStack.pop())
    arrayStack.push(1)
    arrayStack.push(2)
    arrayStack.push(3)
    arrayStack.output()
    arrayStack.push(4)
    arrayStack.push(5)
    arrayStack.push(6)
    arrayStack.output()
    print(arrayStack.pop())
    print(arrayStack.pop())
    print(arrayStack.pop())
    arrayStack.output()
    print(arrayStack.pop())
    print(arrayStack.pop())
    print(arrayStack.pop())
    print(arrayStack.pop())
