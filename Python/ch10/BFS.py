from queue import Queue

from ch10 import Converter


def bfs(node):
    # 做一个是否为空的判断
    if node is None:
        return None
    # 定义一个队列
    q = Queue()
    # 用一个set来记录已经遍历过的节点
    s = set()
    # 节点进入队列
    q.put(node)
    # 节点添加进set
    s.add(node)
    # 打印
    print(node)
    # 只要队列不为空
    while not q.empty():
        # 队列是先进先出
        cur = q.get()
        # 遍历nexts
        for iter in cur.nexts:
            if iter not in s:
                # 添加进队列，下次要从这个出发，进行遍历
                q.put(iter)
                # 如果不在set中，说明之前没有遍历过，添加进set
                s.add(iter)
                # 打印
                print(iter)

    return s


if __name__ == '__main__':
    m = [[None, 1, 2], [None, 2, 1],
         [None, 2, 3], [None, 3, 2],
         [None, 1, 4], [None, 4, 1],
         [None, 2, 5], [None, 5, 2],
         [None, 3, 6], [None, 6, 3],
         [None, 4, 5], [None, 5, 4],
         [None, 5, 6], [None, 6, 5],
         [None, 5, 7], [None, 7, 5],
         [None, 6, 8], [None, 8, 6],
         [None, 7, 8], [None, 8, 7]]
    g = Converter.from_matrix_to_graph(m)
    s = bfs(g.nodes.get(1))
    print('-' * 20)
    for iter in s:
        print(iter)
