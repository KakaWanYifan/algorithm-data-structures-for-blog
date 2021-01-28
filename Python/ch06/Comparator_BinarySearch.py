import random

from ch06 import BinarySearchExist, BinarySearchFirstE, BinarySearchLastE, BinarySearchFirstGE, BinarySearchLastLE


def gen_random_arr(max_size, max_value):
    """
    生成一个随机的数组
    :param max_size: 生成的随机数组的最大长度
    :param max_value: 生成的随机数组的最大值
    :return: 生成的随机数组
    """
    arr_rnt = []
    random_size = random.randint(0, max_size)
    for i in range(random_size):
        arr_rnt.append(random.randint(0, max_value))

    return arr_rnt


def search_exist(arr, target):
    is_exist = False
    for iter in arr:
        if iter == target:
            is_exist = True
            break

    return is_exist


def search_first_e(arr, target):
    index = -1
    for i in range(len(arr)):
        if arr[i] == target:
            index = i
            break

    return index


def search_last_e(arr, target):
    index = -1
    get_equal = False
    for i in range(len(arr)):
        if arr[i] == target:
            get_equal = True

        if get_equal:
            if i == (len(arr) - 1):
                index = i
                break
            elif arr[i + 1] > target:
                index = i
                break
    return index


def search_first_ge(arr, target):
    index = -1
    for i in range(len(arr)):
        if arr[i] >= target:
            index = i
            break

    return index


def search_last_le(arr, target):
    index = -1
    for i in range(len(arr)):
        if arr[i] > target:
            index = i - 1
            break
        if i == (len(arr) - 1):
            index = i

    return index


if __name__ == '__main__':
    testTimes = 500000
    maxSize = 100
    maxValue = 100
    is_success = True
    for i in range(testTimes):
        arr = gen_random_arr(maxSize, maxValue)

        if arr is None or len(arr) < 1:
            continue

        arr.sort()
        target = random.randint(0, maxValue)

        aList = []
        a = search_exist(arr, target)
        aList.append(1 if a else 0)
        aList.append(search_first_e(arr, target))
        aList.append(search_last_e(arr, target))
        aList.append(search_first_ge(arr, target))
        aList.append(search_last_le(arr, target))

        bList = []
        b = BinarySearchExist.binarySearchExist(arr, target)
        bList.append(1 if b else 0)
        bList.append(BinarySearchFirstE.binarySearchFirstE(arr, target))
        bList.append(BinarySearchLastE.binarySearchLastE(arr, target))
        bList.append(BinarySearchFirstGE.binarySearchFirstGE(arr, target))
        bList.append(BinarySearchLastLE.binarySearchLastLE(arr, target))

        if aList != bList:
            print(arr)
            print(target)
            print(aList)
            print(bList)
            is_success = False
            break

    print(is_success)
