def binarySearchLastLE(arr, target):
    # 记录位置
    index = -1
    # 最左边数字的index
    lIndex = 0
    # 最右边数字的index
    rIndex = len(arr) - 1
    # 中间数字的index
    midIndex = 0
    while lIndex <= rIndex:
        # 中间的index
        # 不写作 (lIndex + rIndex)/2 的原因是这样不容易溢出
        midIndex = lIndex + (rIndex - lIndex) // 2
        if arr[midIndex] <= target:
            index = midIndex
            lIndex = midIndex + 1
        elif arr[midIndex] > target:
            # 如果中间的数字比要找的数字大，说明在左侧。
            rIndex = midIndex - 1

    return index
