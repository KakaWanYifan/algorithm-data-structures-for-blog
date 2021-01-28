import random


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


def isEqual(a,b):
    for i in  range(len(a)):
        if a[i] != b[i]:
            return False

    return True


def searchExist(arr,target):
    isExist = False
    for iter in arr:
        if iter == target:
            isExist = True
            break

    return isExist


def searchFirstE(arr,target):
    index = -1
    for i in range(len(arr)):
        if arr[i] == target:
            index = i
            break;

    return index

def searchLastE(arr,target):
    index = -1;
    getEqual = false;
    for i in range(len(arr)):
        if arr[i]  == target:
            getEqual = true

        if getEqual == true){
                if (i == arr.length - 1){
                    index = i;
                    break;
                }else{
                    if (arr[i + 1] > target){
                        index = i;
                        break;
                    }
                }
            }
        }
        return index;
    }

    public static int searchFirstGE(int[] arr,int target){
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]  >= target){
                index = i;
                break;
            }
        }
        return index;
    }

    public static int searchLastLE(int[] arr,int target){
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]  > target){
                index = i-1;
                break;
            }
            if (i == arr.length - 1){
                index = i;
            }
        }
        return index;
    }





if __name__ == '__main__':
    testTimes = 5000
    maxSize = 100
    maxValue = 100
    isSuccess = True

    for i in range(testTimes):
        arr1 = genRandomArr(maxSize, maxValue)
        arr2 = arr1.copy()
        arr1 = knownFunc(arr1)
        arr2 = InsertionSort.insertionSort(arr2)
        if arr1 != arr2:
            isSuccess = False
            break

    print(isSuccess)
