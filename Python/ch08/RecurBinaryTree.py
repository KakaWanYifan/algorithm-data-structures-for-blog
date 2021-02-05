# 二叉树的节点
class Node:
    def __init__(self, v):
        self.left = None
        self.right = None
        self.value = v


def recur(r):
    if r is None:
        return
    print(r.value, end='')
    recur(r.left)
    print(r.value, end='')
    recur(r.right)
    print(r.value, end='')


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

    recur(root)
