def process(s, index, ans, path):
    if index == len(s):
        ans.append(path)
        return
    # 要了index位置的字符
    process(s, index + 1, ans, path + s[index])
    # 没有要index位置的字符
    process(s, index + 1, ans, path)


if __name__ == '__main__':
    s = ['a', 'b', 'c']
    path = ''
    ans = []
    process(s, 0, ans, path)
    print(ans)
