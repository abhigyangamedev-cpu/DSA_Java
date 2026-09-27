package Stacks.StandardQuestions;

import java.util.Stack;

public class validParenthesis {
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (curr == '(' || curr == '[' || curr == '{') {
                stack.push(curr);
            }
            else if (stack.isEmpty()) {
                return false;
            }
            else {
                Character top = stack.peek();

                if ((top == '[' && curr == ']') ||
                        (top == '{' && curr == '}') ||
                        (top == '(' && curr == ')')) {

                    stack.pop();

                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main() {
        System.out.println(isValid("({[]})"));
    }
}
