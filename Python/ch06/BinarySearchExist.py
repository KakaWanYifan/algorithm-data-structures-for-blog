def binarySearchExist(arr, target):
    # 最左边数字的index
    lIndex = 0
    # 最右边数字的index
    rIndex = len(arr) - 1
    # 中间数字的index
    midIndex = 0
    # 一定是 lIndex < rIndex
    # 不能是 lIndex != rIndex
    while lIndex < rIndex:
        # 中间的index
        # 不写作 (lIndex + rIndex) // 2 的原因是这样不容易溢出
        midIndex = lIndex + (rIndex - lIndex) // 2
        if arr[midIndex] == target:
            # 如果中间的数字就是要找的数字
            return True
        elif arr[midIndex] > target:
            # 如果中间的数字比要找的数字大，说明在左侧。
            rIndex = midIndex - 1
        else:
            # 反之，如果中间的数字比要找的数字小，说明在右侧
            lIndex = midIndex + 1

    return arr[lIndex] == target
