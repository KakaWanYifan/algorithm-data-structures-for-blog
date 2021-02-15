def func(n, froms, tos, other):
    if n == 1:
        print("Move 1 from " + froms + " to " + tos)
    else:
        func(n - 1, froms, other, tos)
        print("Move " + str(n) + " from " + froms + " to " + tos)
        func(n - 1, other, tos, froms)


if __name__ == '__main__':
    func(3, "left", "right", "mid")
