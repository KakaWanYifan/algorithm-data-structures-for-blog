def predict_winner(arr, l, r, memory):
    if memory[l][r] is not None:
        return memory[l][r]
    if l == r:
        memory[l][r] = arr[l]
        return memory[l][r]
    a = 0
    if memory[l + 1][r] is not None:
        a = memory[l + 1][r]
    else:
        a = predict_winner(arr, l + 1, r,memory)

    b = 0
    if memory[l][r - 1] is not None:
        b = memory[l][r - 1]
    else:
        b = predict_winner(arr, l, r - 1,memory)

    return max(arr[l] - a, arr[r] - b)


if __name__ == '__main__':
    a = [1, 5, 8, 6]
    m = [[None] * (len(a) + 1) for i in range(len(a) + 1)]
    if predict_winner(a, 0, len(a) - 1, m) >= 0:
        print("玩家一获胜")
    else:
        print("玩家二获胜")

    a = [7, 13, 1, 5]
    if predict_winner(a, 0, len(a) - 1, m) >= 0:
        print("玩家一获胜")
    else:
        print("玩家二获胜")

    a = [1, 13, 1]
    if predict_winner(a, 0, len(a) - 1, m) >= 0:
        print("玩家一获胜")
    else:
        print("玩家二获胜")
