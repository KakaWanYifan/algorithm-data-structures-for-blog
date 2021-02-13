import sys

from ch10 import Converter


def dijkstra(from_node):
    # 最后要返回的表，记录从from节点到其他节点的最小距离
    distance_dict = dict()
    # 从from节点到from节点的距离为0
    distance_dict[from_node] = 0
    # 已经求过距离的节点，放在recordNodes中，登记
    record_nodes = set()
    # 找到在未登记的节点中，距离最小的节点
    min_node = get_min_distance_in_unrecorded_node(distance_dict, record_nodes)
    # 如果minNode不是空的，说明找到了距离最小点
    while min_node is not None:
        # 获取距离
        distance = distance_dict[min_node]
        # 遍历距离最小点的边
        for edge in min_node.edges:
            # 边的to节点
            to_node = edge.to_node
            if to_node not in distance_dict:
                # 如果to节点不在distanceMap中
                distance_dict[to_node] = distance + edge.weight
            else:
                # 否则记录
                distance_dict[edge.to_node] = min(distance_dict[to_node], distance + edge.weight)

        # 登记
        record_nodes.add(min_node)
        # 循环
        min_node = get_min_distance_in_unrecorded_node(distance_dict, record_nodes)

    return distance_dict


def get_min_distance_in_unrecorded_node(distance_dict, record_nodes):
    # 距离最小的节点
    min_node = None
    # 最小距离，一开始初始化未最大值
    min_distance = sys.maxsize
    # 遍历距离表
    for iter in distance_dict:
        # 节点
        # 距离
        distance = distance_dict[iter]
        # 如果这个节点没有登记，并且距离比minDistance还要小
        if iter not in record_nodes and distance < min_distance:
            min_node = iter
            min_distance = distance

    return min_node


if __name__ == '__main__':
    # 1 恒山
    # 2 华山
    # 3 嵩山
    # 4 泰山
    # 5 衡山
    m = [[3, 1, 2], [3, 2, 1],
         [1, 1, 3], [1, 3, 1],
         [2, 1, 4], [2, 4, 1],
         [1, 2, 3], [1, 3, 2],
         [5, 3, 4], [5, 4, 3],
         [9, 2, 5], [9, 5, 2],
         [2, 3, 5], [2, 5, 3],
         [6, 4, 5], [6, 5, 4]]
    g = Converter.from_matrix_to_graph(m)
    # 从华山派出发
    r = dijkstra(g.nodes.get(2))
    for i in r:
        print(i, r[i])
