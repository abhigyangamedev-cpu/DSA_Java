package Stacks.StandardQuestions;

import java.util.Stack;

public class CheckIfWordIsValidAfterSubstitutions {
    public static boolean isValid(String s) {
        if (s.length() % 3 != 0) {
            return false;
        }

        Stack<Character> st = new Stack<>();

        //Enhanced for - loop
        for(char ch: s.toCharArray()) {
            if(ch == 'c') {
                if(st.size() >=2 && st.pop()=='b' && st.pop()=='a') {
                    continue; //do nothing;
                } else {
                    return false;
                }
            } else {
                //Push for a and b elements
                st.push(ch);
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("ababccabcabc"));

    }
}
