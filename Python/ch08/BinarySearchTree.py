class Node:
    def __init__(self, v):
        self.value = v
        self.left = None
        self.right = None


def insert(tree, data):
    """
    插入
    :param tree:
    :param data:
    :return:
    """
    # 如果是空
    if tree is None:
        tree = Node(data)
        return tree

    # 当前操作的节点
    curr = tree

    while curr is not None:
        if data > curr.value:
            if curr.right is None:
                curr.right = Node(data)
                break
            else:
                curr = curr.right
        else:
            if curr.left is None:
                curr.left = Node(data)
                break
            else:
                curr = curr.left;

    return tree


def find(tree, data):
    curr = tree
    while curr is not None:
        if data < curr.value:
            curr = curr.left
        elif data > curr.value:
            curr = curr.right
        else:
            return True

    return False


def delete(tree, data):
    curr = tree
    curr_father = None
    while curr is not None:
        if curr.value == data:
            break
        curr_father = curr
        if curr.value > data:
            curr = curr.left
        else:
            curr = curr.right

    if curr is None:
        return tree

    if curr.left is None or curr.right is None:
        # 如果左子树是null或者右子树是null，说明是叶子节点或者只有左子树或者右子树
        child = None
        if curr.left is not None:
            child = curr.left
        elif curr.right is not None:
            child = curr.right
        else:
            child = None

        if curr_father is None:
            tree = child
        elif curr_father.left == curr:
            curr_father.left = child
        else:
            curr_father.right = child
    else:
        # 如果既有左子树，还有右子树
        min = curr.right
        min_father = None
        while min.left is not None:
            min_father = min
            min = min.left

        curr.value = min.value
        if min_father.left == min:
            min_father.left = None
        else:
            min_father.right = None

    return tree


def find_interval(root, min, max):
    rnt = []
    if root is None:
        return rnt

    if min <= root.value <= max:
        rnt.append(root.value)

    # 如果大于min，递归左节点
    if root.value > min:
        rnt.extend(find_interval(root.left, min, max))

    # 如果小于max，递归右节点
    if root.value < max:
        rnt.extend(find_interval(root.right, min, max))

    return rnt


def find_max(tree):
    max = None
    curr = tree

    while curr is not None:
        max = curr.value
        curr = curr.right

    return max


def find_min(tree):
    min = None
    curr = tree
    while curr is not None:
        min = curr.value
        curr = curr.left

    return min

def mid(r):
    rnt = []
    if r is None:
        return rnt
    rnt.extend(mid(r.left))
    rnt.append(r.value)
    rnt.extend(mid(r.right))
    return rnt


if __name__ == '__main__':
    t = None
    t = insert(t, 0)
    t = insert(t, 1)
    t = insert(t, 2)
    t = insert(t, 3)
    t = insert(t, 4)
    t = insert(t, 5)
    t = insert(t, 6)
    t = insert(t, 7)
    t = insert(t, 8)
    t = insert(t, 9)
    print(t.value)
    print(mid(t))
    print(find(t, 10))
    print(find(t, 1))
    t = delete(t, 10)
    t = delete(t, 1)
    print(find(t, 10))
    print(find(t, 1))
    print(find_interval(t, 3, 6))
    t = delete(t, 5)
    print(find_interval(t, 3, 6))
    print(find_max(t))
    print(find_min(t))
    t = delete(t, 0)
    t = delete(t, 9)
    print(find_max(t))
    print(find_min(t))
