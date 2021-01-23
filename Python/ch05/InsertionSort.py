def insertionSort(arr_args):
    """
    插入排序
    :param arr_args: 需要排序的数组
    :return: 排序之后的数组
    """
    for i in range(1, len(arr_args)):
        # i从1开始，先做到前2个数有序。
        # 为什么不是先做到前1个数有序？一个数字，不用排序了。
        maxIndex = i
        for j in range(maxIndex, 0, -1):
            if arr_args[j] < arr_args[j - 1]:
                arr_args[j], arr_args[j - 1] = arr_args[j - 1], arr_args[j]
            else:
                break

    return arr_args


if __name__ == '__main__':
    arr = [3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48]
    print(arr)
    print(insertionSort(arr))
