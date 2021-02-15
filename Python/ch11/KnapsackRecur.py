def process(w_arr, p_arr, index, rest):
    # 该投资不可行
    if rest < 0:
        return -1
    # 没有更多投资项目
    if index == len(w_arr):
        return 0

    # 投资该项目
    p1 = 0
    next = process(w_arr, p_arr, index + 1, rest - w_arr[index])
    if next != -1:
        p1 = p_arr[index] + next

    # 不投资该项目
    p2 = process(w_arr, p_arr, index + 1, rest)
    return max(p1, p2)


if __name__ == '__main__':
    w_arr = [9.0, 2.0, 2.0, 2.0, 2.0, 2.0]
    p_arr = [10.0, 2.1, 2.1, 2.1, 2.1, 2.1]
    print(process(w_arr, p_arr, 0, 10))
