package TwoPointers.Easy.NeetCode;

public class ReverseString {
    public static void printArrayForLoop(char[] a){
        for(int i = 0; i < a.length; i++){
            System.out.println("Printing Array using for loop element number with index "+ + i +" = " +a[i]);
        }
    }

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }

    }

    public static void main(String[] args){
        char[] s = {'h','e','l','l','o'};
        reverseString(s);

        printArrayForLoop(s);
    }
}
