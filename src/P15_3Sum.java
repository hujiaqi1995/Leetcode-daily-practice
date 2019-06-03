import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by jiaqi on 2019/5/31 8:43 PM
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * [-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]
 */
public class P15_3Sum {
    private List<List<Integer>> threeSum2(int[] num) {
        int high = num.length - 1, target = 0;
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(num);
        for (int i = 0; i < high - 1; i++) {
            if (i == 0 || num[i] != num[i - 1]) {
                int lo = i + 1, hi = high, sum = target - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> positives = new ArrayList<>();
        List<Integer> zeros = new ArrayList<>();
        List<Integer> negetives = new ArrayList<>();
        for (int n : nums) {
            if (n > 0) {
                positives.add(n);
            } else if (n == 0) {
                zeros.add(n);
            } else {
                negetives.add(n);
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        positives.sort(Comparator.naturalOrder());
        negetives.sort(Comparator.naturalOrder());

        // 有0
        if (zeros.size() > 0) {
            // 有3个0 或以上，加上[0, 0, 0]这种方案
            if (zeros.size() >= 3) {
                list.add(Arrays.asList(0, 0, 0));
            }
            if (positives.size() == 0 || negetives.size() == 0) {
                return list;
            }
            int p = 0, n = negetives.size() - 1;
            while (p < positives.size() && n >= 0) {
                int a = positives.get(p), b = negetives.get(n);
                if (a + b == 0) {
                    List<Integer> temp = Arrays.asList(b, 0, a);
                    list.add(temp);
                    while (p < positives.size() && a == positives.get(p)) {
                        p++;
                    }
                    while (n >= 0 && b == negetives.get(n)) {
                        n--;
                    }
                } else if (positives.get(p) + negetives.get(n) < 0) {
                    p++;
                } else {
                    n--;
                }
            }
        }
        // 没有0 -- 1正2负 1负2正
        int pos, neg, last = -1;

        for (int i = 0; i < positives.size(); i++) {
            pos = positives.get(i);
            if (pos == last) continue;
            last = pos;
            List<List<Integer>> res = find(negetives, pos);
            for (int j = 0; j < res.size(); j++) {
                list.add(res.get(j));
            }
        }
        last = 1;
        for (int i = 0; i < negetives.size(); i++) {
            neg = negetives.get(i);
            if (neg == last) continue;
            last = neg;
            List<List<Integer>> res = find(positives, neg);
            for (int j = 0; j < res.size(); j++) {
                list.add(res.get(j));
            }
        }
        return list;

    }

    private List<List<Integer>> find(List<Integer> list, int sum) {
        sum = -sum;
        int start = 0, end = list.size() - 1, temp;
        List<List<Integer>> res = new ArrayList<>();
        while (start < end) {
            temp = list.get(start) + list.get(end);
            if (temp > sum) {
                end--;
            } else if (temp < sum) {
                start++;
            } else {
                int a = list.get(start), b = list.get(end);
                res.add(Arrays.asList(a, b, -sum));
//                System.out.println(Arrays.asList(a, b, -sum));
                while (start + 1 <= end) {
                    if (a == list.get(start + 1)) {
                        start++;
                    } else {
                        start++;
                        break;
                    }
                }
                while (start <= end - 1) {
                    if (b == list.get(end - 1)) {
                        end--;
                    } else {
                        end--;
                        break;
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        P15_3Sum sum = new P15_3Sum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = sum.threeSum2(nums);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }
}
