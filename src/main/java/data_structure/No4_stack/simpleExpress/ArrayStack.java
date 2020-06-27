package data_structure.No4_stack.simpleExpress;

/**
 * 用数组来实现栈
 */
public class ArrayStack {

    // 栈的大小
    private int maxSize;
    // 数组，本栈的底层数据结构
    private int[] array;
    // 栈顶，初始值为-1
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈
    public void push(int i) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        array[++top] = i;
    }

    // 出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return array[top--];
    }
    // 展示top
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return array[top];
    }
    // 遍历栈
    public void list() {
        for (int i = top; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }
}
