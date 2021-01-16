package ch02;

/**
 * 我的数组容器
 */
public class MyArrayList {

    // 用来存储容器中的元素
    private int[] array;
    // 容器中元素的个数
    private int size;

    /**
     * 构造方法
     * @param capacity 初始化大小
     */
    public MyArrayList(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * 在制定位置新增元素
     * @param index 制定的位置
     * @param element 元素
     * @throws Exception 数组越界异常
     */
    public void add(int index, int element) throws Exception {

        //判断访问下标是否超出范围
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }

        //如果实际元素达到数组容量上线，数组扩容
        if(size >= array.length){
            resize();
        }

        //从右向左循环，逐个元素向右挪一位。
        for(int i=size-1; i>=index; i--){
            array[i+1] = array[i];
        }

        //腾出的位置放入新元素
        array[index] = element;

        size++;
    }

    /**
     * 在最近的一个空位添加元素
     * @param element 元素
     * @throws Exception
     */
    public void add(int element){
        //如果实际元素达到数组容量上线，数组扩容
        if(size >= array.length){
            resize();
        }

        //腾出的位置放入新元素
        array[size] = element;

        size++;
    }

    /**
     * 数组扩容
     */
    public void resize(){
        // 扩大到原来大小的两倍
        int[] arrayNew = new int[array.length*2];
        //从旧数组拷贝到新数组
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        array = arrayNew;
    }

    /**
     * 在指定位置删除元素
     * @param index 制定位置
     * @return 被删除的元素
     * @throws Exception
     */
    public int remove(int index) throws Exception {
        //判断访问下标是否超出范围
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }

        int deletedElement = array[index];
        //从左向右循环，逐个元素向左挪一位。
        for(int i=index; i<(size-1); i++){
            array[i] = array[i+1];
        }
        size--;

        return deletedElement;
    }



    /**
     * 输出数组
     */
    public void output(){
        String rnt = "";
        for (int i = 0; i < size; i++) {
            rnt = rnt + array[i] + " ";
        }
        System.out.println(rnt);
    }

    public static void main(String[] args) throws Exception {
        MyArrayList myArrayList = new MyArrayList(3);
        myArrayList.add(0,1);
        myArrayList.add(1,2);
        myArrayList.add(2,3);
        myArrayList.output();
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.output();
        myArrayList.remove(1);
        myArrayList.remove(1);
        myArrayList.remove(1);
        myArrayList.output();
    }
}