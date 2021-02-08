def heap_sort(arr):
    if len(arr) <= 1:
        return arr

    # 1、建堆
    arr = buildHeap(arr)

    # 2、排序
    k = len(arr)- 1
    while k > 0:
        # 将堆顶元素（最大）与最后一个元素交换位置
        arr[0],arr[k] = arr[k],arr[0]
        # 将剩下元素重新堆化，堆顶元素变成最大元素
        heapify(arr, --k, 0);

def buildHeap(arr):
    # (arr.length - 1) / 2为最后一个叶子节点的父节点
    # 也就是最后一个非叶子节点，依次堆化直到根节点
    for i in range(len(arr) - 1,0,-1):
        heapify(arr, len(arr) - 1, i)

def
/ **
*堆化
 *
 * @ param
arr
要堆化的数组
* @ param
n
最后堆元素下标
* @ param
i
要堆化的元素下标
* /
private
static
void
heapify(int[]
arr, int
n, int
i) {
while (true) {
// 最大值位置
int maxPos = i;
// 与左子节点（i * 2 + 1）比较，获取最大值位置
if (i * 2 + 1 <= n & & arr[i] < arr[i * 2 + 1]) {
maxPos = i * 2 + 1;
}
// 最大值与右子节点（i * 2 + 2）比较，获取最大值位置
if (i * 2 + 2 <= n & & arr[maxPos] < arr[i * 2 + 2]) {
maxPos = i * 2 + 2;
}
// 最大值是当前位置结束循环
if (maxPos == i) {
break;
}
// 与子节点交换位置
swap(arr, i, maxPos);
// 以交换后子节点位置接着往下查找
i = maxPos;
}
}


public
static
void
main(String[]
args) {
    int[]
arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
System.out.println(Arrays.toString(arr));
// 只有数组不为空，并且数组的长度大于1，这时候的排序才有意义
if (null != arr & & arr.length > 1)
{
    sort(arr);
}
System.out.println(Arrays.toString(arr));
}