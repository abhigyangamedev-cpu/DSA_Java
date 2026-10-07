package TwoPointers.Strings.Easy.NeetCode;

public class ReverseWordsInAStringIII {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word).reverse();
            result.append(reversedWord).append(" ");
        }
        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }

    public static void main(String[] args){
        System.out.print(reverseWords("Let's take LeetCode contest"));
    }
}
