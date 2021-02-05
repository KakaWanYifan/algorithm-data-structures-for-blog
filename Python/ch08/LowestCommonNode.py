class Node:
    def __init__(self, v):
        self.value = v
        self.left = None
        self.right = None


class Info:
    def __init__(self, f, a, b):
        self.ans = f
        self.find_a = a
        self.find_b = b


def process(x, a, b):
    if x is None:
        return Info(None, False, False)

    left_info = process(x.left, a, b)
    right_info = process(x.right, a, b)
    find_a = (x == a or left_info.find_a or right_info.find_a)
    find_b = (x == b or left_info.find_b or right_info.find_b)
    ans = None
    if left_info.ans is not None:
        ans = left_info.ans
    if right_info.ans is not None:
        ans = right_info.ans
    if ans is None:
        if find_a and find_b:
            ans = x

    return Info(ans, find_a, find_b)


if __name__ == '__main__':
    root = Node(6)
    a = Node(5)
    b = Node(1)
    root.left = Node(4)
    root.right = Node(8)
    root.left.left = Node(2)
    root.left.right = a
    root.right.left = Node(7)
    root.right.right = Node(9)
    root.left.left.left = b
    root.left.left.right = Node(3)

    print(process(root, a, b).ans.value)
