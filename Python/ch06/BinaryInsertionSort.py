def binaryInsertionSort(arr_args):
    """
    插入排序
    :param arr_args: 需要排序的数组
    :return: 排序之后的数组
    """
    for i in range(1, len(arr_args)):
        # i从1开始，先做到前2个数有序。
        # 为什么不是先做到前1个数有序？一个数字，不用排序了。
        # 保存当前值
        key = arr_args[i]
        # 利用二分查找定位插入位置
        index = binarySearchAsc(arr_args, key, 0, i - 1)
        # 将目标插入位置，同一时候右移目标位置右边的元素
        for j in range(i, index, -1):
            arr_args[j] = arr_args[j - 1]

        arr_args[index] = key

    return arr_args


def binarySearchAsc(ary, target, from_index, to_index):
    """
    二分查找 升序 递归
    :param ary: 给定已排序的待查数组
    :param target: 查找目标
    :param from_index: 当前查找的范围起点
    :param to_index: 当前查找的返回终点
    :return: 返回目标在数组中，按顺序应在的位置
    """
    range = to_index - from_index
    # 假设范围大于0，即存在两个以上的元素，则继续拆分
    if range > 0:
        # 选定中间位
        mid = (to_index + from_index) // 2
        if ary[mid] > target:
            # 如果中间位置的值大于要查找的目标，说明在from和中间位置之间
            return binarySearchAsc(ary, target, from_index, mid - 1)
        else:
            # 否则，说明在中间位置和to之间，说明在中间位置和to之间
            return binarySearchAsc(ary, target, mid + 1, to_index)
    else:
        # 如果范围都都小于0了。
        # 要么在from位置上
        # 要么在from位置的前一个上
        if ary[from_index] > target:
            return from_index
        else:
            return from_index + 1


if __name__ == '__main__':
    arr = [3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48]
    print(arr)
    print(binaryInsertionSort(arr))
