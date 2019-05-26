import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * <p>
 * 踩坑：使用map会导致相同键值覆盖
 */

public class P1_TowSum {

    public static int[] twoSum(int[] arr, int target) {
        int[] marr = Arrays.copyOf(arr,arr.length);
        Arrays.sort(marr);
        int start = 0, end = arr.length - 1, a, b, temp;
        while (start < end) {
            temp = marr[start] + marr[end];
            if (temp == target) {
                a = marr[start];
                b = marr[end];
                return new int[]{find(arr, a,true), find(arr, b,false)};
            }
            if (temp < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[]{-1, -1};
    }

    public static int find(int[] arr, int a, boolean dir) {
        if (dir) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == a) {
                    return i;
                }
            }
        } else {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] == a) {
                    return i;
                }
            }
        }

        return -1;
    }

    // 解决key覆盖问题
    public static int[] twoSum2(int[] arr, int target) {
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(arr[i],i);
        }

        int b;
        for (int i = 0; i < n; i++) {
            b = target - arr[i];
            if (map.containsKey(b) && map.get(b) != i) {
                return new int[]{i, map.get(b)};
            }
        }
        throw new IllegalArgumentException("no solution!");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().replace("[", "").replace("]", "").split(",");
        int n = strs.length;
        int target = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(strs[i]);
        }
        int[] res = twoSum2(arr, target);
        System.out.println(res[0] + " " + res[1]);
    }

}
