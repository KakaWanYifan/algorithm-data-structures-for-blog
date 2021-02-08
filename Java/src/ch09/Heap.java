package ch09;

public class Heap {

    // 数组,从下标1开始存储数据
    private int[] a;
    // 堆可以存储的最大数据个数
    private int capacity;
    // 堆中已经存储的数据个数
    private int count;

    public Heap(int c) {
        // 0位置不放内容
        a = new int[c + 1];
        capacity = c;
        count = 0;
    }

    public void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void find(int data){
        for (int i = 1; i < a.length; i++) {
            if (a[i] == data){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    public boolean insert(int data) {
        // 堆满了
        if (count >= capacity)
            return false;
        count = count+1;
        a[count] = data;
        int i = count;
        // i/2 > 0 ：说明有父节点
        // a[i] > a[i/2] ：说明该节点比父节点还大
        while (i/2 > 0 && a[i] > a[i/2])
        {
            // swap()函数作用:交换下标为i和i/2的两个元素
            swap(a, i, i/2);
            i = i/2;
        }
        return true;
    }

    public boolean remove(int data){
        // 堆中没有数据
        if (count == 0)
            return false;
        int index = -1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == data){
                index = i;
                break;
            }
        }
        // 没有要删除的数据
        if (index == -1){
            return false;
        }
        // 换位置
        a[index] = a[count];
        count = count-1;

        while (true) {
            // 最大值的位置
            int maxPos = index;
            // 判断左子节点
            // 如果有左子节点，且小于左子节点
            if (index*2 <= count && a[maxPos] < a[index*2])
                // 左子节点作为最大的位置
                maxPos = index*2;
            // 判断右子节点
            // 如果有右子节点，且最大位置的节点小于右子节点
            if (index*2+1 <= count && a[maxPos] < a[index*2+1])
                // 那么，右子节点的作为最大的位置
                maxPos = index*2+1;
            // 如果左右节点都比较过了，index就是最大位置，那么说明完成。
            if (maxPos == index)
                break;
            // 互换
            swap(a, index, maxPos);
            // 迭代
            index = maxPos;
        }
        return true;
    }

    public void print(){
        String rnt = "";
        for (int i = 1; i <= count; i++) {
            rnt = rnt + a[i] + ",";
        }
        if (rnt.length() > 1){
            rnt = rnt.substring(0,rnt.length() -1);
        }
        System.out.println(rnt);
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(9);
        heap.insert(8);
        heap.insert(7);
        heap.insert(6);
        heap.insert(4);
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);
        heap.insert(0);
        heap.print();

        heap.insert(5);
        heap.print();

        heap.remove(10);
        heap.print();

        heap.find(3);

        heap.remove(3);
        heap.print();

        heap.find(3);
    }
}
