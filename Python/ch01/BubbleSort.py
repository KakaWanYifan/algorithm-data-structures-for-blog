def bubbleSort(arr_args):
    """
    冒泡排序
    :param arr_args: 需要排序的数组
    :return: 排序之后的数组
    """
    for i in range(len(arr_args)):
        maxIndex = len(arr_args) - i - 1
        for j in range(maxIndex):
            if arr_args[j] > arr_args[j + 1]:
                arr_args[j], arr_args[j + 1] = arr_args[j + 1], arr_args[j]

    return arr_args


if __name__ == '__main__':
    arr = [3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48]
    print(arr)
    print(bubbleSort(arr))
