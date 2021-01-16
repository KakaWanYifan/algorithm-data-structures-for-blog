package ch03;

/**
 * 顺序栈
 */
public class ArrayStack {

    // 用来存储容器中的元素
    private int[] array;
    // 容器中元素的个数
    private int size;

    /**
     * 构造方法
     * @param capacity 初始化大小
     */
    public ArrayStack(int capacity) {
        this.array = new int[capacity];
        size = 0;
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
     * 入栈
     * @param data
     */
    public void push(int data){
        //如果实际元素达到数组容量上线，数组扩容
        if(size >= array.length){
            resize();
        }
        array[size] = data;
        size++;
    }

    /**
     * 出栈
     */
    public Integer pop(){
        if (size <= 0){
            return null;
        }
        int index = size - 1;
        int rnt = array[index];
        size--;
        return rnt;
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

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        System.out.println(arrayStack.pop());
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.output();
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.push(6);
        arrayStack.output();
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        arrayStack.output();
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
    }

}
