arr = [1, 2, 5, 10, 20, 50]
total = 100
dp = [[0] * (total + 1) for i in range(len(arr) + 1)]
dp[len(arr)][0] = 1
for index in range(len(arr) - 1, -1, -1):
    for rest in range(0, total + 1, 1):
        # a
        dp[index][rest] = dp[index + 1][rest]
        if rest - arr[index] >= 0:
            # 问号 = a + 星号
            dp[index][rest] = dp[index][rest] + dp[index][rest-arr[index]]

print(dp[0][total])
