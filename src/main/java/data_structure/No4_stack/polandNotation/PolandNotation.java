package data_structure.No4_stack.polandNotation;

import java.util.Stack;

/**
 * create by 携山超 on 2020/6/27
 *
 * 逆波兰表达式计算器
 */
public class PolandNotation {
    public static void main(String[] args) {
        // 中缀表达式
        String infixExpression = "(3+4)*5-6";
        // 把中缀表达式切割开 (3+4)*5-6 ==> ( 3 + 4 ) * 5 - 6
        // 转化为逆波兰表达式（后缀表达式）
        //（3+4）*5-6 ==> 3 4 + 5 * 6 -
        String suffixExpression = "3 4 + 5 * 6 -";
        //
        int rtVal = calculate(suffixExpression.split(" "));
        System.out.println("运算结果是：" + rtVal);
    }

    public static int calculate(String[] array) {
        // 运算栈
        // 1. 遇到数字直接入栈
        // 2. 遇到运算符，取出栈顶的2个数字，运算后结果入栈
        Stack<String> stack = new Stack<>();
        for (String item : array) {
            if (item.matches("\\d+")) {
                // 数字
                stack.push(item);
            } else {
                // 运算符
                // 这里要注意的是，因为入栈时，前面的先入栈，所以取出来的a，b
                // 在表达式中位置b在a前面，此例中，a = 4， b = 3
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int rtVal = 0;
                switch (item) {
                    case "+": rtVal = a + b;
                        break;
                    case "-": rtVal = b - a;
                        break;
                    case "*": rtVal = a * b;
                        break;
                    case "/": rtVal = b / a;
                        break;
                    default: throw new RuntimeException("运算符不正确");
                }
                stack.push(String.valueOf(rtVal));
            }
        }
        return Integer.parseInt(stack.peek());
    }
}
