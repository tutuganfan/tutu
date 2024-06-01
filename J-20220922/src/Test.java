import java.util.Stack;

/**
 * @Author 12629
 * @Description：
 */
public class Test {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        int x1 = myStack.pop();
        System.out.println(x1);
        x1 = myStack.pop();
        System.out.println(x1);
        x1 = myStack.pop();
        System.out.println(x1);

        int x2 = myStack.peek();
        System.out.println(x2);
        x2 = myStack.peek();
        System.out.println(x2);
    }


    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        //1、遍历tokens数组，判断当中的字符串的类型
        for(String x : tokens) {
            if(!isOperations(x)) {
                stack.push(Integer.parseInt(x));
            }else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch(x) {
                    case "+":
                        stack.push(num1+num2);
                        break;
                    case "-":
                        stack.push(num1-num2);
                        break;
                    case "*":
                        stack.push(num1*num2);
                        break;
                    case "/":
                        stack.push(num1/num2);
                        break;
                }
            }
        }
        return stack.pop();
    }
    private boolean isOperations(String s) {
        if(s.equals("+") || s.equals("-") ||s.equals("*") ||s.equals("/")) {
            return true;
        }
        return false;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length();i++) {
            char ch = s.charAt(i);
            //1. 判断是不是左括号
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }else {
                if(stack.empty()) {
                    //2. 遇到了右括号 但是栈为空，此时不匹配！
                    return false;
                }
                char ch2 = stack.peek();
                //3。 此时 如果满足 这里面的任何一个匹配逻辑 都是匹配的
                if(ch2 == '[' && ch == ']' || ch2 == '(' && ch == ')' || ch2 == '{' && ch == '}') {
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        //4. 当字符串遍历完成了，但是栈不为空，说明左括号还在栈当中没有匹配完成
        if(!stack.empty()) {
            return false;
        }
        return true;
    }

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;//遍历popA数组
        for(int  i = 0;i < pushA.length;i++) {
            stack.push(pushA[i]);
            while(j < popA.length && !stack.empty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
}
