def process(arr, index, rest):
    # 如果没有货币可选了
    if index == len(arr):
        # 恰好换完了，那么这也是一种方法，啥也不换
        # 否则，不是方法
        return 1 if rest == 0 else 0
    ways = 0
    zhang = 0
    while zhang * arr[index] <= rest:
        ways = ways + process(arr, index + 1, rest - (zhang * arr[index]))
        zhang = zhang + 1
    return ways


if __name__ == '__main__':
    a = [1, 2, 5, 10, 20, 50]
    total = 100
    print(process(a, 0, total))
