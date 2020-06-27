package data_structure.No2_queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(4);
        // 接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):展示队列");
            System.out.println("a(add):添加数据");
            System.out.println("g(get):取出数据");
            System.out.println("h(head):展示头数据");
            System.out.println("e(exit):退出程序");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int rtVal = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", rtVal);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int rtVal = queue.headQueue();
                        System.out.printf("头数据是%d\n", rtVal);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~~");
    }
}

// 数据模拟环形队列
class CircleArrayQueue {
    // 表示数组的最大容量
    private int maxSize;
    // 指向队列头部
    private int front;
    // 指向队列尾部的后一个位置
    private int rear;
    // 存储数据的数组
    private int[] array;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        front = 0;
        rear = 0;
    }

    // 判断队列是否已满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，不能加入数据~");
            return;
        }
        array[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    // 从队列中取出数据
    public int getQueue() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("队列空，无数据可取");
        }
        int rtVal = array[front];
        front = (front + 1) % maxSize;
        return rtVal;
    }

    // 当前队列的有效数据个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空，无数据");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("array[%d]=%d\n", i % maxSize, array[i % maxSize]);
        }
    }

    // 显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，无数据");
        }
        return array[front];
    }
}
