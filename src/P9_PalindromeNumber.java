/**
 * Created by jiaqi on 2019/5/29 10:37 PM
 * <p>
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 * <p>
 * Coud you solve it without converting the integer to a string?
 */
public class P9_PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String str = String.valueOf(x);
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P9_PalindromeNumber palindromeNumber = new P9_PalindromeNumber();
        boolean res = palindromeNumber.isPalindrome(-121);
        System.out.println(res);
    }
}
