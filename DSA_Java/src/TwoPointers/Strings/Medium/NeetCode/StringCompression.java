package TwoPointers.Strings.Medium.NeetCode;

public class StringCompression {
    public static int compress(char[] chars) {
        int ans = 0;

        for (int i = 0; i < chars.length;) {
            char letter = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == letter) {
                count++;
                i++;
            }

            chars[ans++] = letter;

            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[ans++] = c;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args){
        char[] arr = {'a','a','b','b','c','c','c'};

        System.out.print(compress(arr));
    }
}
