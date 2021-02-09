class Heap:

    def __init__(self, c):
        self.a = [None] * (c + 1)
        self.capacity = c
        self.count = 0

    def find(self, data):
        for index in range(1, self.count):
            if self.a[index] == data:
                print(index)
                return

        print(-1)

    def insert(self, data):
        # 堆满了
        if self.count >= self.capacity:
            return False
        self.count = self.count + 1
        self.a[self.count] = data
        i = self.count
        # i/2 > 0 ：说明有父节点
        # a[i] > a[i/2] ：说明该节点比父节点还大
        while i // 2 > 0 and self.a[i] > self.a[i // 2]:
            self.a[i], self.a[i // 2] = self.a[i // 2], self.a[i]
            i = i // 2
        return True

    def remove(self, data):
        # 堆中没有数据
        if self.count == 0:
            return False
        index = -1
        for i in range(1, self.count):
            if self.a[i] == data:
                index = i
                break
        # 没有要删除的数据
        if index == -1:
            return False
        # 换位置
        self.a[index] = self.a[self.count]
        self.count = self.count - 1
        while True:
            # 最大值的位置
            max_pos = index
            # 判断左子节点
            # 如果有左子节点，且小于左子节点
            if index * 2 <= self.count and self.a[max_pos] < self.a[index * 2]:
                # 左子节点作为最大的位置
                max_pos = index * 2
                # 判断右子节点
                # 如果有右子节点，且最大位置的节点小于右子节点
            if index * 2 + 1 <= self.count and self.a[max_pos] < self.a[index * 2 + 1]:
                # 那么，右子节点的作为最大的位置
                max_pos = index * 2 + 1
            # 如果左右节点都比较过了，index就是最大位置，那么说明完成。
            if max_pos == index:
                break
            self.a[index], self.a[max_pos] = self.a[max_pos], self.a[index]
            index = max_pos

        return True

    def print(self):
        print(self.a[1:self.count + 1])

    def pop_top(self):
        if self.count == 0:
            raise Exception("Heap has no element")
        index = 1
        rnt = self.a[index]
        # 换位置
        self.a[index] = self.a[self.count]
        self.count = self.count - 1
        while True:
            # 最大值的位置
            max_pos = index
            # 判断左子节点
            # 如果有左子节点，且小于左子节点
            if index * 2 <= self.count and self.a[max_pos] < self.a[index * 2]:
                # 左子节点作为最大的位置
                max_pos = index * 2
                # 判断右子节点
                # 如果有右子节点，且最大位置的节点小于右子节点
            if index * 2 + 1 <= self.count and self.a[max_pos] < self.a[index * 2 + 1]:
                # 那么，右子节点的作为最大的位置
                max_pos = index * 2 + 1
            # 如果左右节点都比较过了，index就是最大位置，那么说明完成。
            if max_pos == index:
                break
            self.a[index], self.a[max_pos] = self.a[max_pos], self.a[index]
            index = max_pos

        return rnt


if __name__ == '__main__':
    heap = Heap(10)
    heap.insert(9)
    heap.insert(8)
    heap.insert(7)
    heap.insert(6)
    heap.insert(4)
    heap.insert(3)
    heap.insert(2)
    heap.insert(1)
    heap.insert(0)
    heap.print()

    heap.insert(5)
    heap.print()

    heap.remove(10)
    heap.print()

    heap.find(3)

    heap.remove(3)
    heap.print()

    heap.find(3)

    print(heap.pop_top())
    print(heap.pop_top())
    print(heap.pop_top())
    print(heap.pop_top())
    print(heap.pop_top())
    print(heap.pop_top())
    print(heap.pop_top())
    print(heap.pop_top())
    print(heap.pop_top())
