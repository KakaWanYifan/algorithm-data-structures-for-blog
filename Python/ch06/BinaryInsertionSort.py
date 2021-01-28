def binaryInsertionSort(arr_args):
    """
    二分插入排序
    :param arr_args: 需要排序的数组
    :return: 排序之后的数组
    """
    # i从1开始，先做到前2个数有序。
    # 为什么不是先做到前1个数有序？一个数字，不用排序了。
    for i in range(len(arr_args)):
        # 保存当前值
        key = arr_args[i]
        # 利用二分查找定位插入位置
        index = binarySearchLastLE(arr_args, key, 0, i - 1) + 1;
        # 将目标插入位置，同一时候右移目标位置右边的元素
        for j in range(i, index, -1):
            arr_args[j] = arr_args[j - 1]
        arr_args[index] = key

    return arr_args


def binarySearchLastLE(sortedArr, num, fromIndex, toIndex):
    # 记录位置
    index = -1
    # 最左边数字的index
    lIndex = fromIndex
    # 最右边数字的index
    rIndex = toIndex
    while lIndex <= rIndex:
        # 中间的index
        # 不写作 (lIndex + rIndex)/2 的原因是这样不容易溢出
        midIndex = lIndex + (rIndex - lIndex) // 2
        if sortedArr[midIndex] <= num:
            index = midIndex
            lIndex = midIndex + 1
        elif sortedArr[midIndex] > num:
            # 如果中间的数字比要找的数字大，说明在左侧。
            rIndex = midIndex - 1

    return index


if __name__ == '__main__':
    arr = [3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48]
    print(arr)
    print(binaryInsertionSort(arr))
