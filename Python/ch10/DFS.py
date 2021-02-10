from ch10 import Converter


def dfs(node):
    # 做一个是否为空的判断
    if node is None:
        return None
    # 定义一个栈
    # 我们用Python的list
    # append()表示入栈
    # pop()表示出栈
    stack = []
    # 用一个set来记录已经遍历过的节点
    s = set()
    # 进栈
    stack.append(node)
    # 记录
    s.add(node)
    # 打印
    print(node)
    while len(stack) > 0:
        # 栈，后进先出
        cur = stack.pop()
        # 遍历 next
        for iter in cur.nexts:
            # 这个节点没有被遍历过
            if iter not in s:
                # 把cur压回栈
                stack.append(cur)
                # 把当前节点压回栈
                stack.append(iter)
                # 记录
                s.add(iter)
                # 打印
                print(iter)
                # break，不再循环遍历，从iter出发
                break
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
    s = dfs(g.nodes.get(1))
    print('-' * 20)
    for iter in s:
        print(iter)
