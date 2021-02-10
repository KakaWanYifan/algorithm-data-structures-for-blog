class Node:
    def __init__(self, v):
        self.value = v

    def __str__(self):
        return str(self.value)


class UnionFind:
    def __init__(self, values):
        # 并查集中的所有节点
        self.nodes = dict()
        # 节点和节点之间的UP关系
        self.ups = dict()
        # 家族的大小
        self.size_map = dict()
        for iter in values:
            node = Node(iter)
            self.nodes[iter] = node
            # 一开始自己就是一个家族，那么自己就是自己的UP
            self.ups[node] = node
            # 大小就是1
            self.size_map[node] = 1

    def find_top(self, cur):
        # 定义一个栈
        # 我们用Python的list
        # append()表示入栈
        # pop()表示出栈
        path = []
        while cur is not self.ups.get(cur):
            path.append(cur)
            cur = self.ups.get(cur)
        while len(path) > 0:
            self.ups[path.pop()] = cur
        return cur

    def is_same_set(self, a, b):
        """
        是否是同一个集合 查
        :param a:
        :param b:
        :return:
        """
        return self.find_top(self.nodes.get(a)) == self.find_top(self.nodes.get(b))

    def union(self, a, b):
        # a节点的家族的代表
        a_head = self.find_top(self.nodes.get(a))
        # b节点的家族的代表
        b_head = self.find_top(self.nodes.get(b))
        if a_head is not b_head:
            # a家族的大小
            a_set_size = self.size_map.get(a_head)
            # b家族的大小
            b_set_size = self.size_map.get(b_head)
            if a_set_size >= b_set_size:
                self.ups[b_head] = a_head
                # 家族的大小
                self.size_map[a_head] = a_set_size + b_set_size
                # 一个家族，一个代表，一个大小
                self.size_map.pop(b_head)
            else:
                self.ups[a_head] = b_head
                # 家族的大小
                self.size_map[b_head] = a_set_size + b_set_size
                # 一个家族，一个代表，一个大小
                self.size_map.pop(a_head)


if __name__ == '__main__':
    unionFind = UnionFind([1, 2, 3, 4, 5, 6])
    for iter in unionFind.nodes:
        print(iter, unionFind.nodes.get(iter))
    print('-' * 10)
    for iter in unionFind.ups:
        print(iter, unionFind.ups.get(iter))
    print('-' * 10)
    for iter in unionFind.size_map:
        print(iter, unionFind.size_map.get(iter))
    print('-' * 10)

    print(unionFind.is_same_set(1, 2))
    unionFind.union(1, 2)
    print(unionFind.is_same_set(1, 2))

    for iter in unionFind.nodes:
        print(iter, unionFind.nodes.get(iter))
    print('-' * 10)
    for iter in unionFind.ups:
        print(iter, unionFind.ups.get(iter))
    print('-' * 10)
    for iter in unionFind.size_map:
        print(iter, unionFind.size_map.get(iter))
