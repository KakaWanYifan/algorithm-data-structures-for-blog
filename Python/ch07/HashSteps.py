hash_steps = {}


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
    if hash_steps.__contains__(n):
        return hash_steps[n]

    res = jump(n - 1) + jump(n - 2)
    hash_steps[n] = res
    return res


if __name__ == '__main__':
    total = jump(6)
    print(total)
