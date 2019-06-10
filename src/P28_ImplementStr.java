import java.util.regex.Pattern;

/**
 * Created by jiaqi on 2019/6/10 4:13 PM
 * <p>
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's strstr() and Java's indexOf().
 */
public class P28_ImplementStr {

    public static int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0) return 0;
        if (needle.length() == 0) return 0;
        if (haystack.length() == needle.length()) {
            if (haystack.equals(needle)) {
                return 0;
            } else {
                return -1;
            }
        }
        if (haystack.length() < needle.length()) return -1;
        boolean res = false;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) && haystack.substring(i).length() >= needle.length()) {
                res = isMatch(haystack.substring(i,i+needle.length()), needle);
                if (res) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static boolean isMatch(String s1, String s2) {
        for (int i = 0; i < s2.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "a";
        int res = strStr(s1, s2);
        System.out.println(res);
    }

}
