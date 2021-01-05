def binaryMinimumIndex(arr):
    # 如果数组的长度是1
    if len(arr) == 1:
        # 那么局部最小值的index就是0
        return 0

    # 如果arr[0] 小于 arr[1]
    if arr[0] < arr[1]:
        # 那么，arr[0]就是局部最小值
        return 0

    # 如果arr[T-1] 小于 arr[T-2]
    if arr[len(arr) - 1] < arr[len(arr) - 2]:
        # 那么，arr[T-1]就是局部最小值
        return arr.length - 1

    # 如果前面的都没有命中，说明左侧递减，右侧递增
    # 那么，必存在极值在中间区域
    # 左边是left
    left = 1
    # 右边是T-2
    right = len(arr) - 2
    # 中间
    mid = 0
    while left != right:
        mid = (left + right) // 2
        # 如果中间值比中间偏左的值大，说明递增。
        # 且已知左侧递减，又中间递增
        # 所以必存在极值在左侧和中间的区域之间
        # 所以把右边界移动到中间
        if arr[mid] > arr[mid - 1]:
            right = mid - 1
        # 如果中间值比中间偏右的值大，说明递减
        # 且已知右侧递增，有中间递减
        # 所以必存在极值在右侧和中间的区域之间
        # 所以把左边界移动到中间
        elif arr[mid] > arr[mid + 1]:
            left = mid + 1
        # 如果前面的都没有命中的话，说明拿到了极值
        else:
            return mid

    return left


if __name__ == '__main__':
    a = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]
    index = binaryMinimumIndex(a)
    print(index)
    print(a[index])
