import random
import SelectionSort


def knownFunc(arr_args):
    """
    已经知道的方法
    :param arr_args: 需要排序的数组
    :return: 排序好的数组
    """
    list.sort(arr_args)
    return arr_args


def genRandomArr(max_size, max_value):
    """
    生成一个随机的数组
    :param max_size: 生成的随机数组的最大长度
    :param max_value: 生成的随机数组的最大值
    :return: 生成的随机数组
    """
    arr_rnt = []
    randomSize = random.randint(0, max_size)
    for i in range(randomSize):
        arr_rnt.append(random.randint(0, max_value))

    return arr_rnt


if __name__ == '__main__':
    testTimes = 5000
    maxSize = 100
    maxValue = 100
    isSuccess = True

    for i in range(testTimes):
        arr1 = genRandomArr(maxSize, maxValue)
        arr2 = arr1.copy()
        arr1 = knownFunc(arr1)
        arr2 = SelectionSort.selectionSort(arr2)
        if arr1 != arr2:
            isSuccess = False
            break

    print(isSuccess)
