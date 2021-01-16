def jump(n):
    """
    跳
    :param n:
    :return:
    """
    if n == 1:
        return 1
    if n == 2:
        return 2

    return jump(n - 1) + jump(n - 2)


if __name__ == '__main__':
    total = jump(6)
    print(total)
