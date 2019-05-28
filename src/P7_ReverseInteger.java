/**
 * Created by jiaqi on 2019/5/28 9:42 PM
 * <p>
 * <p>
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * <p>
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * <p>
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class P7_ReverseInteger {
    public int reverse(int x) {
        int res = 0, max = Integer.MAX_VALUE;
        boolean isPositive = x > 0;
        String strNum;
        if (-10 < x && x < 10) return x;
        if (!isPositive) {
            if (x == Integer.MIN_VALUE) {
                return 0;
            }
            x = -x;
        }
        while (x % 10 == 0 && x > 0) {
            x /= 10;
        }
        //注意：反转之后的数可能比 2^31 - 1 要大
        strNum = reverse(String.valueOf(x));
        if (strNum.length() >= String.valueOf(max).length()) {
            // 比较前面 n - 1 位
            int temp = Integer.valueOf(strNum.substring(0, strNum.length() - 1));
            if (temp > max / 10) {
                return 0;
            } else if (temp == max / 10) {
                // 位数相等比较最后一位
                if (Integer.valueOf(strNum.substring(strNum.length() - 1)) > max % 10) {
                    return 0;
                }
            }
        }
        res = Integer.valueOf(strNum);
        return isPositive ? res : -res;
    }

    public String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        P7_ReverseInteger reverseInteger = new P7_ReverseInteger();
        int res = reverseInteger.reverse(1363847412);
        System.out.println(res);

    }
}
