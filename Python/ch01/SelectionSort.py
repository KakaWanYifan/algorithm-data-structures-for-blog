def selectionSort(arr_args):
    """
    选择排序
    :param arr_args: 需要排序的数组
    :return: 排序之后的数组
    """
    # 遍历arr_args的index
    for i in range(len(arr_args)):
        # 最小index
        minIndex = i
        # 从第i个数到第n个数
        for j in range(i + 1, len(arr_args)):
            # 如果j更小
            if arr_args[j] < arr_args[minIndex]:
                # 更新minIndex
                minIndex = j

        # 互换
        arr_args[i], arr_args[minIndex] = arr_args[minIndex], arr_args[i]

    return arr_args


if __name__ == '__main__':
    arr = [3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48]
    print(arr)
    print(selectionSort(arr))
