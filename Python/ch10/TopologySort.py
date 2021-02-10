from queue import Queue

from ch10 import Converter


def topologySort(graph):
    rnt = []
    # 用一个Dict，来记录所有的剩余入度
    in_dict = dict()
    # 入度为0的点，进入队列
    zero_in_queue = Queue()
    # 遍历节点
    for iter_key in graph.nodes:
        iter = graph.nodes.get(iter_key)
        # 记录初始阶段的所有节点及其入度
        in_dict[iter] = iter.in_size
        # 如果该节点的入度是0
        if iter.in_size == 0:
            # 加入队列
            zero_in_queue.put(iter)

    # 如果队列不为空
    while not zero_in_queue.empty():
        # 队列，先进先出
        cur = zero_in_queue.get()
        # 记录
        rnt.append(cur)
        # 遍历队列的nexts
        for iter in cur.nexts:
            # 入度减一
            in_dict[iter] = in_dict.get(iter) - 1
            # 如果入度等于0
            if in_dict.get(iter) == 0:
                zero_in_queue.put(iter)
    return rnt


if __name__ == '__main__':
    m = [[None, 1, 2],
         [None, 2, 3],
         [None, 3, 4],
         [None, 4, 5],
         [None, 2, 6],
         [None, 3, 6],
         [None, 4, 6],
         [None, 5, 6]]
    g = Converter.from_matrix_to_graph(m)
    l = topologySort(g)
    for iter in l:
        print(iter)
