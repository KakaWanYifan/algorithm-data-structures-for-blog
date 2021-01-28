def binarySearchFirstGE(arr, target):
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
        if arr[midIndex] >= target:
            index = midIndex
            rIndex = midIndex - 1
        else:
            # 反之，如果中间的数字比要找的数字小，说明在右侧
            lIndex = midIndex + 1

    return index


if __name__ == '__main__':
    a = [0, 1, 1, 4, 4, 8, 8, 9, 9, 9, 10, 11, 12, 15, 18, 19, 19, 19, 21, 22, 29, 30, 30, 30, 31, 31, 33, 33, 33, 35,
         36, 37, 38, 38, 39, 39, 40, 40, 41, 43, 43, 44, 46, 46, 47, 48, 49, 49, 49, 52, 52, 52, 53, 57, 59, 63, 65, 66,
         68, 70, 70, 71, 71, 72, 72, 73, 74, 78, 78, 80, 82, 83, 83, 84, 84, 86, 86, 86, 86, 86, 89, 89, 90, 91, 92, 93,
         94, 94, 95, 96, 97, 97, 98]
    a.sort()
    print(a)
    t = 72
    print(binarySearchFirstGE(a, t))
