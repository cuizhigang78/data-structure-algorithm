package data_structure.No4_stack.simpleExpress;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.list();
        System.out.println("stack.pop() = " + stack.pop());
        stack.list();
    }
}
