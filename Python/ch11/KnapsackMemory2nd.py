def process(w_arr, p_arr, index, rest, memory):
    # 该投资不可行
    if rest < 0:
        return -1
    if memory[index][rest] is not None:
        return memory[index][rest]
    # 没有更多投资项目
    if index == len(w_arr):
        memory[index][rest] = 0
        return memory[index][rest]

    # 投资该项目
    p1 = 0
    next = process(w_arr, p_arr, index + 1, rest - w_arr[index], memory)
    if next != -1:
        p1 = p_arr[index] + next

    # 不投资该项目
    p2 = process(w_arr, p_arr, index + 1, rest, memory)
    memory[index][rest] = max(p1, p2)
    return memory[index][rest]


if __name__ == '__main__':
    w = [9.0, 2.0, 2.0, 2.0, 2.0, 2.0]
    p = [10.0, 2.1, 2.1, 2.1, 2.1, 2.1]
    w_10 = [int(i * 10) for i in w]
    p_10 = [int(i * 10) for i in p]
    rest = 10 * 10
    m = [[None] * (rest + 1) for i in range(len(w_10) + 1)]
    print(process(w_10, p_10, 0, rest, m)/10.0)
