# 二叉树的节点
class Node:
    def __init__(self, v):
        self.left = None
        self.right = None
        self.value = v


def pre(r):
    rnt = []
    if r is None:
        return rnt
    rnt.append(r.value)
    rnt.extend(pre(r.left))
    rnt.extend(pre(r.right))
    return rnt


def mid(r):
    rnt = []
    if r is None:
        return rnt
    rnt.extend(mid(r.left))
    rnt.append(r.value)
    rnt.extend(mid(r.right))
    return rnt


def pos(r):
    rnt = []
    if r is None:
        return rnt
    rnt.extend(pos(r.left))
    rnt.extend(pos(r.right))
    rnt.append(r.value)
    return rnt


if __name__ == '__main__':
    root = Node(6)
    root.left = Node(4)
    root.right = Node(8)
    root.left.left = Node(2)
    root.left.right = Node(5)
    root.right.left = Node(7)
    root.right.right = Node(9)
    root.left.left.left = Node(1)
    root.left.left.right = Node(3)

    print('pre:')
    print(pre(root))
    print('mid:')
    print(mid(root))
    print('pos:')
    print(pos(root))
