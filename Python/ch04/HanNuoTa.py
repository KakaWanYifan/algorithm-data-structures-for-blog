# 请把1~N层圆盘 从左 -> 右
def left_to_right(n):
    if n == 1:
        print("Move 1 from left to right")
        return
    left_to_mid(n - 1)
    print("Move " + str(n) + " from left to right")
    mid_to_right(n - 1)


# 请把1~N层圆盘 从左 -> 中
def left_to_mid(n):
    if n == 1:
        print("Move 1 from left to mid")
        return
    left_to_right(n - 1)
    print("Move " + str(n) + " from left to mid")
    right_to_mid(n - 1)


def right_to_mid(n):
    if n == 1:
        print("Move 1 from right to mid")
        return
    right_to_left(n - 1)
    print("Move " + str(n) + " from right to mid")
    left_to_mid(n - 1)


def mid_to_right(n):
    if n == 1:
        print("Move 1 from mid to right")
        return
    mid_to_left(n - 1)
    print("Move " + str(n) + " from mid to right")
    left_to_right(n - 1)


def mid_to_left(n):
    if n == 1:
        print("Move 1 from mid to left")
        return
    mid_to_right(n - 1)
    print("Move " + str(n) + " from mid to left")
    right_to_left(n - 1)


def right_to_left(n):
    if n == 1:
        print("Move 1 from right to left")
        return
    right_to_mid(n - 1)
    print("Move " + str(n) + " from right to left")
    mid_to_left(n - 1)


if __name__ == '__main__':
    left_to_right(3)
