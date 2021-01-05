def onlyOneOddTimesNum(arr):
    """
    唯一的奇数次的数字
    :param arr:
    :return: 唯一的奇数次的数字
    """
    eor = 0
    for i in arr:
        eor = eor ^ i
    return eor


if __name__ == '__main__':
    a = [1, 1, 1, 1, 1, 2, 1]
    print(onlyOneOddTimesNum(a))
