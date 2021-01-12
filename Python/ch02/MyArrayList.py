# 我的数组容器
class MyArrayList:
    def __init__(self, capacity):
        """

        :param capacity: 长度
        """
        self.array = [None] * capacity
        self.size = 0

    def add_index_element(self, index, element):
        """
        在指定位置添加元素
        :param index: 指定位置
        :param element: 元素
        :return:
        """
        # 判断访问下标是否超出范围
        if index < 0 or index > self.size:
            raise Exception("超出数组实际元素范围！")
        # 如果实际元素达到数组容量上线，数组扩容
        if self.size >= len(self.array):
            self.resize()
        # 从右向左循环，逐个元素向右挪一位。
        for i in range(self.size - 1, index - 1, -1):
            self.array[i + 1] = self.array[i]
        # 腾出的位置放入新元素
        self.array[index] = element
        self.size += 1

    def add_element(self, element):
        """
        在尾部放入新元素
        :param element: 放在尾部的元素
        :return:
        """
        # 如果实际元素达到数组容量上线，数组扩容
        if self.size >= len(self.array):
            self.resize()
        # 在尾部放入新元素
        self.array[self.size] = element
        self.size += 1

    def add(self, *args):
        """
        add
        :param args:
        :return:
        """
        if len(args) == 2:
            self.add_index_element(index=args[0], element=args[1])
        if len(args) == 1:
            self.add_element(element=args[0])

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

    def remove(self, index):
        """
        移除指定位置的数组
        :param index: 指定的位置
        :return:
        """
        # 判断访问下标是否超出范围
        if index < 0 or index >= self.size:
            raise Exception("超出数组实际元素范围！")
        # 从左到右，逐个元素向左挪动一位
        for i in range(index, self.size):
            self.array[i] = self.array[i + 1]
        self.size -= 1

    def output(self):
        """
        输出数组
        :return:
        """
        print(self.array)


myArrayList = MyArrayList(5)
myArrayList.add(0, 1)
myArrayList.add(1, 2)
myArrayList.add(2, 3)
myArrayList.output()
myArrayList.add(4)
myArrayList.add(5)
myArrayList.add(6)
myArrayList.output()
myArrayList.remove(1)
myArrayList.remove(1)
myArrayList.remove(1)
myArrayList.output()
