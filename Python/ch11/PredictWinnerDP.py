def predict_winner(arr):
    dp = [[None] * (len(arr) + 1) for i in range(len(arr) + 1)]
    for i in range(len(a)):
        dp[i][i] = arr[i]
    for i in range(len(arr) - 1, -1, -1):
        for j in range(i + 1, len(arr), 1):
            dp[i][j] = max(arr[i] - dp[i + 1][j], arr[j] - dp[i][j - 1])

    return dp[0][len(arr) - 1]


if __name__ == '__main__':
    a = [1, 5, 8, 6]
    if predict_winner(a) >= 0:
        print("玩家一获胜")
    else:
        print("玩家二获胜")

    a = [7, 13, 1, 5]
    if predict_winner(a) >= 0:
        print("玩家一获胜")
    else:
        print("玩家二获胜")

    a = [1, 13, 1]
    if predict_winner(a) >= 0:
        print("玩家一获胜")
    else:
        print("玩家二获胜")
