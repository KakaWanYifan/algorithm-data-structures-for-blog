from queue import Queue


class Node:
    def __init__(self, v):
        self.value = v
        self.left = None
        self.right = None


def layer(r):
    rnt = []
    if r is None:
        return r
    q = Queue()
    q.put(r)
    while q.empty() is False:
        n = q.get()
        rnt.append(n.value)
        if n.left is not None:
            q.put(n.left)
        if n.right is not None:
            q.put(n.right)

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

    print(layer(root))
