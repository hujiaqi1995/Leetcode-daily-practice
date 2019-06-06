import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaqi on 2019/6/6 4:56 PM
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class P22_GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private static void dfs(List<String> list, StringBuilder sb, int n1, int n2, int n) {
        if (n1 == n && n2 == n) {
            list.add(sb.toString());
        }
        if (n1 < n) {
            dfs(list, sb.append('('), n1 + 1, n2, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (n1 > n2) {
            dfs(list, sb.append(')'), n1, n2 + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
