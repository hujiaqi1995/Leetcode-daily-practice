import java.util.Scanner;

/**
 * Created by jiaqi on 2019/5/31 8:32 PM
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 */
public class P14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            res = commonPrefix(res, strs[i]);
        }
        return res;
    }

    private String commonPrefix(String str1, String str2) {
        int n = Math.min(str1.length(), str2.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                sb.append(str1.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine()
                .replace("[", "")
                .replace("]","")
                .replace("\"","")
                .split(",");

        P14_LongestCommonPrefix longestCommonPrefix = new P14_LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }
}
