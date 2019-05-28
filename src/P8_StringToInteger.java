/**
 * Created by jiaqi on 2019/5/28 10:23 PM
 * <p>
 * Implement atoi which converts a string to an integer.
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 * and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number,
 * which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * <p>
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 * <p>
 * Input: "42"
 * Output: 42
 * Example 2:
 * <p>
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * <p>
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 * <p>
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * <p>
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−2^31) is returned.
 *
 * 巨坑！！
 */
public class P8_StringToInteger {
    public int myAtoi(String str) {
        // 无效或者以字母开头，直接返回0
        if (str == null) return 0;
        str = str.trim();
        if (str.length() == 0 || !check(str.charAt(0))) return 0;
        // 以正负开头
        boolean isPositive = true;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            if (str.length() == 1) return 0;
            // 同时包含 +，- 为非法
            if (str.charAt(0) == '+' && str.charAt(1)=='-' || str.charAt(0)=='-' && str.charAt(1)=='+') return 0;
            if (str.charAt(0) == '+') {
                isPositive = true;
            } else {
                isPositive = false;
            }
            str = str.substring(1);
        }
        // 处理小数，取整 和 中间夹字母的
        str = dealAlpha(str);

        // 处理非法数字
        str = str.replaceAll("[^0-9]", "");
        if (str.length() == 0) return 0;
        // 处理前面的0
        str = dealFrontZero(str);
        if (str == "0") return 0;
        // 判断大小
        int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE, max_Len = String.valueOf(max).length();
        if (str.length() >= max_Len) {
            if (str.length() > max_Len) return isPositive ? max : min;
            // 长度相等比较前 n-1 位
            if (isPositive) {
                if (Integer.valueOf(str.substring(0, str.length() - 1)) > max / 10
                        ||  Integer.valueOf(str.substring(0, str.length() - 1)) == max / 10
                        && Integer.valueOf(str.substring(str.length() - 1)) >= max % 10
                ) {
                    return max;
                }
            } else {
                int temp = Integer.valueOf(str.substring(0, str.length() - 1));
                int lastNum = Integer.valueOf(str.substring(str.length() - 1));
                int lastNum_m = -(min % 10);
                if (temp > -(min / 10) || temp == -(min / 10) && lastNum >= lastNum_m) {
                    return min;
                }
            }

        }
        return isPositive ? Integer.valueOf(str) : -Integer.valueOf(str);

    }

    public boolean check(char c) {
        return c >= '0' && c <= '9' || c == '+' || c == '-';
    }

    public String dealFrontZero(String str) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                flag = true;
                index = i;
                break;
            }
        }
        for (int i = index; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }
        if (flag) {
            return sb.toString();
        } else {
            return "0";
        }
    }

    public String dealAlpha(String alpha) {
        int index = -1;
        for (int i = 0; i < alpha.length(); i++) {
            if (alpha.charAt(i) >= '0' && alpha.charAt(i) <= '9') {
                continue;
            } else {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return alpha;
        }
        return alpha.substring(0, index);
    }


    public static void main(String[] args) {
        int res = new P8_StringToInteger().myAtoi("-1126297758d8");
        System.out.println(res);
    }


}
