def onlyTwoOddTimesNum(arr):
    """
    唯二的奇数次的数字
    :param arr:
    :return: 唯二的奇数次的数字
    """
    eor = 0
    for i in arr:
        eor = eor ^ i
    # eor != 0
    # eor 必定有一个位置是 1
    # 提取出最右侧的 1
    rightOne = eor & (~eor + 1)
    # eor'
    eor2nd = 0
    for i in arr:
        # 如果iter与运算rightOne之后不等于0，说明与right在同一个地方有1
        if (i & rightOne) != 0:
            eor2nd = eor2nd ^ i

    rnt = [eor2nd, (eor ^ eor2nd)]
    return rnt


if __name__ == '__main__':
    a = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 9, 8, 7, 6, 5, 4, 3, 2]
    r = onlyTwoOddTimesNum(a)
    print(r)
