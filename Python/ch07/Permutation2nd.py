def process(s, ans, path):
    if len(s) == 0:
        ans.append(path)
        return
    # 假设就甲乙丙三人
    visit = dict()
    visit['甲'] = False
    visit['乙'] = False
    visit['丙'] = False

    for i in range(len(s)):
        # 如果没有出现过
        if not visit[s[i]]:
            visit[s[i]] = True
            temp = s.copy()
            temp.pop(i)
            process(temp, ans, path + s[i])


if __name__ == '__main__':
    l = ['甲', '甲', '乙']
    ans = []
    path = ""
    process(l, ans, path)
    print(ans)
