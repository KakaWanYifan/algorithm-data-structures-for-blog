def heap_sort(arr):
    if len(arr) <= 1:
        return arr

    # 1、建堆
    for i in range((len(arr) - 1) // 2, -1, -1):
        arr = heapify(arr, len(arr) - 1, i)

    # 2、排序
    k = len(arr) - 1
    while k > 0:
        # 将堆顶元素（最大）与最后一个元素交换位置
        arr[0], arr[k] = arr[k], arr[0]
        # 将剩下元素重新堆化，堆顶元素变成最大元素
        k = k - 1
        arr = heapify(arr, k, 0)
    return arr


def heapify(arr, n, i):
    while (True):
        # 最大值位置
        max_pos = i
        # 与左子节点（i * 2 + 1）比较，获取最大值位置
        if i * 2 + 1 <= n and arr[i] < arr[i * 2 + 1]:
            max_pos = i * 2 + 1
        # 最大值与右子节点（i * 2 + 2）比较，获取最大值位置
        if i * 2 + 2 <= n and arr[max_pos] < arr[i * 2 + 2]:
            max_pos = i * 2 + 2
        # 最大值是当前位置结束循环
        if max_pos == i:
            break
        # 与子节点交换位置
        arr[i], arr[max_pos] = arr[max_pos], arr[i]
        # 以交换后子节点位置接着往下查找
        i = max_pos
    return arr


if __name__ == '__main__':
    arr = [3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48]
    print(arr)
    print(heap_sort(arr))
