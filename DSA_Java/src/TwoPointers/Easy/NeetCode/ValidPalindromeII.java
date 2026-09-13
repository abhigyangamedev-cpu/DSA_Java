package TwoPointers.Easy.NeetCode;

public class ValidPalindromeII {
    private static boolean isPalindrome(String s, int start, int end) {

        while (start < end) {

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static boolean validPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {

            if (s.charAt(start) != s.charAt(end)) {

                return isPalindrome(s, start + 1, end) ||
                        isPalindrome(s, start, end - 1);
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args){
        String s = "abca";

        System.out.println("Is a palindrome :- " + validPalindrome(s));
    }

}
