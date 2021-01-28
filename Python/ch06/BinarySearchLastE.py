def binarySearchLastE(arr, target):
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
        if arr[midIndex] == target:
            index = midIndex
            lIndex = midIndex + 1
        elif arr[midIndex] > target:
            # 如果中间的数字比要找的数字大，说明在左侧。
            rIndex = midIndex - 1
        else:
            # 反之，如果中间的数字比要找的数字小，说明在右侧
            lIndex = midIndex + 1

    return index


if __name__ == '__main__':
    a = [2, 3, 5, 9, 9, 10, 10, 10, 10, 11, 11, 13, 14, 16, 18, 21, 25, 27, 27, 31, 35, 36, 37, 37, 38, 39, 39, 39,
         39, 39, 41, 42, 42, 42, 43, 44, 44, 45, 45, 48, 48, 48, 48, 49, 49, 51, 53, 53, 54, 55, 56, 56, 56, 57, 59,
         60, 60, 62, 62, 67, 67, 67, 72, 77, 77, 78, 82, 83, 84, 86, 88, 94, 94, 95, 98, 98, 99]
    a.sort()
    print(a)
    t = 37
    print(binarySearchLastE(a, t))
