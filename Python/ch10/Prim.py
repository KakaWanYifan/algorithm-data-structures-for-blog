import heapq

from ch10 import Converter


def prim(graph):
    # 选择的边
    rnt = set()
    # 解锁的边进入小根堆
    p = []
    # 被解锁的点
    node_set = set()
    # 被解锁过的边
    edge_set = set()
    # 遍历所有的点
    for iter in graph.nodes:
        node = graph.nodes[iter]
        # node 是开始点
        if node not in node_set:
            node_set.add(node)
            # 由一个点，解锁所有相连的边
            for edge in node.edges:
                if edge not in edge_set:
                    edge_set.add(edge)
                    heapq.heappush(p, edge)
            while len(p) > 0:
                # 弹出解锁的边中，最小的边
                edge = heapq.heappop(p)
                # 可能的一个新的点
                to_node = edge.to_node
                # 不含有的时候，就是新的点
                if to_node not in node_set:
                    node_set.add(to_node)
                    rnt.add(edge)
                    for next_edge in to_node.edges:
                        if next_edge not in edge_set:
                            edge_set.add(next_edge)
                            heapq.heappush(p, next_edge)
    return rnt


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
    r = prim(g)
    for iter in r:
        print(iter)
