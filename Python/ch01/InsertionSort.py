def insertionSort(arr_args):
    """
    插入排序
    :param arr_args: 需要排序的数组
    :return: 排序之后的数组
    """
    for i in range(len(arr_args)):
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
