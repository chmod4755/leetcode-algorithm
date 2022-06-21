package top.lighten.nowcoder;

import java.util.Stack;

public class Question {
    public static boolean isLegal(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pair = stack.pop();
                if (c == ')' && pair != '(') {
                    return false;
                }
                if (c == '}' && pair != '{') {
                    return false;
                }
                if (c == ']' && pair != '[') {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean result = isLegal("{()}{()[]}");
        System.out.println(result);
    }
}
