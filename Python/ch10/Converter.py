from Node_Edge_Graph import *


def from_matrix_to_graph(matrix):
    # 初始化图
    graph = Graph()
    # 遍历矩阵的行
    for i in range(0, len(matrix)):
        # 第一个数代表权重
        weight = matrix[i][0]
        # 第二个数代表from节点的Id
        from_id = matrix[i][1]
        # 第三个数代表to节点的Id
        to_id = matrix[i][2]
        # 如果图不包含fromId的节点，即这个节点从来没出现过
        if from_id not in graph.nodes.keys():
            # 把节点添加到图中
            node = Node(from_id)
            graph.nodes[from_id] = node
        # 如果图中不包含toId的节点，即这个节点从来没出现过
        if to_id not in graph.nodes.keys():
            # 把节点添加到图中
            node = Node(to_id)
            graph.nodes[to_id] = node
        # fromNode
        from_node = graph.nodes.get(from_id)
        # toNode
        to_node = graph.nodes.get(to_id)
        # 实例化边
        edge = Edge(weight, from_node, to_node)
        # fromNode的出度加一
        from_node.out_size = from_node.out_size + 1
        # toNode的入度加一
        to_node.in_size = to_node.in_size + 1
        # from_node的nexts增加一个节点
        from_node.nexts.append(to_node)
        # 从fromNode出发的边新增一个
        from_node.edges.append(edge)
        # 图新增一条边
        graph.edges.add(edge)
    return graph


if __name__ == '__main__':
    m = [[1, 1, 2], [2, 1, 3], [3, 2, 3]]
    g = from_matrix_to_graph(m)

    for n in g.nodes:
        print(g.nodes.get(n))

    for e in g.edges:
        print(e)
