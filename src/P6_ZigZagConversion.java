/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * 思路：先找周期 T = 2n -2， 最上面一层表示为 kT + 1 （k >= 0）, 第二层为 kT + 2 ...
 */


public class P6_ZigZagConversion {
    public static void main(String[] args) {
        String test = "PAYPALISHIRING";
        String res = convert(test, 3);
        System.out.println(res);


    }

    public static String convert(String s, int numRows) {
        if (s == null || s.length() < 2 || numRows == 1) return s;
        int t = numRows * 2 - 2, count = s.length() / t, temp = 0;
        if (s.length() % t > 0) count++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < count; j++) {
                if (j * t + i < s.length()) {
                    sb.append(s.charAt(j * t + i));
                    if (i != 0 && i != numRows - 1) {
                        temp = j * t + (t - i);
                        if (temp < s.length()) {
                            sb.append(s.charAt(temp));
                        }
                    }
                }
            }
        }
        return sb.toString();

    }

}
