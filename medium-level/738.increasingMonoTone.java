class Solution {
    public static int monotoneIncreasingDigits(int N) {
        if (N < 10) return N;

        char[] chars = String.valueOf(N).toCharArray();

        int i = 0;
        while (i+1 < chars.length && chars[i] <= chars[i+1]) {
            i++;
        }
        if (i == chars.length-1) return N; 
        while (i-1 >= 0 && chars[i-1] == chars[i]) {
            i--;
        }
        chars[i] = (char) (chars[i]- 1);
        i++;
        while (i < chars.length) {
            chars[i] = '9';
            i++;
        }

        return Integer.parseInt(String.valueOf(chars));
    }
}