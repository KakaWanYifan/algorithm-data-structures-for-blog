arr = [1, 2, 5, 10, 20, 50]
total = 100
dp = [[0] * (total + 1) for i in range(len(arr) + 1)]
# 根据之前的递归代码，我们知道"dp[arr.length][0] = 1"
# if (index == arr.length){
#     return rest == 0 ? 1:0;
# }
dp[len(arr)][0] = 1
# 根据我们的递推代码
# ways = ways + process(arr,index+1,rest-(zhang*arr[index]),memory);
# 所以，我们可以通过第N行，推出第N-1行；通过第N-1行，推出第N-2行。
# arr.length行在上一步已经填好了
for index in range(len(arr) - 1, -1, -1):
    for rest in range(0, total + 1, 1):
        # 把dp[index][rest]填好
        ways = 0
        zhang = 0
        while zhang * arr[index] <= rest:
            ways = ways + dp[index + 1][rest - (zhang * arr[index])]
            zhang = zhang + 1
            dp[index][rest] = ways

print(dp[0][total])
