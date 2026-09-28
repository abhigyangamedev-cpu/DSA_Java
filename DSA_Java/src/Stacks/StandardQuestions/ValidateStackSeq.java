package Stacks.StandardQuestions;

import java.util.Stack;

public class ValidateStackSeq {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length ==1) {
            return pushed[0] == popped[0];
        }

        int popIndex = 0;
        Stack<Integer> st = new Stack<>();

        //Enhanced for - loop
        for (int ele:pushed) {
            st.push(ele);

            while(!st.isEmpty() && st.peek() == popped[popIndex]) {
                st.pop();
                popIndex++;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        System.out.println(validateStackSequences(pushed, popped));

    }

}