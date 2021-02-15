w = [9.0, 2.0, 2.0, 2.0, 2.0, 2.0]
p = [10.0, 2.1, 2.1, 2.1, 2.1, 2.1]
w_10 = [int(i * 10) for i in w]
p_10 = [int(i * 10) for i in p]
rest = 10 * 10
dp = [[0] * (rest + 1) for i in range(len(w_10) + 1)]

for index in range(len(w_10) - 1, -1, -1):
    for r in range(0, rest + 1, 1):
        p1 = dp[index + 1][r]
        p2 = 0
        next = -1 if r - w_10[index] < 0 else dp[index + 1][r - w_10[index]]
        if next != -1:
            p2 = p_10[index] + next

        dp[index][r] = max(p1, p2)

print(dp[0][rest] / 10.0)
