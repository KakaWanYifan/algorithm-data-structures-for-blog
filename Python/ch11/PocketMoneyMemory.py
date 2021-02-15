def process(arr, index, rest, memory):
    # 如果算过
    if memory[index][rest] is not None:
        return memory[index][rest]
    # 如果没有货币可选了
    if index == len(arr):
        # 恰好换完了，那么这也是一种方法，啥也不换
        # 否则，不是方法

        # 记住
        memory[index][rest] = 1 if rest == 0 else 0
        return memory[index][rest]
    ways = 0
    zhang = 0
    while zhang * arr[index] <= rest:
        ways = ways + process(arr, index + 1, rest - (zhang * arr[index]), memory)
        zhang = zhang + 1

    memory[index][rest] = ways
    return memory[index][rest]


if __name__ == '__main__':
    a = [1, 2, 5, 10, 20, 50]
    total = 100
    # 记忆
    # None 代表没有记忆
    # 一开始没有记忆
    memory = [[None] * (total + 1) for i in range(len(a) + 1)]
    print(process(a, 0, total, memory))
