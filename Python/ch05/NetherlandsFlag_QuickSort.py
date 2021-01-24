def netherlandsFlag(arr, L, R):
    """
    荷兰国旗过程
    :param arr: 参与荷兰过程过程的数组 
    :param L: 左边界
    :param R: 右边界
    :return: 荷兰国旗过程之后的新的边界
    """
    # 小于边界
    # 小于边界的起始位置在左边界的左
    less = L - 1
    # 大于边界
    # 大于边界本来是应该在右边界的右，我们这里，暂时把Arr[R]包裹进去，后面再换一下。
    more = R
    # index指针，用来遍历
    index = L
    # index只要没有和大于边界相遇
    while index < more:
        # 这一段过程就是荷兰国旗过程了
        # 对着逻辑敲代码
        if arr[index] == arr[R]:
            index = index + 1
        elif arr[index] < arr[R]:
            arr[less + 1], arr[index] = arr[index], arr[less + 1]
            less = less + 1
            index = index + 1
        else:
            arr[index], arr[more - 1] = arr[more - 1], arr[index]
            more = more - 1

    # 把Arr[R]移过去
    arr[more], arr[R] = arr[R], arr[more]
    return [less + 1, more]


def quickSort(arr, L, R):
    if L >= R:
        return arr
    equalArea = netherlandsFlag(arr, L, R)
    quickSort(arr, L, equalArea[0] - 1)
    quickSort(arr, equalArea[1] + 1, R)
    return arr


if __name__ == '__main__':
    a = [3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48]
    print(a)
    print(quickSort(a, 0, len(a) - 1))
