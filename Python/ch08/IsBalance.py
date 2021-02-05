class Node:
    def __init__(self, v):
        self.value = v
        self.left = None
        self.right = None


class Info:
    def __init__(self, b, h):
        self.is_balance = b
        self.height = h


def process(r):
    if r is None:
        return Info(True, 0)

    left_info = process(r.left)
    right_info = process(r.right)

    height = max(left_info.height, right_info.height) + 1
    is_balance = False
    if left_info.is_balance and right_info.is_balance and abs(left_info.height - right_info.height) <= 1:
        is_balance = True
    return Info(is_balance, height)


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

    print(process(root).is_balance)
