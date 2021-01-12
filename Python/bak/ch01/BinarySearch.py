def binarySearchExist(sorted_arr, num):
    """
    二分法查找是否存在
    :param sorted_arr: 已经排序好的数组
    :param num: 查找的数
    :return: 返回是否存在
    """
    # 最左边数字的index
    l_index = 0
    # 最右边数字的index
    r_index = len(sorted_arr) - 1
    # 中间数字的index
    mid_index = 0
    while l_index != r_index:
        # 中间的index
        # 不写作 (lIndex + rIndex) / 2 的原因是这样不容易溢出
        mid_index = l_index + (r_index - l_index) // 2
        if sorted_arr[mid_index] == num:
            # 如果中间的数字就是要找的数字
            return True
        elif sorted_arr[mid_index] > num:
            # 如果中间的数字比要找的数字大，说明在左侧。
            r_index = mid_index - 1
        else:
            # 反之，如果中间的数字比要找的数字小，说明在右侧
            l_index = mid_index + 1

    return sorted_arr[l_index] == num


if __name__ == '__main__':
    arr = [2, 3, 4, 5, 15, 19, 26, 27, 36, 38, 44, 46, 47, 48, 50]
    num = 18
    print(binarySearchExist(arr, num))
