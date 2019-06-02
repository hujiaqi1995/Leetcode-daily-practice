import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiaqi on 2019/6/2 1:58 PM
 * <p>
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * map
 * 2: [a, b, c]
 * 3: [d, e, f]
 * 4: [g, h, i]
 * 5: [j, k, l]
 * 6: [m, n, o]
 * 7: [p, q, r, s]
 * 8: [t, u, v]
 * 9: [w, x, y, z]
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * Note:
 * <p>
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class P17_LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) return list;
        Map<Character, String> map = generateDictionary();
        dfs(list, digits, map, 0, "");
        return list;

    }

    private void dfs(List<String> list, String digits, Map<Character, String> map, int start, String s) {
        if (start == digits.length()) {
            list.add(s);
            return;
        }

        String dic = map.get(digits.charAt(start));
        for (int i = 0; i < dic.length(); i++) {
            dfs(list, digits, map, start + 1, s + dic.charAt(i));
        }
    }

    private Map<Character, String> generateDictionary() {
        Map<Character, String> map = new HashMap<>(8);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }

    public static void main(String[] args) {
        P17_LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new P17_LetterCombinationsOfAPhoneNumber();
        List<String> res = letterCombinationsOfAPhoneNumber.letterCombinations("23");
        System.out.println(res);

    }
}
