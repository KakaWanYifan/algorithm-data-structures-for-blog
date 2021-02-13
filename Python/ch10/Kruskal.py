import heapq

from ch10 import Converter


class UnionFind:

    def __init__(self, nodes):
        # key:某一个节点， value:key节点往上的节点
        self.ups_map = dict()
        # key某一个集合的代表节点, value:key所在集合的节点个数
        self.size_map = dict()
        for iter in nodes:
            node = nodes[iter]
            # 一开始自己就是一个家族，那么自己就是自己的UP
            self.ups_map[node] = node
            # 大小就是1
            self.size_map[node] = 1

    def find_top(self, n):
        # 定义一个栈
        # 我们用Python的list
        # append()表示入栈
        # pop()表示出栈
        path = []
        while n is not self.ups_map[n]:
            path.append(n)
            n = self.ups_map[n]
        while len(path) > 0:
            self.ups_map[path.pop()] = n
        return n

    def is_same_set(self, a, b):
        return self.find_top(a) == self.find_top(b)

    def union(self, a, b):
        if a is None and b is None:
            return
        a_dai = self.find_top(a)
        b_dai = self.find_top(b)
        if a_dai != b_dai:
            a_set_size = self.size_map[a_dai]
            b_set_size = self.size_map[b_dai]
            if a_set_size <= b_set_size:
                self.ups_map[a_dai] = b_dai
                self.size_map[b_dai] = a_set_size + b_set_size
                self.size_map.pop(a_dai)
            else:
                self.ups_map[b_dai] = a_dai
                self.size_map[a_dai] = a_set_size + b_set_size
                self.size_map.pop(b_dai)


def kruskal(graph):
    unionFind = UnionFind(graph.nodes)
    # 从小的边到大的边，依次弹出，小根堆！
    p = []
    for edge in graph.edges:
        heapq.heappush(p, edge)
    result = set()
    while len(p) > 0:
        edge = heapq.heappop(p)
        if not unionFind.is_same_set(edge.from_node, edge.to_node):
            result.add(edge)
            unionFind.union(edge.from_node, edge.to_node)
    return result


if __name__ == '__main__':
    # 1 恒山
    # 2 华山
    # 3 嵩山
    # 4 泰山
    # 5 衡山
    m = [[50, 1, 2], [50, 2, 1],
         [20, 1, 3], [20, 3, 1],
         [10, 1, 4], [10, 4, 1],
         [2, 2, 3], [2, 3, 2],
         [5, 3, 4], [5, 4, 3],
         [100, 2, 5], [100, 5, 2],
         [20, 4, 5], [20, 5, 4]]
    g = Converter.from_matrix_to_graph(m)
    r = kruskal(g)
    for iter in r:
        print(iter)
