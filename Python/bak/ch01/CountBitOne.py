def countBitOne(n):
    """
    统计二进制中一的个数
    :param n: 给定的一个数
    :return: 给定的数，转换成二进制之后，一的个数
    """
    count = 0
    while n != 0:
        rightOne = n & ((~n) + 1)
        count = count + 1
        n = n ^ rightOne
    return count


if __name__ == '__main__':
    print(countBitOne(0))
    print(countBitOne(1))
    print(countBitOne(2))
    print(countBitOne(3))
