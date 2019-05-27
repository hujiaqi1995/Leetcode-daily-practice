/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 * <p>
 * 求最大回文串
 * 往字符串插入标记，消除奇偶数影响，遍历每个点，向两边扩散，判断是否为回文串，更新最大值
 */


public class P5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        String res = longestPalindrome("bb");
        System.out.println(res);
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] c = new char[s.length() * 2 + 1];
        for (int i = 0; i < s.length(); i++) {
            c[2 * i] = s.charAt(i);
            c[2 * i + 1] = '*';
        }
        c[2 * s.length()] = '*';
        int maxLength = 0, curLength = 1, point = 0;
        for (int i = 0; i < c.length; i++) {
            int step = 1;
            while (i - step >= 0 && i + step < c.length) {
                if (c[i - step] == c[i + step]) {
                    curLength = step;
                    if (maxLength < curLength) {
                        maxLength = curLength;
                        point = i;
                    }
                    step++;
                } else {
                    break;
                }
            }
        }

        return new String(c).substring(point - maxLength, point + maxLength + 1).replace("*", "");

    }

}
