def process(s, ans, path):
    if len(s) == 0:
        ans.append(path)
        return
    for i in range(len(s)):
        temp = s.copy()
        temp.pop(i)
        process(temp, ans, path + s[i])


if __name__ == '__main__':
    l = ['甲', '乙', '丙']
    ans = []
    path = ""
    process(l, ans, path)
    print(ans)
