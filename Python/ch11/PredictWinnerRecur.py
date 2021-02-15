def predict_winner(arr, l, r):
    if l == r:
        return arr[l]
    return max(arr[l] - predict_winner(arr, l + 1, r), arr[r] - predict_winner(arr, l, r - 1));


if __name__ == '__main__':
    a = [1, 5, 8, 6]
    if predict_winner(a, 0, len(a) - 1) >= 0:
        print("玩家一获胜")
    else:
        print("玩家二获胜")

    a = [7, 13, 1, 5]
    if predict_winner(a, 0, len(a) - 1) >= 0:
        print("玩家一获胜")
    else:
        print("玩家二获胜")

    a = [1, 13, 1]
    if predict_winner(a, 0, len(a) - 1) >= 0:
        print("玩家一获胜")
    else:
        print("玩家二获胜")
