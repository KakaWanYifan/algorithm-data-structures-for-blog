def process(w_arr, p_arr, index, rest, memory):
    key = str(index) + '-' + str(rest)
    if key in memory.keys():
        return memory[key]

    # 该投资不可行
    if rest < 0:
        memory[key] = -1
        return memory[key]
    # 没有更多投资项目
    if index == len(w_arr):
        memory[key] = 0
        return memory[key]

    # 投资该项目
    p1 = 0
    next = process(w_arr, p_arr, index + 1, rest - w_arr[index], memory)
    if next != -1:
        p1 = p_arr[index] + next

    # 不投资该项目
    p2 = process(w_arr, p_arr, index + 1, rest, memory)
    memory[key] = max(p1, p2)
    return memory[key]


if __name__ == '__main__':
    w = [9.0, 2.0, 2.0, 2.0, 2.0, 2.0]
    p = [10.0, 2.1, 2.1, 2.1, 2.1, 2.1]
    m = dict()
    print(process(w, p, 0, 10, m))
