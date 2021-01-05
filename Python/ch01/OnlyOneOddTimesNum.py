def onlyOneOddTimesNum(arr):
    eor = 0
    for i in arr:
        eor = eor ^ i
    return eor


if __name__ == '__main__':
    a = [1, 1, 1, 1, 1, 2, 1]
    print(onlyOneOddTimesNum(a))
