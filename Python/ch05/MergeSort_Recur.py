def mergeSort(arr, L, R):
    # 如果左指针等于右指针，说明已经拆分到不能拆分了。
    if L == R:
        return arr
    # 如果L不等于R，说明不止一个数，那么，递归吧
    # 中间
    M = (L + R) // 2
    # 递归
    mergeSort(arr, L, M)
    mergeSort(arr, M + 1, R)
    # 合并操作
    merge(arr, L, M, R)
    return arr


def merge(arr, L, M, R):
    # 辅助数组 大小是 R - L + 1，即归并之后的数组的大小
    helpArr = [None] * (R - L + 1)
    # 辅助数组的指针
    helpPoint = 0
    # 指针一，第一个数组的指针
    p1 = L
    # 指针二，第二个数组的指针
    p2 = M + 1
    # 如果指针一和指针二都没结束
    while p1 <= M and p2 <= R:
        # 谁小放谁
        if arr[p1] <= arr[p2]:
            helpArr[helpPoint] = arr[p1]
            p1 = p1 + 1
        else:
            helpArr[helpPoint] = arr[p2]
            p2 = p2 + 1
        helpPoint = helpPoint + 1
    # 要么p1越界了，要么p2越界了
    while p1 <= M:
        helpArr[helpPoint] = arr[p1]
        helpPoint = helpPoint + 1
        p1 = p1 + 1

    while p2 <= R:
        helpArr[helpPoint] = arr[p2]
        helpPoint = helpPoint + 1
        p2 = p2 + 1

    # 归并之后，把数据从辅助数组中塞回去
    for i in range(len(helpArr)):
        arr[L + i] = helpArr[i]


if __name__ == '__main__':
    a = [3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48]
    print(a)
    # 只有数组不为空，并且数组的长度大于1，这时候的排序才有意义
    if a is not None and len(a) > 1:
        a = mergeSort(a, 0, len(a) - 1)
    print(a)
