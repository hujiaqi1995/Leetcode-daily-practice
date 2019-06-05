import java.util.Stack;

/**
 * Created by jiaqi on 2019/6/5 9:14 PM
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 */
public class P20_ValidParentheses {

    public static boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        char tmp;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    tmp = stack.pop();
                    switch (c) {
                        case ')':
                            if (tmp != '(') return false;
                            break;
                        case ']':
                            if (tmp != '[') return false;
                            break;
                        case '}':
                            if (tmp != '{') return false;
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        String str = "(]";
        System.out.println(isValid(str));
    }
}
