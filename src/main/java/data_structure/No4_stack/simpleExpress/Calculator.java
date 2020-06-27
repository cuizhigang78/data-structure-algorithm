package data_structure.No4_stack.simpleExpress;

/**
 * 表达式计算器
 *
 * 使用栈完成表达式计算思路
 * 1. 通过一个index值（索引）来遍历表达式；
 * 2. 如果是数字，就直接入数栈；
 * 3. 如果是符号，则分以下情况：
 *   3.1 当前符号栈为空，就直接入栈。
 *   3.2 当前符号栈不为空，又分以下两种情况：
 *     3.2.1 当前操作符的优先级小于等于栈中的操作符，就需要从数栈和符号栈中分别pop出
 *   两个数和一个符号，进行运算，运行结果压入数栈，再将当前操作符压入符号栈。
 *     3.2.2 当前操作符的优先级大于栈中的操作符，直接将当前符号入栈。
 * 4. 当表达式扫描完毕，就顺序地从数栈和符号栈中pop数字和符号，运算后再结果压入数栈。
 * 5. 最后在数栈中只有一个数字，就是表达式的结果。
 */
public class Calculator {
    public static void main(String[] args) {
        // 要计算的表达式 13
        //String express = "7*2*2-5+1-5+3-4";
        String express = "1-2*1+3";
        // 数栈
        ArrayStack numStack = new ArrayStack(10);
        // 符号栈
        ArrayStack operateStack = new ArrayStack(10);
        // 处理多位数运算
        String keepNum = "";

        for (int i = 0; i < express.length(); i++) {
            char c = express.substring(i, i + 1).charAt(0);
            if (isOperate(c)) {
                //3.1 当前符号栈为空，就直接入栈。
                if (operateStack.isEmpty()) {
                    operateStack.push(c);
                } else {
                    if (priority(c) <= priority(operateStack.peek())) {
                        // 3.2.1 当前操作符的优先级小于等于栈中的操作符，就需要从数栈和符号栈中分别pop出
                        // 两个数和一个符号，进行运算，运行结果压入数栈，再将当前操作符压入符号栈。
                        int m = numStack.pop();
                        int n = numStack.pop();
                        int o = operateStack.pop();
                        int rtVal = calculate(n, m, o);
                        numStack.push(rtVal);
                        operateStack.push(c);
                    } else {
                        //3.2.2 当前操作符的优先级小于栈中的操作符，直接将当前符号入栈。
                        operateStack.push(c);
                    }
                }
            } else {
                // 2. 如果是数字，就直接入数栈；
                // 处理多位数运算
                keepNum += c;
                if (i == express.length() - 1) {
                    // 如果已经是最后一位，不必判断
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    // 判断下一个字符是不是数字，如果是数字，就继续扫描，如果不是，直接入数栈
                    if (isOperate(express.substring(i + 1, i + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
        }

        while (!operateStack.isEmpty()) {
            int o = operateStack.pop();
            int m = numStack.pop();
            int n = numStack.pop();
            numStack.push(calculate(n, m, o));
        }
        System.out.println(express + "=" + numStack.pop());
    }

    // 判断运算符的优先级
    public static int priority(int c) {
        if (c == '*' || c == '/') {
            return 1;
        } else if (c == '+' || c == '-') {
            return 0;
        } else {
            return -1;
        }
    }
    // 运算
    public static int calculate(int m, int n, int c) {
        int rtValue;
        switch (c) {
            case '+':
                rtValue = m + n;
                break;
            case '-':
                // 注意顺序
                rtValue = n - m;
                break;
            case '*':
                rtValue = m * n;
                break;
            case '/':
                // 注意顺序
                rtValue = n / m;
                break;
            default:
                rtValue = 0;
                break;
        }
        return rtValue;
    }

    // 判断是否运算符
    public static boolean isOperate(int c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}