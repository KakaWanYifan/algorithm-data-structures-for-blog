from queue import Queue


def process(q):
    rnt = []
    if q.empty():
        rnt.append("")
        return rnt
    t = q.get()
    s_yes = t
    s_no = ""
    for s in process(q):
        rnt.append(s_yes + s)
        rnt.append(s_no + s)
    return rnt


if __name__ == '__main__':
    s = ['a', 'b', 'c']
    q = Queue()
    for c in s:
        q.put(c)
    ans = process(q)
    print(ans)
